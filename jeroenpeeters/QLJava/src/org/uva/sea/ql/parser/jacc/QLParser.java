// Output created by jacc on Sun Jan 20 13:56:30 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.literals.*;

class QLParser implements QLTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private org.uva.sea.ql.ast.ASTNode[] yysv;
    private org.uva.sea.ql.ast.ASTNode yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new org.uva.sea.ql.ast.ASTNode[yyss];
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
                case 61:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 62:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 122;
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 63:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 64:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 65:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 66:
                    switch (yytok) {
                        case IDENT:
                            yyn = 24;
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 67:
                    yyn = yys6();
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 68:
                    yyn = yys7();
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
                case 69:
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
                case 70:
                    yyn = yys9();
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
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
                case 72:
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
                case 73:
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
                case 74:
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
                case 75:
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
                case 76:
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
                case 77:
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
                case 78:
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
                case 79:
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
                case 80:
                    yyn = yys19();
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
                case 81:
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
                case 82:
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
                case 83:
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
                case 84:
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
                case 85:
                    switch (yytok) {
                        case '{':
                            yyn = 43;
                            continue;
                    }
                    yyn = 125;
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
                case 86:
                    switch (yytok) {
                        case TEXT:
                            yyn = 44;
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    yyn = yys28();
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    yyn = yys29();
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    switch (yytok) {
                        case IDENT:
                            yyn = 50;
                            continue;
                        case IF:
                            yyn = 51;
                            continue;
                    }
                    yyn = 125;
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
                case 105:
                    switch (yytok) {
                        case IDENT:
                            yyn = 52;
                            continue;
                    }
                    yyn = 125;
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
                case 106:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case IDENT:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case IDENT:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case IDENT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    switch (yytok) {
                        case IDENT:
                            yyn = 50;
                            continue;
                        case IF:
                            yyn = 51;
                            continue;
                        case '}':
                            yyn = 54;
                            continue;
                    }
                    yyn = 125;
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
                case 111:
                    switch (yytok) {
                        case ':':
                            yyn = 25;
                            continue;
                    }
                    yyn = 125;
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
                case 112:
                    switch (yytok) {
                        case '(':
                            yyn = 55;
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case IDENT:
                            yyn = yyr28();
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case IDENT:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    switch (yytok) {
                        case '{':
                            yyn = 58;
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    switch (yytok) {
                        case IDENT:
                            yyn = 50;
                            continue;
                        case IF:
                            yyn = 51;
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
                    switch (yytok) {
                        case IDENT:
                            yyn = 50;
                            continue;
                        case IF:
                            yyn = 51;
                            continue;
                        case '}':
                            yyn = 60;
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case IDENT:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 125;
                    continue;

                case 122:
                    return true;
                case 123:
                    yyerror("stack overflow");
                case 124:
                    return false;
                case 125:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        org.uva.sea.ql.ast.ASTNode[] newyysv = new org.uva.sea.ql.ast.ASTNode[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys0() {
        switch (yytok) {
            case FORM:
                return 5;
            case IDENT:
                return 6;
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
        }
        return 125;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 12;
            case EQ:
                return 13;
            case GEQ:
                return 14;
            case LEQ:
                return 15;
            case NEQ:
                return 16;
            case OR:
                return 17;
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case '<':
                return 22;
            case '>':
                return 23;
            case ENDINPUT:
                return yyr2();
        }
        return 125;
    }

    private int yys6() {
        switch (yytok) {
            case ':':
                return 25;
            case ENDINPUT:
            case '>':
            case '<':
            case '/':
            case '-':
            case '+':
            case '*':
            case OR:
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr26();
        }
        return 125;
    }

    private int yys7() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case '*':
            case '/':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr25();
        }
        return 125;
    }

    private int yys8() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys9() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys10() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys11() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys12() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys13() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys14() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys15() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys16() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys17() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys18() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys19() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys20() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys21() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys22() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys23() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys26() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case '*':
            case '/':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr12();
        }
        return 125;
    }

    private int yys27() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case '*':
            case '/':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr26();
        }
        return 125;
    }

    private int yys28() {
        switch (yytok) {
            case AND:
                return 12;
            case EQ:
                return 13;
            case GEQ:
                return 14;
            case LEQ:
                return 15;
            case NEQ:
                return 16;
            case OR:
                return 17;
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case '<':
                return 22;
            case '>':
                return 23;
            case ')':
                return 45;
        }
        return 125;
    }

    private int yys29() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case '*':
            case '/':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr10();
        }
        return 125;
    }

    private int yys30() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case '*':
            case '/':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr11();
        }
        return 125;
    }

    private int yys31() {
        switch (yytok) {
            case EQ:
                return 13;
            case GEQ:
                return 14;
            case LEQ:
                return 15;
            case NEQ:
                return 16;
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case '<':
                return 22;
            case '>':
                return 23;
            case ENDINPUT:
            case OR:
            case ')':
            case AND:
                return yyr23();
        }
        return 125;
    }

    private int yys32() {
        switch (yytok) {
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr17();
        }
        return 125;
    }

    private int yys33() {
        switch (yytok) {
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr21();
        }
        return 125;
    }

    private int yys34() {
        switch (yytok) {
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr22();
        }
        return 125;
    }

    private int yys35() {
        switch (yytok) {
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr18();
        }
        return 125;
    }

    private int yys36() {
        switch (yytok) {
            case AND:
                return 12;
            case EQ:
                return 13;
            case GEQ:
                return 14;
            case LEQ:
                return 15;
            case NEQ:
                return 16;
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case '<':
                return 22;
            case '>':
                return 23;
            case ENDINPUT:
            case OR:
            case ')':
                return yyr24();
        }
        return 125;
    }

    private int yys37() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case '*':
            case '/':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr13();
        }
        return 125;
    }

    private int yys38() {
        switch (yytok) {
            case '*':
                return 18;
            case '/':
                return 21;
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr15();
        }
        return 125;
    }

    private int yys39() {
        switch (yytok) {
            case '*':
                return 18;
            case '/':
                return 21;
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr16();
        }
        return 125;
    }

    private int yys40() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case '*':
            case '/':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr14();
        }
        return 125;
    }

    private int yys41() {
        switch (yytok) {
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr20();
        }
        return 125;
    }

    private int yys42() {
        switch (yytok) {
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr19();
        }
        return 125;
    }

    private int yys45() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case '-':
            case '+':
            case '*':
            case '/':
            case OR:
            case ')':
            case NEQ:
            case LEQ:
            case GEQ:
            case EQ:
            case AND:
                return yyr27();
        }
        return 125;
    }

    private int yys55() {
        switch (yytok) {
            case INT:
                return 7;
            case '!':
                return 8;
            case '(':
                return 9;
            case '+':
                return 10;
            case '-':
                return 11;
            case IDENT:
                return 27;
        }
        return 125;
    }

    private int yys56() {
        switch (yytok) {
            case AND:
                return 12;
            case EQ:
                return 13;
            case GEQ:
                return 14;
            case LEQ:
                return 15;
            case NEQ:
                return 16;
            case OR:
                return 17;
            case '*':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case '/':
                return 21;
            case '<':
                return 22;
            case '>':
                return 23;
            case ')':
                return 57;
        }
        return 125;
    }

    private int yyr1() { // top : frm
        { result = ((Form)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr2() { // top : expr
        { result = ((Expr)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr3() { // top : quest
        { result = ((Question)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr10() { // expr : '+' expr
        { yyrv = new Pos(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr11() { // expr : '-' expr
        { yyrv = new Neg(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr12() { // expr : '!' expr
        { yyrv = new Not(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : expr '*' expr
        { yyrv = new Mul(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : expr '/' expr
        { yyrv = new Div(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : expr '+' expr
        { yyrv = new Add(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : expr '-' expr
        { yyrv = new Sub(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : expr EQ expr
        { yyrv = new Eq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : expr NEQ expr
        { yyrv = new NEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : expr '>' expr
        { yyrv = new GT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : expr '<' expr
        { yyrv = new LT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr21() { // expr : expr GEQ expr
        { yyrv = new GEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr22() { // expr : expr LEQ expr
        { yyrv = new LEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr23() { // expr : expr AND expr
        { yyrv = new And(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr24() { // expr : expr OR expr
        { yyrv = new Or(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr25() { // expr : INT
        { yyrv = ((Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr26() { // expr : IDENT
        { yyrv = ((Ident)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr27() { // expr : '(' expr ')'
        { yyrv = ((Expr)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 23: return 42;
            case 22: return 41;
            case 21: return 40;
            case 20: return 39;
            case 19: return 38;
            case 18: return 37;
            case 17: return 36;
            case 16: return 35;
            case 15: return 34;
            case 14: return 33;
            case 13: return 32;
            case 12: return 31;
            case 11: return 30;
            case 10: return 29;
            case 9: return 28;
            case 8: return 26;
            case 0: return 2;
            default: return 56;
        }
    }

    private int yyr4() { // frm : FORM IDENT '{' cmpnd_stmnt '}'
        { yyrv = new Form(((Ident)yysv[yysp-4]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 3;
    }

    private int yyr9() { // if_stmnt : IF '(' expr ')' '{' cmpnd_stmnt '}'
        { yyrv = new If(((Expr)yysv[yysp-5]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 46;
    }

    private int yyr28() { // quest : IDENT ':' TEXT IDENT
        { yyrv = new Question(((Ident)yysv[yysp-4]), ((Text)yysv[yysp-2]), ((Ident)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        switch (yyst[yysp-1]) {
            case 0: return 4;
            default: return 47;
        }
    }

    private int yyr7() { // stmnt : if_stmnt
        { yyrv = ((If)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypstmnt();
    }

    private int yyr8() { // stmnt : quest
        { yyrv = ((Question)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypstmnt();
    }

    private int yypstmnt() {
        switch (yyst[yysp-1]) {
            case 58: return 48;
            case 43: return 48;
            default: return 53;
        }
    }

    private int yyr5() { // cmpnd_stmnt : stmnt
        { yyrv = new CompoundStatement(((Expr)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypcmpnd_stmnt();
    }

    private int yyr6() { // cmpnd_stmnt : cmpnd_stmnt stmnt
        { ((CompoundStatement)yysv[yysp-2]).add(((Expr)yysv[yysp-1])); yyrv = ((CompoundStatement)yysv[yysp-2]); }
        yysv[yysp-=2] = yyrv;
        return yypcmpnd_stmnt();
    }

    private int yypcmpnd_stmnt() {
        switch (yyst[yysp-1]) {
            case 43: return 49;
            default: return 59;
        }
    }

    protected String[] yyerrmsgs = {
    };


private QLLexer lexer; 

private Expr result;

public Expr getResult() {
  return result;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
