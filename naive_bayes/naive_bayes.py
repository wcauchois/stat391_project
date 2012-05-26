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

try:
    import psyco
    psyco.full()
    print 'Using psyco JIT'
except ImportError:
    pass

PUNCTUATION = '.,;:\'\"?/\\()*&^%$#@![]{}|><-+_'

NOTIFY = False

DOC_RE = re.compile('.+\.txt$')

def normalize_token(token):
    """
    Normalize a token by stripping punctuation from either end and removing
    invalid characters (anything with an ASCII code outside the range
    [32, 126]).
    """
    return ''.join(x for x in token.lower().strip(PUNCTUATION) \
                   if ord(x) >= 32 and ord(x) <= 126)

def is_valid_token(token):
    """
    Return whether a token should be considered by Naive Bayes or not.
    Currently, empty tokens and tokens consisting entirely of punctuation
    are discounted.
    """
    return not (token == '' or all(x in PUNCTUATION for x in token))

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

    def tokens_for_text(self, text):
        """
        Return all normalized, valid tokens for a string of text.
        """
        all_tokens = map(normalize_token, text.split())
        return filter(is_valid_token, all_tokens)

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
            for token in self.tokens_for_text(text):
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
        tokens = self.tokens_for_text(text)
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
        num_correct, num_examples = 0, 0
        for filename, category in examples:
            hypothesis = self.classify_doc(filename)[0]
            if category == hypothesis:
                num_correct += 1
            num_examples += 1

        return float(num_correct) / float(num_examples)

if __name__ == '__main__':
    parser = OptionParser(
               usage='usage: %prog [options] training_dir [test_dir]')
    parser.add_option('-i', '--interactive',
      dest='interactive', action='store_true', default=False,
      help='Interactively classify text fragments')
    (opts, args) = parser.parse_args()
    if len(args) < 1:
        parser.print_help()
        sys.exit(1)

    nb = NaiveBayes()

    print 'Learning on training data...'
    nb.learn(os.listdir(args[0]), docs(args[0]))
    print 'Finished learning'
    # don't output individual accuracies for the training data
    accuracy = nb.test_on(docs(args[0]))
    print 'Accuracy on the training set was %.2f%%' % (accuracy * 100.0)
    if len(args) > 1:
        accuracy = nb.test_on(docs(args[1]))
        print 'Accuracy on the test set was %.2f%%' % (accuracy * 100.0)
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
