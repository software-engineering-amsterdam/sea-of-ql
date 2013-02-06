// Output created by jacc on Tue Feb 05 18:55:09 CET 2013

package org.uva.sea.ql.parser.jacc;

interface QLTokens {
    int ENDINPUT = 0;
    int AND = 1;
    int BOOL = 2;
    int BOOL_VAL = 3;
    int ELSE = 4;
    int EQ = 5;
    int FORM = 6;
    int GEQ = 7;
    int IDENT = 8;
    int IF = 9;
    int INT = 10;
    int INT_VAL = 11;
    int LEQ = 12;
    int MON = 13;
    int MON_VAL = 14;
    int NEQ = 15;
    int OR = 16;
    int STR = 17;
    int STRING_VAL = 18;
    int UMIN = 19;
    int UNOT = 20;
    int UPLUS = 21;
    int error = 22;
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
