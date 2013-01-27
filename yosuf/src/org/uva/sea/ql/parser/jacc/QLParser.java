// Output created by jacc on Sun Jan 27 13:15:57 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;

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
                case 53:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 54:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 106;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 55:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 56:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr22();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 57:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr21();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 58:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 109;
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
                case 59:
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
                case 60:
                    switch (yytok) {
                        case '(':
                            yyn = 26;
                            continue;
                    }
                    yyn = 109;
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
                case 61:
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
                case 62:
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
                case 63:
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
                case 64:
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
                case 65:
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
                case 66:
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
                case 67:
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
                case 68:
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
                case 69:
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
                case 70:
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
                case 71:
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
                case 72:
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
                case 73:
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
                case 74:
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
                case 75:
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
                case 76:
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
                case 77:
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
                case 78:
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
                case 79:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 80:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    yyn = yys28();
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    yyn = yys29();
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    yyn = yys45();
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
                case 99:
                    yyn = yys46();
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
                case 100:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr23();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    switch (yytok) {
                        case '{':
                            yyn = 49;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    switch (yytok) {
                        case IF:
                            yyn = 7;
                            continue;
                        case IDENT:
                            yyn = 51;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    switch (yytok) {
                        case '}':
                            yyn = 52;
                            continue;
                    }
                    yyn = 109;
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
                case 104:
                    switch (yytok) {
                        case '=':
                            yyn = 25;
                            continue;
                    }
                    yyn = 109;
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
                case 105:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr24();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 106:
                    return true;
                case 107:
                    yyerror("stack overflow");
                case 108:
                    return false;
                case 109:
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
            case IDENT:
                return 6;
            case IF:
                return 7;
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
        }
        return 109;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 13;
            case EQ:
                return 14;
            case GEQ:
                return 15;
            case LEQ:
                return 16;
            case NEQ:
                return 17;
            case OR:
                return 18;
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '<':
                return 23;
            case '>':
                return 24;
            case ENDINPUT:
                return yyr1();
        }
        return 109;
    }

    private int yys6() {
        switch (yytok) {
            case '=':
                return 25;
            case LEQ:
            case ENDINPUT:
            case '>':
            case GEQ:
            case '<':
            case '/':
            case '-':
            case '+':
            case OR:
            case '*':
            case NEQ:
            case EQ:
            case AND:
                return yyr19();
        }
        return 109;
    }

    private int yys8() {
        switch (yytok) {
            case '{':
            case '!':
            case UNOT:
            case UPLUS:
            case IDENT:
            case '(':
            case '}':
            case '=':
            case IF:
            case UMIN:
            case INT:
            case error:
                return 109;
        }
        return yyr18();
    }

    private int yys9() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys10() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys11() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys12() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys13() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys14() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys15() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys16() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys17() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys18() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys19() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys20() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys21() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys22() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys23() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys24() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys25() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys26() {
        switch (yytok) {
            case INT:
                return 8;
            case '!':
                return 9;
            case '(':
                return 10;
            case '+':
                return 11;
            case '-':
                return 12;
            case IDENT:
                return 28;
        }
        return 109;
    }

    private int yys27() {
        switch (yytok) {
            case '{':
            case '!':
            case UNOT:
            case UPLUS:
            case IDENT:
            case '(':
            case '}':
            case '=':
            case IF:
            case UMIN:
            case INT:
            case error:
                return 109;
        }
        return yyr5();
    }

    private int yys28() {
        switch (yytok) {
            case '{':
            case '!':
            case UNOT:
            case UPLUS:
            case IDENT:
            case '(':
            case '}':
            case '=':
            case IF:
            case UMIN:
            case INT:
            case error:
                return 109;
        }
        return yyr19();
    }

    private int yys29() {
        switch (yytok) {
            case AND:
                return 13;
            case EQ:
                return 14;
            case GEQ:
                return 15;
            case LEQ:
                return 16;
            case NEQ:
                return 17;
            case OR:
                return 18;
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '<':
                return 23;
            case '>':
                return 24;
            case ')':
                return 46;
        }
        return 109;
    }

    private int yys30() {
        switch (yytok) {
            case '{':
            case '!':
            case UNOT:
            case UPLUS:
            case IDENT:
            case '(':
            case '}':
            case '=':
            case IF:
            case UMIN:
            case INT:
            case error:
                return 109;
        }
        return yyr3();
    }

    private int yys31() {
        switch (yytok) {
            case '{':
            case '!':
            case UNOT:
            case UPLUS:
            case IDENT:
            case '(':
            case '}':
            case '=':
            case IF:
            case UMIN:
            case INT:
            case error:
                return 109;
        }
        return yyr4();
    }

    private int yys32() {
        switch (yytok) {
            case EQ:
                return 14;
            case GEQ:
                return 15;
            case LEQ:
                return 16;
            case NEQ:
                return 17;
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '<':
                return 23;
            case '>':
                return 24;
            case ENDINPUT:
            case ';':
            case OR:
            case ')':
            case AND:
                return yyr16();
        }
        return 109;
    }

    private int yys33() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case LEQ:
            case ENDINPUT:
            case '>':
            case GEQ:
            case '<':
            case ';':
            case OR:
            case ')':
            case NEQ:
            case EQ:
            case AND:
                return yyr10();
        }
        return 109;
    }

    private int yys34() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case LEQ:
            case ENDINPUT:
            case '>':
            case GEQ:
            case '<':
            case ';':
            case OR:
            case ')':
            case NEQ:
            case EQ:
            case AND:
                return yyr14();
        }
        return 109;
    }

    private int yys35() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case LEQ:
            case ENDINPUT:
            case '>':
            case GEQ:
            case '<':
            case ';':
            case OR:
            case ')':
            case NEQ:
            case EQ:
            case AND:
                return yyr15();
        }
        return 109;
    }

    private int yys36() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case LEQ:
            case ENDINPUT:
            case '>':
            case GEQ:
            case '<':
            case ';':
            case OR:
            case ')':
            case NEQ:
            case EQ:
            case AND:
                return yyr11();
        }
        return 109;
    }

    private int yys37() {
        switch (yytok) {
            case AND:
                return 13;
            case EQ:
                return 14;
            case GEQ:
                return 15;
            case LEQ:
                return 16;
            case NEQ:
                return 17;
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '<':
                return 23;
            case '>':
                return 24;
            case ENDINPUT:
            case ';':
            case OR:
            case ')':
                return yyr17();
        }
        return 109;
    }

    private int yys38() {
        switch (yytok) {
            case '{':
            case '!':
            case UNOT:
            case UPLUS:
            case IDENT:
            case '(':
            case '}':
            case '=':
            case IF:
            case UMIN:
            case INT:
            case error:
                return 109;
        }
        return yyr6();
    }

    private int yys39() {
        switch (yytok) {
            case '!':
            case IDENT:
            case '(':
            case IF:
            case '}':
            case error:
            case '=':
            case UPLUS:
            case UMIN:
            case UNOT:
            case INT:
            case '{':
                return 109;
            case '*':
                return 19;
            case '/':
                return 22;
        }
        return yyr8();
    }

    private int yys40() {
        switch (yytok) {
            case '!':
            case IDENT:
            case '(':
            case IF:
            case '}':
            case error:
            case '=':
            case UPLUS:
            case UMIN:
            case UNOT:
            case INT:
            case '{':
                return 109;
            case '*':
                return 19;
            case '/':
                return 22;
        }
        return yyr9();
    }

    private int yys41() {
        switch (yytok) {
            case '{':
            case '!':
            case UNOT:
            case UPLUS:
            case IDENT:
            case '(':
            case '}':
            case '=':
            case IF:
            case UMIN:
            case INT:
            case error:
                return 109;
        }
        return yyr7();
    }

    private int yys42() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case LEQ:
            case ENDINPUT:
            case '>':
            case GEQ:
            case '<':
            case ';':
            case OR:
            case ')':
            case NEQ:
            case EQ:
            case AND:
                return yyr13();
        }
        return 109;
    }

    private int yys43() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case LEQ:
            case ENDINPUT:
            case '>':
            case GEQ:
            case '<':
            case ';':
            case OR:
            case ')':
            case NEQ:
            case EQ:
            case AND:
                return yyr12();
        }
        return 109;
    }

    private int yys44() {
        switch (yytok) {
            case AND:
                return 13;
            case EQ:
                return 14;
            case GEQ:
                return 15;
            case LEQ:
                return 16;
            case NEQ:
                return 17;
            case OR:
                return 18;
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '<':
                return 23;
            case '>':
                return 24;
            case ';':
                return 47;
        }
        return 109;
    }

    private int yys45() {
        switch (yytok) {
            case AND:
                return 13;
            case EQ:
                return 14;
            case GEQ:
                return 15;
            case LEQ:
                return 16;
            case NEQ:
                return 17;
            case OR:
                return 18;
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '<':
                return 23;
            case '>':
                return 24;
            case ')':
                return 48;
        }
        return 109;
    }

    private int yys46() {
        switch (yytok) {
            case '{':
            case '!':
            case UNOT:
            case UPLUS:
            case IDENT:
            case '(':
            case '}':
            case '=':
            case IF:
            case UMIN:
            case INT:
            case error:
                return 109;
        }
        return yyr20();
    }

    private int yyr1() { // top : expr
        { exprResult = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr2() { // top : compound
        { compoundResult = ((CompoundStatement)yysv[yysp-1]);  }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr3() { // expr : '+' expr
        { yyrv = new Positive(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr4() { // expr : '-' expr
        { yyrv = new Negative(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr5() { // expr : '!' expr
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr6() { // expr : expr '*' expr
        { yyrv = new Multiply(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr7() { // expr : expr '/' expr
        { yyrv = new Divide(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr8() { // expr : expr '+' expr
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr9() { // expr : expr '-' expr
        { yyrv = new Substitute(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr10() { // expr : expr EQ expr
        { yyrv = new Equals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr11() { // expr : expr NEQ expr
        { yyrv = new NotEquals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr12() { // expr : expr '>' expr
        { yyrv = new GreaterThan(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : expr '<' expr
        { yyrv = new SmallerThan(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : expr GEQ expr
        { yyrv = new GreaterOrEquals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : expr LEQ expr
        { yyrv = new SmallerOrEquals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : expr AND expr
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : expr OR expr
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : INT
        { yyrv = ((Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : IDENT
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : '(' expr ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 25: return 44;
            case 24: return 43;
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
            case 9: return 27;
            case 0: return 2;
            default: return 45;
        }
    }

    private int yyr24() { // ifStm : IF '(' expr ')' '{' compound '}'
        { yyrv = new IfStatement(((Expression)yysv[yysp-5]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 3;
    }

    private int yyr23() { // stm : IDENT '=' expr ';'
        { yyrv = new Assignment(yysv[yysp-4], ((Expression)yysv[yysp-2])); }
        yysv[yysp-=4] = yyrv;
        return 4;
    }

    private int yyr21() { // compound : stm
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypcompound();
    }

    private int yyr22() { // compound : ifStm
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypcompound();
    }

    private int yypcompound() {
        switch (yyst[yysp-1]) {
            case 0: return 5;
            default: return 50;
        }
    }

    protected String[] yyerrmsgs = {
    };


private QLLexer lexer; 
private Expression exprResult;
private CompoundStatement compoundResult;

public CompoundStatement getStatementResult(){
        return compoundResult;
}


public Expression getExprResult() {
  return exprResult;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
