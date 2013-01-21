// Output created by jacc on Mon Jan 21 01:56:43 CET 2013

package org.uva.sea.ql.parser.jacc;

interface QLTokens {
    int ENDINPUT = 0;
    int AND = 1;
    int EQ = 2;
    int GEQ = 3;
    int IDENT = 4;
    int INT = 5;
    int LEQ = 6;
    int NEQ = 7;
    int OR = 8;
    int STR = 9;
    int UMIN = 10;
    int UNOT = 11;
    int UPLUS = 12;
    int error = 13;
    // '!' (code=33)
    // '(' (code=40)
    // ')' (code=41)
    // '*' (code=42)
    // '+' (code=43)
    // '-' (code=45)
    // '/' (code=47)
    // ':' (code=58)
    // '<' (code=60)
    // '>' (code=62)
}
