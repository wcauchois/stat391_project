#!/usr/bin/env python
"""De-duplication on classified.csv. Prints the result to stdout,
its up to you to >a.tmp && mv a.tmp classified.csv"""
from config import CLASSIFIED_CSV
from loaddata import read_csv

COLUMNS = ['name', 'text', 'label']

if __name__ == '__main__':
  print ','.join(COLUMNS)
  data = read_csv(open(CLASSIFIED_CSV, 'r'))
  seen_text = set()
  for datum in data:
    if 'text' not in datum:
      continue
    if datum['text'] in seen_text:
      continue
    else:
      seen_text.add(datum['text'])
    row = []
    for col in COLUMNS:
      row.append(datum[col])
    print ','.join(row)
