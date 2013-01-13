// Output created by jacc on Fri Jan 11 13:00:04 CET 2013

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
    int UMIN = 9;
    int UNOT = 10;
    int UPLUS = 11;
    int error = 12;
    int BOOL = 13;
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
