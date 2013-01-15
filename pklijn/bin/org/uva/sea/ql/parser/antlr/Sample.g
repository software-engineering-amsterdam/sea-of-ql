grammar Sample;

options {
  language = Java;
}

@header {
  package org.uva.sea.ql.parser.antlr;
}

@lexer::header {
  package org.uva.sea.ql.parser.antlr;
}

program
  : 'program' IDENT '='
    'begin'
    'end' IDENT '.'
  ;

IDENT : (('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*);
WS : (' ' | '\t' | '\n' | '\r' | '\f')+;
