ops = [
    'add', 'sub', 'mul', 'div', 'lt', 'leq', 'eq', 'neq', 'geq', 'gt', 'and', 'or'
    ]

types = {
    'int'   : {
      'unary' : ['not'],
      'binary' : ['and', 'or']
      },
    'str'   : {
      'unary' : ['pos', 'neg', 'not'],
      'binary' : ['sub', 'mul', 'div', 'lt', 'leq', 'geq', 'gt', 'and', 'or']
      },
    'bool'  : {
      'unary' : ['pos', 'neg'],
      'binary' : ['add', 'sub', 'mul', 'div', 'lt', 'leq', 'geq', 'gt']
      }
    }

type_perms = [
    ('int', 'int'),
    ('int', 'bool'),
    ('int', 'str'),
    ('bool', 'bool'),
    ('bool', 'str'),
    ('str', 'str')
    ]

def cap(s):
  return s[:1].upper() + s[1:]

def build_u_method(t, op):
  print "\t@Test(expected=UnsupportedOperationException.class)"
  print "\tpublic void test%s%s() {" % (cap(op), cap(t))
  print "\t\t%sVal.%s();" % (t, op)
  print "\t}"
  print ""

def build_b_method(t, s, op):
  print "\t@Test(expected=UnsupportedOperationException.class)"
  print "\tpublic void test%s%s%s() {" % (cap(t), cap(op), cap(s))
  print "\t\t%sVal.%s(%sVal);" % (t, op, s)
  print "\t}"
  print ""


def same_type(t):
  counter_same = 0
  for op in types[t]['unary']:
    build_u_method(t, op)
    counter_same = counter_same + 1
  for op in types[t]['binary']:
    build_b_method(t, t, op)
    counter_same = counter_same + 1
  return counter_same

def diff_type(t, s):
  counter_diff = 0
  for op in ops:
    build_b_method(t, s, op)
    counter_diff = counter_diff + 1
    build_b_method(s, t, op)
    counter_diff = counter_diff + 1
  return counter_diff

def start():
  counter = 0
  for (t,s) in type_perms:
    if t == s:
      # unary stuff here
      counter = counter + same_type(t)
      pass
    else:
      # put binary stuff here
      counter = counter + diff_type(t, s)
  print "methods generated: %d" % counter

start()
