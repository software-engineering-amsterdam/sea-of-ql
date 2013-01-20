// Output created by jacc on Sun Jan 20 15:03:23 GMT 2013

package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;

class Parser implements Tokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private org.uva.sea.ql.ast.Node[] yysv;
    private org.uva.sea.ql.ast.Node yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new org.uva.sea.ql.ast.Node[yyss];
        yytok = (lexer.getToken()
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 52:
                    switch (yytok) {
                        case FORM:
                            yyn = 2;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 53:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 104;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 54:
                    switch (yytok) {
                        case STRINGLITERAL:
                            yyn = 3;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 55:
                    switch (yytok) {
                        case IF:
                            yyn = 8;
                            continue;
                        case STRINGLITERAL:
                            yyn = 9;
                            continue;
                        case ENDINPUT:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 56:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 57:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 58:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 59:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 60:
                    yyn = yys8();
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 61:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 19;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 62:
                    yyn = yys10();
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 63:
                    yyn = yys11();
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 64:
                    yyn = yys12();
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 65:
                    yyn = yys13();
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 66:
                    yyn = yys14();
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 67:
                    yyn = yys15();
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 68:
                    yyn = yys16();
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 69:
                    yyn = yys17();
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 70:
                    yyn = yys18();
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
                    switch (yytok) {
                        case ':':
                            yyn = 31;
                            continue;
                        case '=':
                            yyn = 32;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    yyn = yys20();
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    yyn = yys21();
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 75:
                    yyn = yys23();
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    yyn = yys24();
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 77:
                    yyn = yys25();
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case IF:
                            yyn = 8;
                            continue;
                        case STRINGLITERAL:
                            yyn = 9;
                            continue;
                        case '}':
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 80:
                    yyn = yys28();
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    yyn = yys29();
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    switch (yytok) {
                        case TYPE:
                            yyn = 42;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    switch (yytok) {
                        case '}':
                            yyn = 44;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    switch (yytok) {
                        case '}':
                            yyn = 45;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    switch (yytok) {
                        case ELSE:
                            yyn = 46;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    switch (yytok) {
                        case '{':
                            yyn = 47;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    switch (yytok) {
                        case IF:
                            yyn = 8;
                            continue;
                        case STRINGLITERAL:
                            yyn = 9;
                            continue;
                        case '}':
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    switch (yytok) {
                        case '}':
                            yyn = 50;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    switch (yytok) {
                        case '}':
                            yyn = 51;
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 107;
                    continue;

                case 104:
                    return true;
                case 105:
                    yyerror("stack overflow");
                case 106:
                    return false;
                case 107:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        org.uva.sea.ql.ast.Node[] newyysv = new org.uva.sea.ql.ast.Node[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys8() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys10() {
        switch (yytok) {
            case AND:
                return 20;
            case OR:
                return 21;
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case '{':
                return 26;
        }
        return 107;
    }

    private int yys11() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr28();
        }
        return 107;
    }

    private int yys12() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr29();
        }
        return 107;
    }

    private int yys13() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr26();
        }
        return 107;
    }

    private int yys14() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr27();
        }
        return 107;
    }

    private int yys15() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys16() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys17() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys18() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys20() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys21() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys22() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys23() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys24() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys25() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys27() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr19();
        }
        return 107;
    }

    private int yys28() {
        switch (yytok) {
            case AND:
                return 20;
            case OR:
                return 21;
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case ')':
                return 41;
        }
        return 107;
    }

    private int yys29() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr17();
        }
        return 107;
    }

    private int yys30() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr18();
        }
        return 107;
    }

    private int yys32() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 11;
            case IDENTIFIER:
                return 12;
            case NUMBERLITERAL:
                return 13;
            case STRINGLITERAL:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 107;
    }

    private int yys33() {
        switch (yytok) {
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case OR:
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr24();
        }
        return 107;
    }

    private int yys34() {
        switch (yytok) {
            case AND:
                return 20;
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case OR:
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
                return yyr25();
        }
        return 107;
    }

    private int yys35() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr20();
        }
        return 107;
    }

    private int yys36() {
        switch (yytok) {
            case '*':
                return 22;
            case '/':
                return 25;
            case OR:
            case '-':
            case '+':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr22();
        }
        return 107;
    }

    private int yys37() {
        switch (yytok) {
            case '*':
                return 22;
            case '/':
                return 25;
            case OR:
            case '-':
            case '+':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr23();
        }
        return 107;
    }

    private int yys38() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr21();
        }
        return 107;
    }

    private int yys41() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case AND:
                return yyr30();
        }
        return 107;
    }

    private int yys43() {
        switch (yytok) {
            case AND:
                return 20;
            case OR:
                return 21;
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case ENDINPUT:
            case '}':
                return yyr9();
        }
        return 107;
    }

    private int yyr1() { // form : FORM STRINGLITERAL statement
        { result = new Form(lexer.location(), ((StringLiteral)yysv[yysp-2]), ((Statement)yysv[yysp-1]));  }
        yysv[yysp-=3] = yyrv;
        return 1;
    }

    private int yyr17() { // expression : '+' expression
        { yyrv = new UnaryPlus(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr18() { // expression : '-' expression
        { yyrv = new UnaryMinus(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr19() { // expression : '!' expression
        { yyrv = new UnaryNot(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr20() { // expression : expression '*' expression
        { yyrv = new Multiplication(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr21() { // expression : expression '/' expression
        { yyrv = new Division(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr22() { // expression : expression '+' expression
        { yyrv = new Addition(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr23() { // expression : expression '-' expression
        { yyrv = new Subtraction(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]));}
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr24() { // expression : expression AND expression
        { yyrv = new And(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr25() { // expression : expression OR expression
        { yyrv = new Or(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr26() { // expression : NUMBERLITERAL
        { yyrv = ((NumberLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr27() { // expression : STRINGLITERAL
        { yyrv = ((StringLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr28() { // expression : BOOLEANLITERAL
        { yyrv = ((BooleanLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr29() { // expression : IDENTIFIER
        { yyrv = ((Identifier)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr30() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 25: return 38;
            case 24: return 37;
            case 23: return 36;
            case 22: return 35;
            case 21: return 34;
            case 20: return 33;
            case 18: return 30;
            case 17: return 29;
            case 16: return 28;
            case 15: return 27;
            case 8: return 10;
            default: return 43;
        }
    }

    private int yyr6() { // closedstatement : question
        yysp -= 1;
        return yypclosedstatement();
    }

    private int yyr7() { // closedstatement : IF expression '{' closedstatement '}' ELSE '{' closedstatement '}'
        { yyrv = new If(lexer.location(), ((Expression)yysv[yysp-8]), yysv[yysp-6], yysv[yysp-2]); }
        yysv[yysp-=9] = yyrv;
        return yypclosedstatement();
    }

    private int yypclosedstatement() {
        switch (yyst[yysp-1]) {
            case 26: return 39;
            case 3: return 4;
            default: return 48;
        }
    }

    private int yyr4() { // openstatement : IF expression '{' statement '}'
        { yyrv = new If(lexer.location(), ((Expression)yysv[yysp-4]), ((Statement)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return yypopenstatement();
    }

    private int yyr5() { // openstatement : IF expression '{' closedstatement '}' ELSE '{' openstatement '}'
        { yyrv = new If(lexer.location(), ((Expression)yysv[yysp-8]), yysv[yysp-6], yysv[yysp-2]); }
        yysv[yysp-=9] = yyrv;
        return yypopenstatement();
    }

    private int yypopenstatement() {
        switch (yyst[yysp-1]) {
            case 47: return 49;
            default: return 5;
        }
    }

    private int yyr8() { // question : STRINGLITERAL IDENTIFIER ':' TYPE
        { yyrv = new Question(lexer.location(), ((StringLiteral)yysv[yysp-4]), ((Identifier)yysv[yysp-3]), ((TypeDeclaration)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 6;
    }

    private int yyr9() { // question : STRINGLITERAL IDENTIFIER '=' expression
        { yyrv = new Question(lexer.location(), ((StringLiteral)yysv[yysp-4]), ((Identifier)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 6;
    }

    private int yyr10() { // question : /* empty */
        return 6;
    }

    private int yyr2() { // statement : openstatement
        yysp -= 1;
        return yypstatement();
    }

    private int yyr3() { // statement : closedstatement
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 3: return 7;
            default: return 40;
        }
    }

    protected String[] yyerrmsgs = {
    };

private Lexer lexer; 

private Node result;

public Node getResult() {
  return result;
}

public Parser(Lexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

private static Statement chainStatements(Statement... statements) {
                BlockStatement block = null;
                for (Statement s : statements) {
                        if (s instanceof BlockStatement) {
                                block = (BlockStatement) s;
                                break;
                        }
                }
                if (block == null) {
                        block = new BlockStatement(statements[0], statements);
                } else {
                        for (Statement s : statements) {
                                if (s != block) {
                                        block.addChild(s);
                                }
                        }
                }
                return block;
        }

}
