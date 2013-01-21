// Output created by jacc on Sun Jan 20 21:30:03 CET 2013

package org.uva.sea.ql.parser.jacc;

interface QLTokens {
    int ENDINPUT = 0;
    int AND = 1;
    int BOOL = 2;
    int DT_BOOLEAN = 3;
    int DT_INTEGER = 4;
    int DT_MONEY = 5;
    int DT_TEXT = 6;
    int EQ = 7;
    int FORM = 8;
    int GEQ = 9;
    int IDENT = 10;
    int IF = 11;
    int INT = 12;
    int LEQ = 13;
    int NEQ = 14;
    int OR = 15;
    int TEXT = 16;
    int UMIN = 17;
    int UNOT = 18;
    int UPLUS = 19;
    int error = 20;
    // '!' (code=33)
    // '"' (code=34)
    // '(' (code=40)
    // ')' (code=41)
    // '*' (code=42)
    // '+' (code=43)
    // '-' (code=45)
    // '/' (code=47)
    // ':' (code=58)
    // '<' (code=60)
    // '>' (code=62)
    // '{' (code=123)
    // '}' (code=125)
}
