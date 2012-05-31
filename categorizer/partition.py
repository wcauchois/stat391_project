#!/usr/bin/env python
"""
Partitions the positive/negative tweets from the output of prep_data.py into
training and test data sets. By default this uses a 80-20 training/test ratio,
but this can be customized via command line arguments.
"""

import sys, os, random, shutil
from optparse import OptionParser

def flatten(labeled_data_dir):
    tweets = []

    for category in os.listdir(labeled_data_dir):
        tweets += ([(category, tweet) for tweet in os.listdir(os.path.join(labeled_data_dir, category))])

    return tweets

def partition(train_percentage, labeled_data_dir):
    all_samples = flatten(labeled_data_dir)

    training_samples = int(0.01 * train_percentage * len(all_samples))
    training_set = random.sample(all_samples, training_samples)
    test_set = list(set(all_samples) - set(training_set))
    
    return (training_set, test_set)

def dump_set(tweet_set, in_dir, out_dir):
    for (category, tweet_file) in tweet_set:
        category_out_dir = os.path.join(out_dir, category)
        
        if not os.path.exists(category_out_dir):
            os.mkdir(category_out_dir)

        shutil.copy(os.path.join(in_dir, category, tweet_file), os.path.join(category_out_dir, tweet_file))

if __name__ == '__main__':
    parser = OptionParser(usage='usage: %prog [options] labeled_data_dir train_dir test_dir')
    parser.add_option("-p", "--train_percentage", dest="train_percentage",
                  help="use <percentage> of the data set as training data (default is 80)",
                  metavar="<percentage>",
                  type="int",
                  default=80)
    parser.add_option("-k", "--keep_data_dirs", dest="keep_data_dirs", action="store_true",
                  help="Do not delete the contents of the training and test directories before partitioning")
    (opts, args) = parser.parse_args()

    if len(args) != 3:
        parser.print_help()
        sys.exit(1)

    if not opts.keep_data_dirs:
        shutil.rmtree(args[1])
        shutil.rmtree(args[2])

        os.mkdir(args[1])
        os.mkdir(args[2])

    training_set, test_set = partition(opts.train_percentage, args[0])
    dump_set(training_set, args[0], args[1])
    dump_set(test_set, args[0], args[2])
    