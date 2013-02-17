// Output created by jacc on Sat Feb 16 22:18:40 CET 2013

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
    int MONEY = 13;
    int NEQ = 14;
    int OR = 15;
    int STR = 16;
    int TRUE = 17;
    int UMIN = 18;
    int UNOT = 19;
    int UPLUS = 20;
    int error = 21;
    int tBool = 22;
    int tIdent = 23;
    int tInt = 24;
    int tMoney = 25;
    int tStr = 26;
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
