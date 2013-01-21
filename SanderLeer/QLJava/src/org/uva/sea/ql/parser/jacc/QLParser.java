// Output created by jacc on Mon Jan 21 15:17:26 CET 2013

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
                case 66:
                    switch (yytok) {
                        case FORM:
                            yyn = 2;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 67:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 132;
                            continue;
                    }
                    yyn = 135;
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
                case 68:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 3;
                            continue;
                    }
                    yyn = 135;
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
                case 69:
                    switch (yytok) {
                        case '{':
                            yyn = 4;
                            continue;
                    }
                    yyn = 135;
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
                case 70:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 9;
                            continue;
                        case IF:
                            yyn = 10;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 9;
                            continue;
                        case IF:
                            yyn = 10;
                            continue;
                        case '}':
                            yyn = 12;
                            continue;
                    }
                    yyn = 135;
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
                case 75:
                    switch (yytok) {
                        case ':':
                            yyn = 13;
                            continue;
                    }
                    yyn = 135;
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
                case 76:
                    switch (yytok) {
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 77:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 135;
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
                case 78:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 135;
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
                case 79:
                    switch (yytok) {
                        case STRING:
                            yyn = 15;
                            continue;
                    }
                    yyn = 135;
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
                case 80:
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
                case 81:
                    switch (yytok) {
                        case BOOLEAN_TYPE:
                            yyn = 27;
                            continue;
                        case INTEGER_TYPE:
                            yyn = 28;
                            continue;
                        case STRING_TYPE:
                            yyn = 29;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
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
                case 83:
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
                case 84:
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
                case 85:
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
                case 86:
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
                case 87:
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
                case 88:
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
                case 89:
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
                case 90:
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
                case 91:
                    yyn = yys25();
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    switch (yytok) {
                        case '(':
                            yyn = 47;
                            continue;
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 135;
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
                case 93:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '(':
                        case '}':
                        case IF:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 135;
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
                case 94:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '(':
                        case '}':
                        case IF:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '(':
                        case '}':
                        case IF:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
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
                case 97:
                    yyn = yys31();
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
                case 98:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    switch (yytok) {
                        case '{':
                            yyn = 54;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
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
                case 105:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys40();
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
                case 107:
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
                case 108:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
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
                case 113:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    yyn = yys53();
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
                case 120:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 9;
                            continue;
                        case IF:
                            yyn = 10;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    yyn = yys60();
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    yyn = yys62();
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 9;
                            continue;
                        case IF:
                            yyn = 10;
                            continue;
                        case '}':
                            yyn = 65;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 132:
                    return true;
                case 133:
                    yyerror("stack overflow");
                case 134:
                    return false;
                case 135:
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

    private int yys14() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys16() {
        switch (yytok) {
            case AND:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case LEQ:
                return 33;
            case NEQ:
                return 34;
            case OR:
                return 35;
            case ')':
                return 36;
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '>':
                return 42;
        }
        return 135;
    }

    private int yys17() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr28();
        }
        return 135;
    }

    private int yys18() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr31();
        }
        return 135;
    }

    private int yys19() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr29();
        }
        return 135;
    }

    private int yys20() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr30();
        }
        return 135;
    }

    private int yys21() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr27();
        }
        return 135;
    }

    private int yys22() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys23() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys24() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys25() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys30() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys31() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys32() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys33() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys34() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys35() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys37() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys38() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys39() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys40() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys41() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys42() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys43() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr14();
        }
        return 135;
    }

    private int yys44() {
        switch (yytok) {
            case AND:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case LEQ:
                return 33;
            case NEQ:
                return 34;
            case OR:
                return 35;
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '>':
                return 42;
            case ')':
                return 61;
        }
        return 135;
    }

    private int yys45() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr12();
        }
        return 135;
    }

    private int yys46() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr13();
        }
        return 135;
    }

    private int yys47() {
        switch (yytok) {
            case FALSE:
                return 17;
            case IDENTIFIER:
                return 18;
            case INTEGER:
                return 19;
            case STRING:
                return 20;
            case TRUE:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
        }
        return 135;
    }

    private int yys48() {
        switch (yytok) {
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case LEQ:
                return 33;
            case NEQ:
                return 34;
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '>':
                return 42;
            case OR:
            case ')':
            case AND:
                return yyr25();
        }
        return 135;
    }

    private int yys49() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr19();
        }
        return 135;
    }

    private int yys50() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr23();
        }
        return 135;
    }

    private int yys51() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr24();
        }
        return 135;
    }

    private int yys52() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr20();
        }
        return 135;
    }

    private int yys53() {
        switch (yytok) {
            case AND:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case LEQ:
                return 33;
            case NEQ:
                return 34;
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '>':
                return 42;
            case OR:
            case ')':
                return yyr26();
        }
        return 135;
    }

    private int yys55() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr15();
        }
        return 135;
    }

    private int yys56() {
        switch (yytok) {
            case '*':
                return 37;
            case '/':
                return 40;
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr17();
        }
        return 135;
    }

    private int yys57() {
        switch (yytok) {
            case '*':
                return 37;
            case '/':
                return 40;
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr18();
        }
        return 135;
    }

    private int yys58() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr16();
        }
        return 135;
    }

    private int yys59() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr22();
        }
        return 135;
    }

    private int yys60() {
        switch (yytok) {
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr21();
        }
        return 135;
    }

    private int yys61() {
        switch (yytok) {
            case '>':
            case '<':
            case '/':
            case '-':
            case OR:
            case '+':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case AND:
                return yyr32();
        }
        return 135;
    }

    private int yys62() {
        switch (yytok) {
            case AND:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case LEQ:
                return 33;
            case NEQ:
                return 34;
            case OR:
                return 35;
            case '*':
                return 37;
            case '+':
                return 38;
            case '-':
                return 39;
            case '/':
                return 40;
            case '<':
                return 41;
            case '>':
                return 42;
            case ')':
                return 64;
        }
        return 135;
    }

    private int yyr1() { // form : FORM IDENTIFIER '{' statement_list '}'
        { result = new Form(((Identifier)yysv[yysp-4]), ((StatementList)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 1;
    }

    private int yyr12() { // expr : '+' expr
        { yyrv = new Pos(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : '-' expr
        { yyrv = new Neg(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : '!' expr
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : expr '*' expr
        { yyrv = new Mul(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : expr '/' expr
        { yyrv = new Div(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : expr '+' expr
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : expr '-' expr
        { yyrv = new Sub(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : expr EQ expr
        { yyrv = new Eq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : expr NEQ expr
        { yyrv = new NEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr21() { // expr : expr '>' expr
        { yyrv = new GT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr22() { // expr : expr '<' expr
        { yyrv = new LT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr23() { // expr : expr GEQ expr
        { yyrv = new GEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr24() { // expr : expr LEQ expr
        { yyrv = new LEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr25() { // expr : expr AND expr
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr26() { // expr : expr OR expr
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr27() { // expr : TRUE
        { yyrv = new BooleanLiteral(true); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr28() { // expr : FALSE
        { yyrv = new BooleanLiteral(false); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr29() { // expr : INTEGER
        { yyrv = ((IntegerLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr30() { // expr : STRING
        { yyrv = ((StringLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr31() { // expr : IDENTIFIER
        { yyrv = ((Identifier)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr32() { // expr : '(' expr ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 42: return 60;
            case 41: return 59;
            case 40: return 58;
            case 39: return 57;
            case 38: return 56;
            case 37: return 55;
            case 35: return 53;
            case 34: return 52;
            case 33: return 51;
            case 32: return 50;
            case 31: return 49;
            case 30: return 48;
            case 25: return 46;
            case 24: return 45;
            case 23: return 44;
            case 22: return 43;
            case 14: return 16;
            default: return 62;
        }
    }

    private int yyr8() { // datatype : INTEGER_TYPE
        { yyrv = new IntegerType(); }
        yysv[yysp-=1] = yyrv;
        return 26;
    }

    private int yyr9() { // datatype : STRING_TYPE
        { yyrv = new StringType(); }
        yysv[yysp-=1] = yyrv;
        return 26;
    }

    private int yyr10() { // datatype : BOOLEAN_TYPE
        { yyrv = new BooleanType(); }
        yysv[yysp-=1] = yyrv;
        return 26;
    }

    private int yyr11() { // if : IF '(' expr ')' '{' statement_list '}'
        { yyrv = new IfStatement(((Expression)yysv[yysp-5]), ((StatementList)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 5;
    }

    private int yyr6() { // question : IDENTIFIER ':' STRING datatype
        { yyrv = new Question(((Identifier)yysv[yysp-4]), ((StringLiteral)yysv[yysp-2]), ((Datatype)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 6;
    }

    private int yyr7() { // question : IDENTIFIER ':' STRING datatype '(' expr ')'
        { yyrv = new ComputedQuestion(((Identifier)yysv[yysp-7]), ((StringLiteral)yysv[yysp-5]), ((Datatype)yysv[yysp-4]), ((Expression)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 6;
    }

    private int yyr4() { // statement : question
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypstatement();
    }

    private int yyr5() { // statement : if
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 54: return 7;
            case 4: return 7;
            default: return 11;
        }
    }

    private int yyr2() { // statement_list : statement
        { yyrv = new StatementList();
                                                                                                                                  ((StatementList)yyrv).addStatement(((Statement)yysv[yysp-1]));
                                                                                                                                }
        yysv[yysp-=1] = yyrv;
        return yypstatement_list();
    }

    private int yyr3() { // statement_list : statement_list statement
        { yyrv = ((StatementList)yysv[yysp-2]);
                                                                                                                                  ((StatementList)yysv[yysp-2]).addStatement(((Statement)yysv[yysp-1]));
                                                                                                                                }
        yysv[yysp-=2] = yyrv;
        return yypstatement_list();
    }

    private int yypstatement_list() {
        switch (yyst[yysp-1]) {
            case 4: return 8;
            default: return 63;
        }
    }

    protected String[] yyerrmsgs = {
    };

//TODO: remove before production
private void printNode(String item, ASTNode node) {
        System.out.print("$" + item + " = " + node.getClass() + " (");

        if (node.getClass() == Question.class) {
          System.out.print(((Question)node).getIdentifier().getName());
        } else if (node.getClass() == StatementList.class) {
          System.out.print("StatementList");
        } else {
          System.out.print("something else : " + node.toString());
        }
        
        System.out.println(")");
}

private QLLexer lexer; 
private ASTNode result;
private String error;

public ASTNode getResult() {
  return result;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  error = msg;
  System.err.println(msg); 
}

public String getError() {
  return error;
}

}
