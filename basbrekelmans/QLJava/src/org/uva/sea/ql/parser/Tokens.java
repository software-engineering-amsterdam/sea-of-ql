// Output created by jacc on Mon Jan 14 17:12:26 CET 2013

package org.uva.sea.ql.parser;

interface Tokens {
    int ENDINPUT = 0;
    int AND = 1;
    int BOOLEANLITERAL = 2;
    int ELSE = 3;
    int EQ = 4;
    int FORM = 5;
    int GEQ = 6;
    int IDENTIFIER = 7;
    int IF = 8;
    int LEQ = 9;
    int NEQ = 10;
    int NEW = 11;
    int NUMBERLITERAL = 12;
    int OR = 13;
    int STRINGLITERAL = 14;
    int TYPE = 15;
    int UMIN = 16;
    int UNOT = 17;
    int UPLUS = 18;
    int error = 19;
    // '!' (code=33)
    // '(' (code=40)
    // ')' (code=41)
    // '*' (code=42)
    // '+' (code=43)
    // '-' (code=45)
    // '/' (code=47)
    // ':' (code=58)
    // ';' (code=59)
    // '<' (code=60)
    // '=' (code=61)
    // '>' (code=62)
    // '{' (code=123)
    // '}' (code=125)
}
