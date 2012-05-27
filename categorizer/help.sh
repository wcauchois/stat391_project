#!/bin/bash
for x in `ls *.py`; do
  echo "$x"
  python -c "print '','',__import__('`echo $x | sed "s/\.py//"`').__doc__"
  echo
done
