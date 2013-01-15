lexer grammar QL;
@header {
package org.uva.sea.ql.parser.antlr;
}

T__9 : '!' ;
T__10 : '!=' ;
T__11 : '&&' ;
T__12 : '(' ;
T__13 : ')' ;
T__14 : '*' ;
T__15 : '+' ;
T__16 : '-' ;
T__17 : '/' ;
T__18 : ':' ;
T__19 : '<' ;
T__20 : '<=' ;
T__21 : '==' ;
T__22 : '>' ;
T__23 : '>=' ;
T__24 : 'form' ;
T__25 : 'if' ;
T__26 : '{' ;
T__27 : '||' ;
T__28 : '}' ;

// $ANTLR src "/Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g" 111
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;// $ANTLR src "/Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g" 114
COMMENT 
     : '/*' .* '*/' {$channel=HIDDEN;}
    ;// $ANTLR src "/Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g" 118
Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;// $ANTLR src "/Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g" 120
Int: ('0'..'9')+;// $ANTLR src "/Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g" 122
String: '"' .* '"';