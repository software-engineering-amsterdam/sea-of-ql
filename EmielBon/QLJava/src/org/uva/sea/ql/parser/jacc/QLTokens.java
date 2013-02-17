// Output created by jacc on Sun Feb 17 17:13:06 CET 2013

package org.uva.sea.ql.parser.jacc;

interface QLTokens {
    int ENDINPUT = 0;
    int AND = 1;
    int BOOLEAN = 2;
    int BOOLEANLITERAL = 3;
    int EQ = 4;
    int FORM = 5;
    int GEQ = 6;
    int IDENTIFIER = 7;
    int IF = 8;
    int INTEGER = 9;
    int INTEGERLITERAL = 10;
    int LEQ = 11;
    int MONEY = 12;
    int NEQ = 13;
    int OR = 14;
    int STRING = 15;
    int STRINGLITERAL = 16;
    int UMIN = 17;
    int UNOT = 18;
    int UPLUS = 19;
    int error = 20;
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
    // '>' (code=62)
    // '{' (code=123)
    // '}' (code=125)
}
