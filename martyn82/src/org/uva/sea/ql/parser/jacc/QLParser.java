// Output created by jacc on Mon Jan 14 14:28:05 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.*;

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
                case 40:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 41:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 80;
                            continue;
                    }
                    yyn = 83;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 42:
                    yyn = yys2();
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
                case 43:
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
                case 44:
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
                case 45:
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
                case 46:
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
                case 47:
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
                case 48:
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
                case 49:
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
                case 50:
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
                case 51:
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
                case 52:
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
                case 53:
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
                case 54:
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
                case 55:
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
                case 56:
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
                case 57:
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
                case 58:
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
                case 59:
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
                case 60:
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
                case 61:
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
                case 62:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 63:
                    yyn = yys23();
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 64:
                    yyn = yys24();
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 65:
                    yyn = yys25();
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 66:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 67:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 68:
                    yyn = yys28();
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 69:
                    yyn = yys29();
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 70:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 75:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 77:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    yyn = yys39();
                    continue;

                case 80:
                    return true;
                case 81:
                    yyerror("stack overflow");
                case 82:
                    return false;
                case 83:
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
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 11;
            case EQ:
                return 12;
            case GEQ:
                return 13;
            case LEQ:
                return 14;
            case NEQ:
                return 15;
            case OR:
                return 16;
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case '<':
                return 21;
            case '>':
                return 22;
            case ENDINPUT:
                return yyr1();
        }
        return 83;
    }

    private int yys3() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr17();
    }

    private int yys4() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr20();
    }

    private int yys5() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr18();
    }

    private int yys6() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr19();
    }

    private int yys7() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys8() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys9() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys10() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys11() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys12() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys13() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys14() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys15() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys16() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys17() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys18() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys19() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys20() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys21() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys22() {
        switch (yytok) {
            case BOOL:
                return 3;
            case IDENT:
                return 4;
            case INT:
                return 5;
            case STR:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 83;
    }

    private int yys23() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr4();
    }

    private int yys24() {
        switch (yytok) {
            case AND:
                return 11;
            case EQ:
                return 12;
            case GEQ:
                return 13;
            case LEQ:
                return 14;
            case NEQ:
                return 15;
            case OR:
                return 16;
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case '<':
                return 21;
            case '>':
                return 22;
            case ')':
                return 39;
        }
        return 83;
    }

    private int yys25() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr2();
    }

    private int yys26() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr3();
    }

    private int yys27() {
        switch (yytok) {
            case EQ:
                return 12;
            case GEQ:
                return 13;
            case LEQ:
                return 14;
            case NEQ:
                return 15;
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case '<':
                return 21;
            case '>':
                return 22;
            case ENDINPUT:
            case OR:
            case ')':
            case AND:
                return yyr15();
        }
        return 83;
    }

    private int yys28() {
        switch (yytok) {
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case LEQ:
            case ENDINPUT:
            case EQ:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case GEQ:
            case AND:
                return yyr9();
        }
        return 83;
    }

    private int yys29() {
        switch (yytok) {
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case LEQ:
            case ENDINPUT:
            case EQ:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case GEQ:
            case AND:
                return yyr13();
        }
        return 83;
    }

    private int yys30() {
        switch (yytok) {
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case LEQ:
            case ENDINPUT:
            case EQ:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case GEQ:
            case AND:
                return yyr14();
        }
        return 83;
    }

    private int yys31() {
        switch (yytok) {
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case LEQ:
            case ENDINPUT:
            case EQ:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case GEQ:
            case AND:
                return yyr10();
        }
        return 83;
    }

    private int yys32() {
        switch (yytok) {
            case AND:
                return 11;
            case EQ:
                return 12;
            case GEQ:
                return 13;
            case LEQ:
                return 14;
            case NEQ:
                return 15;
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case '<':
                return 21;
            case '>':
                return 22;
            case ENDINPUT:
            case OR:
            case ')':
                return yyr16();
        }
        return 83;
    }

    private int yys33() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr5();
    }

    private int yys34() {
        switch (yytok) {
            case INT:
            case error:
            case UPLUS:
            case BOOL:
            case '(':
            case '!':
            case UNOT:
            case STR:
            case IDENT:
            case UMIN:
                return 83;
            case '*':
                return 17;
            case '/':
                return 20;
        }
        return yyr7();
    }

    private int yys35() {
        switch (yytok) {
            case INT:
            case error:
            case UPLUS:
            case BOOL:
            case '(':
            case '!':
            case UNOT:
            case STR:
            case IDENT:
            case UMIN:
                return 83;
            case '*':
                return 17;
            case '/':
                return 20;
        }
        return yyr8();
    }

    private int yys36() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr6();
    }

    private int yys37() {
        switch (yytok) {
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case LEQ:
            case ENDINPUT:
            case EQ:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case GEQ:
            case AND:
                return yyr12();
        }
        return 83;
    }

    private int yys38() {
        switch (yytok) {
            case '*':
                return 17;
            case '+':
                return 18;
            case '-':
                return 19;
            case '/':
                return 20;
            case LEQ:
            case ENDINPUT:
            case EQ:
            case '>':
            case '<':
            case OR:
            case ')':
            case NEQ:
            case GEQ:
            case AND:
                return yyr11();
        }
        return 83;
    }

    private int yys39() {
        switch (yytok) {
            case '!':
            case INT:
            case IDENT:
            case '(':
            case error:
            case UPLUS:
            case UNOT:
            case STR:
            case UMIN:
            case BOOL:
                return 83;
        }
        return yyr21();
    }

    private int yyr1() { // top : expr
        { result = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr2() { // expr : '+' expr
        { yyrv = new Pos(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr3() { // expr : '-' expr
        { yyrv = new Neg(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr4() { // expr : '!' expr
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr5() { // expr : expr '*' expr
        { yyrv = new Mul(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr6() { // expr : expr '/' expr
        { yyrv = new Div(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr7() { // expr : expr '+' expr
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr8() { // expr : expr '-' expr
        { yyrv = new Sub(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr9() { // expr : expr EQ expr
        { yyrv = new Eq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr10() { // expr : expr NEQ expr
        { yyrv = new NEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr11() { // expr : expr '>' expr
        { yyrv = new GT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr12() { // expr : expr '<' expr
        { yyrv = new LT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : expr GEQ expr
        { yyrv = new GEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : expr LEQ expr
        { yyrv = new LEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : expr AND expr
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : expr OR expr
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : BOOL
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Bool)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : INT
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : STR
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Str)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : IDENT
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr21() { // expr : '(' expr ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 21: return 37;
            case 20: return 36;
            case 19: return 35;
            case 18: return 34;
            case 17: return 33;
            case 16: return 32;
            case 15: return 31;
            case 14: return 30;
            case 13: return 29;
            case 12: return 28;
            case 11: return 27;
            case 10: return 26;
            case 9: return 25;
            case 8: return 24;
            case 7: return 23;
            case 0: return 2;
            default: return 38;
        }
    }

    protected String[] yyerrmsgs = {
    };

    private QLLexer lexer;
    
    private Expression result;
    
    public Expression getResult() {
      return result;
    }
    
    public QLParser( QLLexer lexer ) { 
      this.lexer = lexer;
    }
    
    private void yyerror( String msg ) { 
      System.err.println( msg );
    }

}
