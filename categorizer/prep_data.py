#!/usr/bin/env python
"""
Takes classified tweets in CSV and organizes them into the category/tweet format
expected by the Naive Bayes classifier.
"""

import sys, os
from optparse import OptionParser

def split_fields(line):
    return map(str.strip, line.split(','))

def read_csv(stream):
    line_iter = iter(stream.readlines())
    header = split_fields(line_iter.next())
    data = []
    for line in line_iter:
        fields = split_fields(line)
        datum = dict(zip(header, fields))
        data.append(datum)
    return data

def process_csv_dir(csv_dir):
    tweets = []

    for filename in os.listdir(csv_dir):
        if filename[-4:] == '.csv':
            with open(filename, 'r') as csv_file:
                tweets += read_csv(csv_file)

    return tweets

def format_tweets(tweets, out_dir):
    i = 0
    for tweet in tweets:
        label_dir = os.path.join(out_dir, tweet['label'])
        if not os.path.exists(label_dir):
            os.mkdir(label_dir)

        with open(os.path.join(label_dir, str(i) + '.txt'), 'w') as out_file:
            out_file.write(tweet['text'])

        i += 1

if __name__ == '__main__':
    parser = OptionParser(usage='usage: %prog input_dir output_dir')
    (opts, args) = parser.parse_args()

    if len(args) != 2:
        parser.print_help()
        sys.exit(1)

    tweets = process_csv_dir(args[0])
    format_tweets(tweets, args[1])
