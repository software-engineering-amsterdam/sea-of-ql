// Output created by jacc on Mon Jan 14 22:54:57 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.statement.*;

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
                case 49:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 50:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 98;
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 51:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 52:
                    yyn = yys3();
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 53:
                    yyn = yys4();
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
                case 54:
                    yyn = yys5();
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
                case 55:
                    switch (yytok) {
                        case '(':
                            yyn = 26;
                            continue;
                    }
                    yyn = 101;
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
                case 56:
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
                case 57:
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
                case 58:
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
                case 59:
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
                case 60:
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
                case 61:
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
                case 62:
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
                case 63:
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
                case 64:
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
                case 65:
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
                case 66:
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
                case 67:
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
                case 68:
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
                case 69:
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
                case 70:
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
                case 71:
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
                case 72:
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
                case 73:
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
                case 74:
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
                case 75:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 77:
                    yyn = yys28();
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    yyn = yys29();
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 80:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
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
                case 93:
                    yyn = yys44();
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
                case 94:
                    switch (yytok) {
                        case '{':
                            yyn = 46;
                            continue;
                    }
                    yyn = 101;
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
                case 95:
                    switch (yytok) {
                        case IF:
                            yyn = 6;
                            continue;
                        case '}':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    switch (yytok) {
                        case '}':
                            yyn = 48;
                            continue;
                    }
                    yyn = 101;
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
                case 97:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 101;
                    continue;

                case 98:
                    return true;
                case 99:
                    yyerror("stack overflow");
                case 100:
                    return false;
                case 101:
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
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case IF:
                return 6;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
            case ENDINPUT:
                return yyr4();
        }
        return 101;
    }

    private int yys3() {
        switch (yytok) {
            case AND:
                return 14;
            case EQ:
                return 15;
            case GEQ:
                return 16;
            case LEQ:
                return 17;
            case NEQ:
                return 18;
            case OR:
                return 19;
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case '<':
                return 24;
            case '>':
                return 25;
            case ENDINPUT:
                return yyr2();
        }
        return 101;
    }

    private int yys4() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr20();
        }
        return 101;
    }

    private int yys5() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr24();
        }
        return 101;
    }

    private int yys7() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr22();
        }
        return 101;
    }

    private int yys8() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr21();
        }
        return 101;
    }

    private int yys9() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr23();
        }
        return 101;
    }

    private int yys10() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys11() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys12() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys13() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys14() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys15() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys16() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys17() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys18() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys19() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys20() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys21() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys22() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys23() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys24() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys25() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys26() {
        switch (yytok) {
            case BOOL:
                return 4;
            case IDENT:
                return 5;
            case INT:
                return 7;
            case MON:
                return 8;
            case STR:
                return 9;
            case '!':
                return 10;
            case '(':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
        }
        return 101;
    }

    private int yys27() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr7();
        }
        return 101;
    }

    private int yys28() {
        switch (yytok) {
            case AND:
                return 14;
            case EQ:
                return 15;
            case GEQ:
                return 16;
            case LEQ:
                return 17;
            case NEQ:
                return 18;
            case OR:
                return 19;
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case '<':
                return 24;
            case '>':
                return 25;
            case ')':
                return 44;
        }
        return 101;
    }

    private int yys29() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr5();
        }
        return 101;
    }

    private int yys30() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr6();
        }
        return 101;
    }

    private int yys31() {
        switch (yytok) {
            case EQ:
                return 15;
            case GEQ:
                return 16;
            case LEQ:
                return 17;
            case NEQ:
                return 18;
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case '<':
                return 24;
            case '>':
                return 25;
            case ENDINPUT:
            case OR:
            case ')':
            case AND:
                return yyr18();
        }
        return 101;
    }

    private int yys32() {
        switch (yytok) {
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case OR:
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr12();
        }
        return 101;
    }

    private int yys33() {
        switch (yytok) {
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case OR:
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr16();
        }
        return 101;
    }

    private int yys34() {
        switch (yytok) {
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case OR:
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr17();
        }
        return 101;
    }

    private int yys35() {
        switch (yytok) {
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case OR:
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr13();
        }
        return 101;
    }

    private int yys36() {
        switch (yytok) {
            case AND:
                return 14;
            case EQ:
                return 15;
            case GEQ:
                return 16;
            case LEQ:
                return 17;
            case NEQ:
                return 18;
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case '<':
                return 24;
            case '>':
                return 25;
            case ENDINPUT:
            case OR:
            case ')':
                return yyr19();
        }
        return 101;
    }

    private int yys37() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr8();
        }
        return 101;
    }

    private int yys38() {
        switch (yytok) {
            case '*':
                return 20;
            case '/':
                return 23;
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr10();
        }
        return 101;
    }

    private int yys39() {
        switch (yytok) {
            case '*':
                return 20;
            case '/':
                return 23;
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr11();
        }
        return 101;
    }

    private int yys40() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr9();
        }
        return 101;
    }

    private int yys41() {
        switch (yytok) {
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case OR:
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr15();
        }
        return 101;
    }

    private int yys42() {
        switch (yytok) {
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case OR:
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr14();
        }
        return 101;
    }

    private int yys43() {
        switch (yytok) {
            case AND:
                return 14;
            case EQ:
                return 15;
            case GEQ:
                return 16;
            case LEQ:
                return 17;
            case NEQ:
                return 18;
            case OR:
                return 19;
            case '*':
                return 20;
            case '+':
                return 21;
            case '-':
                return 22;
            case '/':
                return 23;
            case '<':
                return 24;
            case '>':
                return 25;
            case ')':
                return 45;
        }
        return 101;
    }

    private int yys44() {
        switch (yytok) {
            case ENDINPUT:
            case '>':
            case '<':
            case EQ:
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case ')':
            case LEQ:
            case GEQ:
            case AND:
                return yyr25();
        }
        return 101;
    }

    private int yyr1() { // top : statement
        { result = ((Statement)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr2() { // top : expression
        { result = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr3() { // statement : IF '(' expression ')' '{' statement '}'
        { yyrv = new If( ((Expression)yysv[yysp-5]), ((Statement)yysv[yysp-2]) ); }
        yysv[yysp-=7] = yyrv;
        return yypstatement();
    }

    private int yyr4() { // statement : /* empty */
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 0: return 2;
            default: return 47;
        }
    }

    private int yyr5() { // expression : '+' expression
        { yyrv = new Pos( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr6() { // expression : '-' expression
        { yyrv = new Neg( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr7() { // expression : '!' expression
        { yyrv = new Not( ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr8() { // expression : expression '*' expression
        { yyrv = new Mul( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr9() { // expression : expression '/' expression
        { yyrv = new Div( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr10() { // expression : expression '+' expression
        { yyrv = new Add( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr11() { // expression : expression '-' expression
        { yyrv = new Sub( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr12() { // expression : expression EQ expression
        { yyrv = new Eq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr13() { // expression : expression NEQ expression
        { yyrv = new NEq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr14() { // expression : expression '>' expression
        { yyrv = new GT( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr15() { // expression : expression '<' expression
        { yyrv = new LT( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr16() { // expression : expression GEQ expression
        { yyrv = new GEq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr17() { // expression : expression LEQ expression
        { yyrv = new LEq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr18() { // expression : expression AND expression
        { yyrv = new And( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr19() { // expression : expression OR expression
        { yyrv = new Or( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr20() { // expression : BOOL
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Bool)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr21() { // expression : MON
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Money)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr22() { // expression : INT
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr23() { // expression : STR
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Str)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr24() { // expression : IDENT
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr25() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 25: return 42;
            case 24: return 41;
            case 23: return 40;
            case 22: return 39;
            case 21: return 38;
            case 20: return 37;
            case 19: return 36;
            case 18: return 35;
            case 17: return 34;
            case 16: return 33;
            case 15: return 32;
            case 14: return 31;
            case 13: return 30;
            case 12: return 29;
            case 11: return 28;
            case 10: return 27;
            case 0: return 3;
            default: return 43;
        }
    }

    protected String[] yyerrmsgs = {
    };

    /**
     * Holds the lexer.
     */
    private QLLexer lexer;
    
    /**
     * Holds the parsing result (AST)
     */
    private ASTNode result;
    
    /**
     * Retrieves the generated AST.
     *
     * @return The AST.
     */
    public ASTNode getResult() {
        return result;
    }
    
    /**
     * Sets the lexer.
     *
     * @param lexer
     */
    public QLParser( QLLexer lexer ) { 
        this.lexer = lexer;
    }
    
    /**
     * Output error message.
     *
     * @param msg The error message.
     */
    private void yyerror( String msg ) { 
        System.err.println( msg );
    }

}
