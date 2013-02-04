// Output created by jacc on Sun Feb 03 19:29:29 CET 2013

package org.uva.sea.ql.parser.jacc;

interface QLTokens {
    int ENDINPUT = 0;
    int AND = 1;
    int BOOL = 2;
    int BOOL_VAL = 3;
    int EQ = 4;
    int FORM = 5;
    int GEQ = 6;
    int IDENT = 7;
    int IF = 8;
    int INT = 9;
    int INT_VAL = 10;
    int LEQ = 11;
    int MON = 12;
    int MON_VAL = 13;
    int NEQ = 14;
    int OR = 15;
    int STR = 16;
    int STRING_VAL = 17;
    int UMIN = 18;
    int UNOT = 19;
    int UPLUS = 20;
    int error = 21;
    // '!' (code=33)
    // '(' (code=40)
    // ')' (code=41)
    // '*' (code=42)
    // '+' (code=43)
    // '-' (code=45)
    // '/' (code=47)
    // ';' (code=59)
    // '<' (code=60)
    // '=' (code=61)
    // '>' (code=62)
    // '{' (code=123)
    // '}' (code=125)
}
