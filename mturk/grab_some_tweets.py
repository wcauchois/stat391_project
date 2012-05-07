import twitter
import subprocess
from StringIO import StringIO
import time
import sys

TARGET_N = 20
SLEEP_AMOUNT = 5 # don't want to hit the twitter api too hard

def detect_lang(s):
  p = subprocess.Popen(['./run_categorizer.sh'],
        shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE)
  return p.communicate(s)[0].strip()

def remove_non_ascii(s):
  return ''.join(x for x in s if ord(x) < 128)

def clean_text(s):
  return remove_non_ascii(s).replace('\n', ' ').replace(',', ' ').replace('\t', ' ')

if __name__ == '__main__':
  api = twitter.Api()
  tweets = list()
  last_id = None
  while len(tweets) < TARGET_N:
    statuses = api.GetPublicTimeline(since_id=last_id)
    last_id = statuses[-1].id
    count = 0
    for s in statuses:
      cleaned_text = clean_text(s.text)
      if detect_lang(cleaned_text) == 'english':
        count += 1
        tweets.append((remove_non_ascii(s.user.name), cleaned_text))
    print >>sys.stderr, 'Got %d tweets' % count
    time.sleep(SLEEP_AMOUNT)

  print 'name,text'
  for name, text in tweets:
    print '%s,%s' % (name, text.replace(',', ' '))
