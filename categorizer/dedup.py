#!/usr/bin/env python
import os, sys
import cPickle as pickle

FNAME = __import__('config').TOPROCESS_P
if __name__ == '__main__':
  to_process = pickle.load(open(FNAME, 'rb'))
  print 'Length before dedup: %d' % len(to_process)
  to_process_prime = []
  for tweet in to_process:
    if 'text' not in tweet:
      continue
    found = False
    for tweet_prime in to_process_prime:
      if 'text' not in tweet_prime:
        continue
      if tweet_prime['text'] == tweet['text']:
        found = True
        break
    if not found:
      to_process_prime.append(tweet)
  print 'Length after dedup: %d' % len(to_process_prime)
  pickle.dump(to_process_prime, open(FNAME, 'wb'))
