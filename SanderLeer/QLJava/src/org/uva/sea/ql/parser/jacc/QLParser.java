// Output created by jacc on Sat Jan 19 17:51:33 CET 2013

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
                case 67:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 68:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 134;
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 69:
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
                case 70:
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
                case 71:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 25;
                            continue;
                    }
                    yyn = 137;
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
                case 72:
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
                case 73:
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
                case 74:
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
                case 75:
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
                case 76:
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
                case 77:
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
                case 78:
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
                case 79:
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
                case 80:
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
                case 81:
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
                case 82:
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
                case 83:
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
                case 84:
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
                case 85:
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
                case 86:
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
                case 87:
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
                case 88:
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
                case 89:
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
                case 90:
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
                case 91:
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
                case 92:
                    switch (yytok) {
                        case '{':
                            yyn = 42;
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    yyn = yys28();
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    yyn = yys29();
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
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
                case 109:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 48;
                            continue;
                        case IF:
                            yyn = 49;
                            continue;
                    }
                    yyn = 137;
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
                case 110:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 48;
                            continue;
                        case IF:
                            yyn = 49;
                            continue;
                        case '}':
                            yyn = 51;
                            continue;
                    }
                    yyn = 137;
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
                case 115:
                    switch (yytok) {
                        case ':':
                            yyn = 52;
                            continue;
                    }
                    yyn = 137;
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
                case 116:
                    switch (yytok) {
                        case '(':
                            yyn = 53;
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 137;
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
                case 118:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 137;
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
                case 119:
                    switch (yytok) {
                        case STRING:
                            yyn = 54;
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
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
                case 121:
                    switch (yytok) {
                        case BOOLEAN_TYPE:
                            yyn = 57;
                            continue;
                        case INTEGER_TYPE:
                            yyn = 58;
                            continue;
                        case STRING_TYPE:
                            yyn = 59;
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    switch (yytok) {
                        case '(':
                            yyn = 61;
                            continue;
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 137;
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
                case 124:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '(':
                        case '}':
                        case IF:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 137;
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
                case 125:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '(':
                        case '}':
                        case IF:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '(':
                        case '}':
                        case IF:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 137;
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
                case 127:
                    switch (yytok) {
                        case '{':
                            yyn = 62;
                            continue;
                    }
                    yyn = 137;
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
                case 128:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 48;
                            continue;
                        case IF:
                            yyn = 49;
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys63();
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 48;
                            continue;
                        case IF:
                            yyn = 49;
                            continue;
                        case '}':
                            yyn = 66;
                            continue;
                    }
                    yyn = 137;
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
                case 132:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    switch (yytok) {
                        case IDENTIFIER:
                        case '}':
                        case IF:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 137;
                    continue;

                case 134:
                    return true;
                case 135:
                    yyerror("stack overflow");
                case 136:
                    return false;
                case 137:
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
            case FALSE:
                return 3;
            case FORM:
                return 4;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
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
                return yyr2();
        }
        return 137;
    }

    private int yys3() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr29();
        }
        return 137;
    }

    private int yys5() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr32();
        }
        return 137;
    }

    private int yys6() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr30();
        }
        return 137;
    }

    private int yys7() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr31();
        }
        return 137;
    }

    private int yys8() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr28();
        }
        return 137;
    }

    private int yys9() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys10() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys11() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys12() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys13() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys14() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys15() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys16() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys17() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys18() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys19() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys20() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys21() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys22() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys23() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys24() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys26() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr15();
        }
        return 137;
    }

    private int yys27() {
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
                return 43;
        }
        return 137;
    }

    private int yys28() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr13();
        }
        return 137;
    }

    private int yys29() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr14();
        }
        return 137;
    }

    private int yys30() {
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
            case OR:
            case ')':
            case ENDINPUT:
            case AND:
                return yyr26();
        }
        return 137;
    }

    private int yys31() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr20();
        }
        return 137;
    }

    private int yys32() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr24();
        }
        return 137;
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
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr25();
        }
        return 137;
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
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr21();
        }
        return 137;
    }

    private int yys35() {
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
            case OR:
            case ')':
            case ENDINPUT:
                return yyr27();
        }
        return 137;
    }

    private int yys36() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr16();
        }
        return 137;
    }

    private int yys37() {
        switch (yytok) {
            case '*':
                return 19;
            case '/':
                return 22;
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
            case ENDINPUT:
            case AND:
                return yyr18();
        }
        return 137;
    }

    private int yys38() {
        switch (yytok) {
            case '*':
                return 19;
            case '/':
                return 22;
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
            case ENDINPUT:
            case AND:
                return yyr19();
        }
        return 137;
    }

    private int yys39() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr17();
        }
        return 137;
    }

    private int yys40() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 137;
    }

    private int yys41() {
        switch (yytok) {
            case '*':
                return 19;
            case '+':
                return 20;
            case '-':
                return 21;
            case '/':
                return 22;
            case '>':
            case '<':
            case OR:
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr22();
        }
        return 137;
    }

    private int yys43() {
        switch (yytok) {
            case '>':
            case '<':
            case '-':
            case OR:
            case '+':
            case '/':
            case '*':
            case NEQ:
            case GEQ:
            case EQ:
            case ')':
            case LEQ:
            case ENDINPUT:
            case AND:
                return yyr33();
        }
        return 137;
    }

    private int yys53() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys55() {
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
                return 60;
        }
        return 137;
    }

    private int yys61() {
        switch (yytok) {
            case FALSE:
                return 3;
            case IDENTIFIER:
                return 5;
            case INTEGER:
                return 6;
            case STRING:
                return 7;
            case TRUE:
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
        return 137;
    }

    private int yys63() {
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
                return 65;
        }
        return 137;
    }

    private int yyr1() { // form : FORM IDENTIFIER '{' statement_list '}'
        { result = new Form(((Identifier)yysv[yysp-4]), yysv[yysp-2]); }
        yysv[yysp-=5] = yyrv;
        return 1;
    }

    private int yyr2() { // form : expr
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr13() { // expr : '+' expr
        { yyrv = new Pos(yysv[yysp-1]); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : '-' expr
        { yyrv = new Neg(yysv[yysp-1]); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : '!' expr
        { yyrv = new Not(yysv[yysp-1]); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : expr '*' expr
        { yyrv = new Mul(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : expr '/' expr
        { yyrv = new Div(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : expr '+' expr
        { yyrv = new Add(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : expr '-' expr
        { yyrv = new Sub(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : expr EQ expr
        { yyrv = new Eq(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr21() { // expr : expr NEQ expr
        { yyrv = new NEq(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr22() { // expr : expr '>' expr
        { yyrv = new GT(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr23() { // expr : expr '<' expr
        { yyrv = new LT(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr24() { // expr : expr GEQ expr
        { yyrv = new GEq(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr25() { // expr : expr LEQ expr
        { yyrv = new LEq(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr26() { // expr : expr AND expr
        { yyrv = new And(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr27() { // expr : expr OR expr
        { yyrv = new Or(yysv[yysp-3], yysv[yysp-1]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr28() { // expr : TRUE
        { yyrv = new BooleanValue(true); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr29() { // expr : FALSE
        { yyrv = new BooleanValue(false); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr30() { // expr : INTEGER
        { yyrv = ((IntegerValue)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr31() { // expr : STRING
        { yyrv = ((StringValue)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr32() { // expr : IDENTIFIER
        { yyrv = ((Identifier)yysv[yysp-1]);
                                                                                                                                  if (!symbols.contains(((Identifier)yysv[yysp-1]).getName())) {
                                                                                                                                    yyerror("Variable '" + ((Identifier)yysv[yysp-1]).getName() + "' not defined");
                                                                                                                                    // JACC does not seem to support the YYERROR and YYABORT macros
                                                                                                                                    return 0;
                                                                                                                                  }
                                                                                                                                }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr33() { // expr : '(' expr ')'
        { yyrv = yysv[yysp-2]; }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 53: return 55;
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
            case 9: return 26;
            case 0: return 2;
            default: return 63;
        }
    }

    private int yyr9() { // datatype : INTEGER_TYPE
        { yyrv = new IntegerType(); }
        yysv[yysp-=1] = yyrv;
        return 56;
    }

    private int yyr10() { // datatype : STRING_TYPE
        { yyrv = new StringType(); }
        yysv[yysp-=1] = yyrv;
        return 56;
    }

    private int yyr11() { // datatype : BOOLEAN_TYPE
        { yyrv = new BooleanType(); }
        yysv[yysp-=1] = yyrv;
        return 56;
    }

    private int yyr12() { // if : IF '(' expr ')' '{' statement_list '}'
        { yyrv = new IfStmt(yysv[yysp-5], yysv[yysp-2]); }
        yysv[yysp-=7] = yyrv;
        return 44;
    }

    private int yyr7() { // question : IDENTIFIER ':' STRING datatype
        { yyrv = new Question(((Identifier)yysv[yysp-4]), ((StringValue)yysv[yysp-2]), (Datatype)yysv[yysp-1]);
                                                                                                                                  if (symbols.contains(((Identifier)yysv[yysp-4]).getName())) {
                                                                                                                                    yyerror("Question identifier '" + ((Identifier)yysv[yysp-4]).getName() + "' already defined");
                                                                                                                                    // JACC does not seem to support the YYERROR and YYABORT macros
                                                                                                                                    return 0;
                                                                                                                                  }
                                                                                                                                  symbols.put(((Identifier)yysv[yysp-4]).getName(), (Datatype)yysv[yysp-1]);
                                                                                                                                }
        yysv[yysp-=4] = yyrv;
        return 45;
    }

    private int yyr8() { // question : IDENTIFIER ':' STRING datatype '(' expr ')'
        { yyrv = new ComputedQuestion(((Identifier)yysv[yysp-7]), ((StringValue)yysv[yysp-5]), (Datatype)yysv[yysp-4], yysv[yysp-2]);
                                                                                                                                  if (symbols.contains(((Identifier)yysv[yysp-7]).getName())) {
                                                                                                                                    yyerror("Question identifier '" + ((Identifier)yysv[yysp-7]).getName() + "' already defined");
                                                                                                                                    // JACC does not seem to support the YYERROR and YYABORT macros
                                                                                                                                    return 0;
                                                                                                                                  }
                                                                                                                                  symbols.put(((Identifier)yysv[yysp-7]).getName(), (Datatype)yysv[yysp-4]);
                                                                                                                                }
        yysv[yysp-=7] = yyrv;
        return 45;
    }

    private int yyr5() { // statement : question
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypstatement();
    }

    private int yyr6() { // statement : if
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 62: return 46;
            case 42: return 46;
            default: return 50;
        }
    }

    private int yyr3() { // statement_list : statement
        { yyrv = new StatementList(); ((StatementList)yyrv).addStatement(yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypstatement_list();
    }

    private int yyr4() { // statement_list : statement_list statement
        { yyrv = yysv[yysp-2]; ((StatementList)yysv[yysp-2]).addStatement(yysv[yysp-1]); }
        yysv[yysp-=2] = yyrv;
        return yypstatement_list();
    }

    private int yypstatement_list() {
        switch (yyst[yysp-1]) {
            case 42: return 47;
            default: return 64;
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
private SymbolTable symbols;

public ASTNode getResult() {
  return result;
}

public QLParser(QLLexer lexer, SymbolTable symbols) { 
  this.lexer = lexer; 
  this.symbols = symbols;
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
