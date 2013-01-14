// Output created by jacc on Mon Jan 14 12:20:54 CET 2013

package org.uva.sea.ql.parser.jacc;

interface QLTokens {
    int ENDINPUT = 0;
    int AND = 1;
    int BOOL = 2;
    int EQ = 3;
    int GEQ = 4;
    int IDENT = 5;
    int INT = 6;
    int LEQ = 7;
    int NEQ = 8;
    int OR = 9;
    int STR = 10;
    int UMIN = 11;
    int UNOT = 12;
    int UPLUS = 13;
    int error = 14;
    // '!' (code=33)
    // '(' (code=40)
    // ')' (code=41)
    // '*' (code=42)
    // '+' (code=43)
    // '-' (code=45)
    // '/' (code=47)
    // '<' (code=60)
    // '>' (code=62)
}
