#!/usr/bin/env python
"""
Naive Bayes classification.

By Bill Cauchois, for CSE 446.
Tweaked by Henry Baba-Weiss, for STAT 391.
"""

import os, math, sys, re
import itertools
import random
from optparse import OptionParser
import cPickle as pickle
from collections import defaultdict
from pprint import pprint

try:
    import psyco
    psyco.full()
    print >>sys.stderr, 'Using psyco JIT'
except ImportError:
    pass

NOTIFY = False

DOC_RE = re.compile('.+\.txt$')

def valid_char(c):
    return c and ord(c) >= 32 and ord(c) <= 126 and c != '&'

# Normalize by removing invalid characters (anything with an ASCII code
# outside the range [32, 126]).
#return filter( lambda x: x and ord(x) >= 32 and ord(x) <= 126 and x != '&' \
# Split on spaces, and then split on all non-alphabetical characters,
# except '&'.
def parse_tokens(input):
    dirty_tokens = sum([x.split(r'([^\w\&]+)') for x in input.split()], [])
    tokens = []
    for t in dirty_tokens:
        tokens.append(''.join(filter(valid_char, t)))
    return tokens

# >>> example = "hello, world & how are you! :) ... &lt;&gt;&lt;"
# >>> parse_tokens(example)
# 'hello', ',', 'world', '&', 'how', 'are', 'you', '!', ':)', '...', '&lt', ';', '&gt', ';', '&lt', ';'

def docs(data_dir):
    'Generate a tuple (filename, label) for every document in data_dir.'
    categories = os.listdir(data_dir)
    for category in categories:
        for filename in os.listdir(os.path.join(data_dir, category)):
            if DOC_RE.match(filename):
                yield (os.path.join(data_dir, category, filename), category)

def read_file(filename):
    with open(filename, 'r') as file:
        return file.read()

class ZeroDict(dict):
    'Like a regular dict, but if a key is not present its assumed to be 0.'
    def __getitem__(self, key):
        try:
            return super(ZeroDict, self).__getitem__(key)
        except KeyError:
            self[key] = 0
            return 0

class NaiveBayes:
    'Implements the Naive Bayes algorithm for text classification.'

    def __init__(self):
        """
        Initialize Naive Bayes.
        """
        self.cache = {}

#        return filter(is_valid_token, all_tokens)

    class Category:
        def __init__(self, label):
            self.label = label
            self.freqs = ZeroDict()
            self.num_words, self.num_docs = 0, 0
            # note that probabilities are stored as the log base 2 of the
            # actual probability.

            self.prob = 0 # prior probability of this category
            self.prob_word = {} # maps <word> to the probability that <word>
                                # will be present given that the document is
                                # in this category.
        def to_dict(self):
          return {
            'label': self.label,
            'freqs': dict(self.freqs),
            'num_words': self.num_words,
            'num_docs': self.num_docs,
            'prob': self.prob,
            'prob_word': self.prob_word
          }
        
        @classmethod
        def from_dict(cls, d):
          c = cls(d['label'])
          c.freqs = ZeroDict(d['freqs'])
          c.num_words = d['num_words']
          c.num_docs = d['num_docs']
          c.prob = d['prob']
          c.prob_word = d['prob_word']
          return c

    def to_dict(self):
      cats = {}
      for label, cat in self.categories.iteritems():
        cats[label] = cat.to_dict()
      return {
        'categories': cats,
        'vocab': self.vocab
      }

    @classmethod
    def from_dict(cls, d):
      nb = cls()
      cats = {}
      for label, cat in d['categories'].iteritems():
        cats[label] = cls.Category.from_dict(cat)
      nb.categories = cats
      nb.vocab = d['vocab']
      return nb

    def precache(self, examples):
        for filename, _ in examples:
            if filename not in self.cache:
                self.cache[filename] = read_file(filename)

    def get_text(self, filename):
        return self.cache.get(filename) or read_file(filename)

    def learn(self, labels, examples):
        examples = list(examples)
        self.precache(examples)
        self.categories = {}
        for label in labels:
            self.categories[label] = self.Category(label)
        self.vocab = set()

        # calculate word frequencies in each of the training examples
        for filename, label in examples:
            category = self.categories[label]
            text = self.get_text(filename)
            for token in parse_tokens(text):
                category.freqs[token] += 1
                self.vocab.add(token)
                category.num_words += 1
            category.num_docs += 1

        self.calculate_probabilities()

    def calculate_probabilities(self, freq_transform=lambda x: x):
        num_total_docs = \
          sum(C.num_docs for C in self.categories.itervalues())
        for category in self.categories.itervalues():
            prob = float(category.num_docs) / num_total_docs
            category.prob = math.log(prob, 2)
            category.prob_word = {}
            for word in self.vocab:
                prob_word = \
                  float(freq_transform(category.freqs.get(word, 0)) + 1) / \
                    (category.num_words + len(self.vocab))
                if prob_word > 0:
                    category.prob_word[word] = math.log(prob_word, 2)
            # del category.freqs

    def classify_doc(self, filename):
        'Classify a document. Same return value as classify_str().'

        return self.classify_str(self.get_text(filename))

    def classify_str(self, text):
        tokens = parse_tokens(text)
        probs = {}
        for label, category in self.categories.iteritems():
            probs[label] = category.prob
            for token in tokens:
                if token not in self.vocab:
                    continue
                probs[label] += category.prob_word[token]
        argmax = max(probs.iteritems(), key=lambda x: x[1])
        return argmax

    def test_on(self, examples):
        """
        Determine the overall accuracy of this classifier given a testing
        data set.
        """
        stats = defaultdict(int)
        num_correct, num_examples = 0, 0
        for filename, category in examples:
            hypothesis = self.classify_doc(filename)[0]
            if category == 'positive':
              stats['total_real_pos'] += 1
            elif category == 'negative':
              stats['total_real_neg'] += 1
            stats['total_examples'] += 1
            if category == hypothesis:
                if category == 'positive':
                  stats['pos_correctly_classified'] += 1
                else:
                  stats['neg_correctly_classified'] += 1
                num_correct += 1
            else:
                if category == 'positive' and hypothesis == 'negative':
                  stats['pos_classified_as_neg'] += 1
                elif category == 'negative' and hypothesis == 'positive':
                  stats['neg_classified_as_pos'] += 1
            num_examples += 1

        return ((float(num_correct) / float(num_examples)), stats)

if __name__ == '__main__':
    parser = OptionParser(
               usage='usage: %prog [options] training_dir [test_dir]')
    parser.add_option('-i', '--interactive',
      dest='interactive', action='store_true', default=False,
      help='Interactively classify text fragments')
    parser.add_option('-m', '--model', default=None,
      dest='model', help='Save the model (or if in interactive mode, load it)',
      metavar='MODEL')
    (opts, args) = parser.parse_args()
    if len(args) < 1 and not opts.interactive:
        parser.print_help()
        sys.exit(1)

    if opts.interactive:
      if opts.model is None:
        print 'Please provide a model'
        sys.exit(1)
      d = pickle.load(open(opts.model, 'rb'))
      nb = NaiveBayes.from_dict(d)
      text = sys.stdin.read()
      print nb.classify_str(text)[0]
      sys.exit(0)

    nb = NaiveBayes()

    print 'Learning on training data...'
    nb.learn(os.listdir(args[0]), docs(args[0]))
    if opts.model is not None:
      print 'Saving model to %s' % opts.model
      with open(opts.model, 'wb') as f:
        pickle.dump(nb.to_dict(), f)
    print 'Finished learning'
    # don't output individual accuracies for the training data
    accuracy, stats = nb.test_on(docs(args[0]))
    print 'Accuracy on the training set was %.2f%%' % (accuracy * 100.0)
    pprint(dict(stats))
    if len(args) > 1:
        accuracy, stats = nb.test_on(docs(args[1]))
        print 'Accuracy on the test set was %.2f%%' % (accuracy * 100.0)
        pprint(dict(stats))
    if opts.interactive:
        print 'Entering interactive mode'
        while True:
            print '>>> ',
            try:
                print nb.classify_str(raw_input())[0]
            except EOFError:
                print
                break
    elif NOTIFY:
        os.system('notify-send "Naive Bayes Finished" "%s"' % \
          ' '.join(sys.argv))
