// Output created by jacc on Tue Feb 26 09:54:12 CET 2013

package parser;

interface QLTokens {
    int ENDINPUT = 0;
    int AND = 1;
    int BOOL = 2;
    int ELSE = 3;
    int EQ = 4;
    int FALSE = 5;
    int FORM = 6;
    int GEQ = 7;
    int IDENT = 8;
    int IF = 9;
    int INT = 10;
    int LEQ = 11;
    int NEQ = 12;
    int OR = 13;
    int STR = 14;
    int TRUE = 15;
    int UMIN = 16;
    int UNOT = 17;
    int UPLUS = 18;
    int error = 19;
    int tBool = 20;
    int tIdent = 21;
    int tInt = 22;
    int tStr = 23;
    // '!' (code=33)
    // '(' (code=40)
    // ')' (code=41)
    // '*' (code=42)
    // '+' (code=43)
    // '-' (code=45)
    // '/' (code=47)
    // ':' (code=58)
    // '<' (code=60)
    // '=' (code=61)
    // '>' (code=62)
    // '{' (code=123)
    // '}' (code=125)
}
