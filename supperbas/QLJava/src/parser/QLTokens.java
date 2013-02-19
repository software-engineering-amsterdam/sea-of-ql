// Output created by jacc on Tue Feb 19 08:29:50 CET 2013

package parser;

interface QLTokens {
    int ENDINPUT = 0;
    int AND = 1;
    int BOOL = 2;
    int ELSE = 3;
    int ELSEIF = 4;
    int EQ = 5;
    int FALSE = 6;
    int FORM = 7;
    int GEQ = 8;
    int IDENT = 9;
    int IF = 10;
    int INT = 11;
    int LEQ = 12;
    int NEQ = 13;
    int OR = 14;
    int STR = 15;
    int TRUE = 16;
    int UMIN = 17;
    int UNOT = 18;
    int UPLUS = 19;
    int error = 20;
    int tBool = 21;
    int tIdent = 22;
    int tInt = 23;
    int tStr = 24;
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
