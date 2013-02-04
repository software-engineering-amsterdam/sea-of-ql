// Output created by jacc on Mon Jan 28 15:34:44 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.operators.binary.logical.*;
import org.uva.sea.ql.ast.operators.binary.numeric.*;
import org.uva.sea.ql.ast.operators.binary.relational.*;
import org.uva.sea.ql.ast.operators.unary.*;

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
                            yyn = 3;
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
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 68:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
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
                        case IDENT:
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
                        case '{':
                            yyn = 5;
                            continue;
                    }
                    yyn = 135;
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
                case 71:
                    yyn = yys5();
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    yyn = yys6();
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    switch (yytok) {
                        case '}':
                            yyn = yyr4();
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
                        case '}':
                            yyn = 30;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 75:
                    switch (yytok) {
                        case '}':
                            yyn = yyr5();
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
                case 77:
                    switch (yytok) {
                        case '(':
                            yyn = 32;
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
                case 79:
                    switch (yytok) {
                        case IDENT:
                            yyn = 35;
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
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
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
                case 93:
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
                case 94:
                    yyn = yys28();
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
                    yyn = yys29();
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
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 135;
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
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    switch (yytok) {
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    switch (yytok) {
                        case '}':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 135;
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
                    switch (yytok) {
                        case '=':
                            yyn = 31;
                            continue;
                        case ':':
                            yyn = 55;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    yyn = yys36();
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
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
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
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
                    yyn = yys54();
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
                case 121:
                    switch (yytok) {
                        case BOOL:
                            yyn = 60;
                            continue;
                        case INT:
                            yyn = 61;
                            continue;
                        case STRING:
                            yyn = 62;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
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
                case 123:
                    switch (yytok) {
                        case '}':
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 135;
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
                case 124:
                    switch (yytok) {
                        case '{':
                            yyn = 63;
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    switch (yytok) {
                        case '}':
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 135;
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
                case 126:
                    switch (yytok) {
                        case '}':
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 135;
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
                    switch (yytok) {
                        case '}':
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 135;
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
                case 128:
                    switch (yytok) {
                        case '}':
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 135;
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys63();
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    switch (yytok) {
                        case '}':
                            yyn = 65;
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
                        case '}':
                            yyn = yyr3();
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

    private int yys5() {
        switch (yytok) {
            case IDENT:
                return 10;
            case IF:
                return 11;
            case INT:
                return 12;
            case STRING:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
        }
        return 135;
    }

    private int yys6() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case OR:
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case '}':
                return yyr6();
        }
        return 135;
    }

    private int yys10() {
        switch (yytok) {
            case '=':
                return 31;
            case '}':
            case '>':
            case '<':
            case '/':
            case OR:
            case GEQ:
            case '-':
            case '+':
            case NEQ:
            case '*':
            case LEQ:
            case EQ:
            case AND:
                return yyr30();
        }
        return 135;
    }

    private int yys12() {
        switch (yytok) {
            case '}':
            case '>':
            case ';':
            case '/':
            case OR:
            case GEQ:
            case '-':
            case '+':
            case '<':
            case NEQ:
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr29();
        }
        return 135;
    }

    private int yys14() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys15() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys16() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys17() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys18() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys19() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys20() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys21() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys22() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys23() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys24() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys25() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys26() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys27() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys28() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys29() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys31() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys32() {
        switch (yytok) {
            case INT:
                return 12;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 37;
        }
        return 135;
    }

    private int yys36() {
        switch (yytok) {
            case '}':
            case '>':
            case ';':
            case '/':
            case OR:
            case GEQ:
            case '-':
            case '+':
            case '<':
            case NEQ:
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr16();
        }
        return 135;
    }

    private int yys37() {
        switch (yytok) {
            case '}':
            case '>':
            case ';':
            case '/':
            case OR:
            case GEQ:
            case '-':
            case '+':
            case '<':
            case NEQ:
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr30();
        }
        return 135;
    }

    private int yys38() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case OR:
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case ')':
                return 56;
        }
        return 135;
    }

    private int yys39() {
        switch (yytok) {
            case '}':
            case '>':
            case ';':
            case '/':
            case OR:
            case GEQ:
            case '-':
            case '+':
            case '<':
            case NEQ:
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr14();
        }
        return 135;
    }

    private int yys40() {
        switch (yytok) {
            case '}':
            case '>':
            case ';':
            case '/':
            case OR:
            case GEQ:
            case '-':
            case '+':
            case '<':
            case NEQ:
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr15();
        }
        return 135;
    }

    private int yys41() {
        switch (yytok) {
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case '}':
            case ';':
            case OR:
            case ')':
            case AND:
                return yyr27();
        }
        return 135;
    }

    private int yys42() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case '<':
            case ';':
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr21();
        }
        return 135;
    }

    private int yys43() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case '<':
            case ';':
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr25();
        }
        return 135;
    }

    private int yys44() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case '<':
            case ';':
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr26();
        }
        return 135;
    }

    private int yys45() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case '<':
            case ';':
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr22();
        }
        return 135;
    }

    private int yys46() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case '}':
            case ';':
            case OR:
            case ')':
                return yyr28();
        }
        return 135;
    }

    private int yys47() {
        switch (yytok) {
            case '}':
            case '>':
            case ';':
            case '/':
            case OR:
            case GEQ:
            case '-':
            case '+':
            case '<':
            case NEQ:
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr17();
        }
        return 135;
    }

    private int yys48() {
        switch (yytok) {
            case '*':
                return 24;
            case '/':
                return 27;
            case '}':
            case '>':
            case ';':
            case OR:
            case GEQ:
            case '-':
            case '<':
            case '+':
            case NEQ:
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr19();
        }
        return 135;
    }

    private int yys49() {
        switch (yytok) {
            case '*':
                return 24;
            case '/':
                return 27;
            case '}':
            case '>':
            case ';':
            case OR:
            case GEQ:
            case '-':
            case '<':
            case '+':
            case NEQ:
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr20();
        }
        return 135;
    }

    private int yys50() {
        switch (yytok) {
            case '}':
            case '>':
            case ';':
            case '/':
            case OR:
            case GEQ:
            case '-':
            case '+':
            case '<':
            case NEQ:
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr18();
        }
        return 135;
    }

    private int yys51() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case '<':
            case ';':
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr24();
        }
        return 135;
    }

    private int yys52() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case '<':
            case ';':
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr23();
        }
        return 135;
    }

    private int yys53() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case OR:
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case ';':
                return 57;
        }
        return 135;
    }

    private int yys54() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case OR:
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case ')':
                return 58;
        }
        return 135;
    }

    private int yys56() {
        switch (yytok) {
            case '}':
            case '>':
            case ';':
            case '/':
            case OR:
            case GEQ:
            case '-':
            case '+':
            case '<':
            case NEQ:
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case AND:
                return yyr31();
        }
        return 135;
    }

    private int yys63() {
        switch (yytok) {
            case IDENT:
                return 10;
            case IF:
                return 11;
            case INT:
                return 12;
            case STRING:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
        }
        return 135;
    }

    private int yyr1() { // top : form
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr11() { // datatype : BOOL
        { yyrv = ((Bool)yysv[yysp-1]) }
        yysv[yysp-=1] = yyrv;
        return 59;
    }

    private int yyr12() { // datatype : INT
        { yyrv = ((Int)yysv[yysp-1]) }
        yysv[yysp-=1] = yyrv;
        return 59;
    }

    private int yyr13() { // datatype : STRING
        { yyrv = ((String)yysv[yysp-1]) }
        yysv[yysp-=1] = yyrv;
        return 59;
    }

    private int yyr9() { // declaration : IDENT ':' datatype
        { yyrv = new Declaration(((Ident)yysv[yysp-3]), yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return 33;
    }

    private int yyr14() { // expr : '+' expr
        { yyrv = new Pos(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : '-' expr
        { yyrv = new Neg(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : '!' expr
        { yyrv = new Not(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : expr '*' expr
        { yyrv = new Mul(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : expr '/' expr
        { yyrv = new Div(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : expr '+' expr
        { yyrv = new Add(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : expr '-' expr
        { yyrv = new Sub(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr21() { // expr : expr EQ expr
        { yyrv = new Eq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr22() { // expr : expr NEQ expr
        { yyrv = new NEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr23() { // expr : expr '>' expr
        { yyrv = new GT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr24() { // expr : expr '<' expr
        { yyrv = new LT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr25() { // expr : expr GEQ expr
        { yyrv = new GEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr26() { // expr : expr LEQ expr
        { yyrv = new LEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr27() { // expr : expr AND expr
        { yyrv = new And(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr28() { // expr : expr OR expr
        { yyrv = new Or(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr29() { // expr : INT
        { yyrv = ((Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr30() { // expr : IDENT
        { yyrv = ((Ident)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr31() { // expr : '(' expr ')'
        { yyrv = ((Expr)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 32: return 54;
            case 31: return 53;
            case 29: return 52;
            case 28: return 51;
            case 27: return 50;
            case 26: return 49;
            case 25: return 48;
            case 24: return 47;
            case 23: return 46;
            case 22: return 45;
            case 21: return 44;
            case 20: return 43;
            case 19: return 42;
            case 18: return 41;
            case 17: return 40;
            case 16: return 39;
            case 15: return 38;
            case 14: return 36;
            default: return 6;
        }
    }

    private int yyr2() { // form : FORM IDENT '{' statement '}'
        { yyrv = new Form(((Ident)yysv[yysp-4]), yysv[yysp-2]); }
        yysv[yysp-=5] = yyrv;
        return 2;
    }

    private int yyr7() { // question : STRING declaration
        { yyrv = new Question(((String)yysv[yysp-2]), yysv[yysp-1]); }
        yysv[yysp-=2] = yyrv;
        return 7;
    }

    private int yyr8() { // question : STRING assignment
        { yyrv = new Question(((String)yysv[yysp-2]), yysv[yysp-1]); }
        yysv[yysp-=2] = yyrv;
        return 7;
    }

    private int yyr3() { // statement : IF '(' expr ')' '{' statement '}'
        { yyrv = new If(((Expr)yysv[yysp-5]), yysv[yysp-2]); }
        yysv[yysp-=7] = yyrv;
        return yypstatement();
    }

    private int yyr4() { // statement : question
        yysp -= 1;
        return yypstatement();
    }

    private int yyr5() { // statement : assignment
        yysp -= 1;
        return yypstatement();
    }

    private int yyr6() { // statement : expr
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 5: return 8;
            default: return 64;
        }
    }

    private int yyr10() { // assignment : IDENT '=' expr ';'
        { yyrv = new Assignment(((Ident)yysv[yysp-4]), ((Expr)yysv[yysp-2])); }
        yysv[yysp-=4] = yyrv;
        switch (yyst[yysp-1]) {
            case 13: return 34;
            default: return 9;
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
