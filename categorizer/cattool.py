#!/usr/bin/python
"""The categorization tool. Reads tweets from toprocess.p, you type "n" or "p" for
negative or positive, it writes the labeled tweet to classified.csv and updates
toprocess.p so that the tweet is no longer present (i.e. state is saved between invocations)"""
import os, sys
import cPickle as pickle
from config import *

###############################################################################
# getch implementation from <http://code.activestate.com/recipes/134892/>
class _Getch:
  "Gets a single character from standard input.  Does not echo to the screen."
  def __init__(self):
    try:
      self.impl = _GetchWindows()
    except ImportError:
      self.impl = _GetchUnix()
  def __call__(self):
    return self.impl()
class _GetchUnix:
  def __init__(self):
    import tty, sys
  def __call__(self):
    import sys, tty, termios
    fd = sys.stdin.fileno()
    old_settings = termios.tcgetattr(fd)
    try:
      tty.setraw(sys.stdin.fileno())
      ch = sys.stdin.read(1)
    finally:
      termios.tcsetattr(fd, termios.TCSADRAIN, old_settings)
    return ch
class _GetchWindows:
  def __init__(self):
    import msvcrt
  def __call__(self):
    import msvcrt
    return msvcrt.getch()
getch = _Getch()
###############################################################################

if __name__ == '__main__':
  toprocess = pickle.load(open(TOPROCESS_P, 'rb'))
  print 'enter n for negative, p for positive'
  with open(CLASSIFIED_CSV, 'a') as classified_stream:
    while True:
      if len(toprocess) == 0:
        print 'you\'re done!!'
      print ('_' * 60)
      print ('v' * 60)
      datum = toprocess.pop()
      if 'text' not in datum:
        continue
      print datum['text']
      c = ''
      while c.lower() not in ('n', 'p', 'q'):
        c = getch()
      if c.lower() == 'n':
        print 'classified as NEGATIVE'
        label = 'negative'
      elif c.lower() == 'p':
        print 'classified as POSITIVE'
        label = 'positive'
      if c.lower() != 'q':
        classified_stream.write('%s\n' % ','.join([datum['name'], datum['text'], label]))
        classified_stream.flush()
        pickle.dump(toprocess, open(TOPROCESS_P, 'wb'))
      else:
        print '%d tweets left to classify' % len(toprocess)
        break
