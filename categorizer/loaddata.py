#!/usr/bin/env python
import os, sys
import cPickle as pickle

OUT_FILE = __import__('config').TOPROCESS_P

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

if __name__ == '__main__':
  if len(sys.argv) <= 1:
    print 'usage: %s FILES...' % sys.argv[0]
    sys.exit(0)
  if os.path.exists(OUT_FILE):
    print '%s already exists, rm before continuing' % OUT_FILE
    sys.exit(1)
  data = []
  for fname in sys.argv[1:]:
    data.extend(read_csv(open(fname, 'r')))
  pickle.dump(data, open(OUT_FILE, 'wb'))
