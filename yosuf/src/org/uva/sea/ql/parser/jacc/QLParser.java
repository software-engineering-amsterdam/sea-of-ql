// Output created by jacc on Sat Feb 02 20:46:17 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.exp.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.value.*;

@edu.umd.cs.findbugs.annotations.SuppressWarnings(
    value="URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", 
    justification="because I know better")
@SuppressWarnings("unused")

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
                case 68:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 69:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 136;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 70:
                    switch (yytok) {
                        case IDENT:
                            yyn = 17;
                            continue;
                        case ENDINPUT:
                            yyn = yyr26();
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
                    yyn = yys3();
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr23();
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr25();
                            continue;
                    }
                    yyn = 139;
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
                case 74:
                    switch (yytok) {
                        case IDENT:
                        case ENDINPUT:
                            yyn = yyr19();
                            continue;
                    }
                    yyn = 139;
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
                case 75:
                    switch (yytok) {
                        case IDENT:
                            yyn = 30;
                            continue;
                    }
                    yyn = 139;
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
                case 76:
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
                case 77:
                    switch (yytok) {
                        case IDENT:
                        case ENDINPUT:
                            yyn = yyr20();
                            continue;
                    }
                    yyn = 139;
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
                case 78:
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
                case 79:
                    switch (yytok) {
                        case IDENT:
                        case ENDINPUT:
                            yyn = yyr21();
                            continue;
                    }
                    yyn = 139;
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
                case 80:
                    switch (yytok) {
                        case IDENT:
                        case ENDINPUT:
                            yyn = yyr22();
                            continue;
                    }
                    yyn = 139;
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
                case 81:
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
                case 82:
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
                case 83:
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
                case 84:
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
                case 85:
                    switch (yytok) {
                        case '=':
                            yyn = 35;
                            continue;
                    }
                    yyn = 139;
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
                case 86:
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
                case 87:
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
                case 88:
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
                case 89:
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
                case 90:
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
                case 91:
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
                case 92:
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
                case 93:
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
                case 94:
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
                case 95:
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
                case 96:
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
                case 97:
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
                case 98:
                    switch (yytok) {
                        case '{':
                            yyn = 48;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
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
                case 103:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    yyn = yys47();
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
                case 116:
                    switch (yytok) {
                        case BOOL:
                            yyn = 6;
                            continue;
                        case INT:
                            yyn = 9;
                            continue;
                        case MON:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                        case IF:
                            yyn = 57;
                            continue;
                    }
                    yyn = 139;
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
                case 117:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    yyn = yys50();
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
                case 119:
                    switch (yytok) {
                        case ';':
                            yyn = 59;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
                    switch (yytok) {
                        case IDENT:
                            yyn = 17;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
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
                case 125:
                    switch (yytok) {
                        case '(':
                            yyn = 62;
                            continue;
                    }
                    yyn = 139;
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
                case 126:
                    yyn = yys58();
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
                case 127:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
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
                case 129:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr27();
                            continue;
                    }
                    yyn = 139;
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
                case 130:
                    yyn = yys62();
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys63();
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
                case 132:
                    switch (yytok) {
                        case '{':
                            yyn = 65;
                            continue;
                    }
                    yyn = 139;
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
                case 133:
                    switch (yytok) {
                        case BOOL:
                            yyn = 6;
                            continue;
                        case INT:
                            yyn = 9;
                            continue;
                        case MON:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                        case IF:
                            yyn = 57;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys66();
                    continue;

                case 67:
                    yyst[yysp] = 67;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    yyn = yys67();
                    continue;

                case 136:
                    return true;
                case 137:
                    yyerror("stack overflow");
                case 138:
                    return false;
                case 139:
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
                return 6;
            case FORM:
                return 7;
            case IDENT:
                return 8;
            case INT:
                return 9;
            case INT_VAL:
                return 10;
            case MON:
                return 11;
            case STR:
                return 12;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys3() {
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
            case ENDINPUT:
                return yyr24();
        }
        return 139;
    }

    private int yys8() {
        switch (yytok) {
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case NEQ:
            case '/':
            case ';':
            case EQ:
            case '*':
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr17();
        }
        return 139;
    }

    private int yys10() {
        switch (yytok) {
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case NEQ:
            case '/':
            case ';':
            case EQ:
            case '*':
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr16();
        }
        return 139;
    }

    private int yys13() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys14() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys15() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys16() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys18() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys19() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys20() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys21() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys22() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys23() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys24() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys25() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys26() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys27() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys28() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys29() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys31() {
        switch (yytok) {
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case NEQ:
            case '/':
            case ';':
            case EQ:
            case '*':
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr3();
        }
        return 139;
    }

    private int yys32() {
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
                return 49;
        }
        return 139;
    }

    private int yys33() {
        switch (yytok) {
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case NEQ:
            case '/':
            case ';':
            case EQ:
            case '*':
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr1();
        }
        return 139;
    }

    private int yys34() {
        switch (yytok) {
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case NEQ:
            case '/':
            case ';':
            case EQ:
            case '*':
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr2();
        }
        return 139;
    }

    private int yys35() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case STRING_VAL:
                return 51;
        }
        return 139;
    }

    private int yys36() {
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
            case ';':
            case OR:
            case ')':
            case ENDINPUT:
            case AND:
                return yyr14();
        }
        return 139;
    }

    private int yys37() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '>':
            case '<':
            case ';':
            case OR:
            case NEQ:
            case EQ:
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr8();
        }
        return 139;
    }

    private int yys38() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '>':
            case '<':
            case ';':
            case OR:
            case NEQ:
            case EQ:
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr12();
        }
        return 139;
    }

    private int yys39() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '>':
            case '<':
            case ';':
            case OR:
            case NEQ:
            case EQ:
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr13();
        }
        return 139;
    }

    private int yys40() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '>':
            case '<':
            case ';':
            case OR:
            case NEQ:
            case EQ:
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr9();
        }
        return 139;
    }

    private int yys41() {
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
            case ';':
            case OR:
            case ')':
            case ENDINPUT:
                return yyr15();
        }
        return 139;
    }

    private int yys42() {
        switch (yytok) {
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case NEQ:
            case '/':
            case ';':
            case EQ:
            case '*':
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr4();
        }
        return 139;
    }

    private int yys43() {
        switch (yytok) {
            case '*':
                return 24;
            case '/':
                return 27;
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case ';':
            case NEQ:
            case EQ:
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr6();
        }
        return 139;
    }

    private int yys44() {
        switch (yytok) {
            case '*':
                return 24;
            case '/':
                return 27;
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case ';':
            case NEQ:
            case EQ:
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr7();
        }
        return 139;
    }

    private int yys45() {
        switch (yytok) {
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case NEQ:
            case '/':
            case ';':
            case EQ:
            case '*':
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr5();
        }
        return 139;
    }

    private int yys46() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '>':
            case '<':
            case ';':
            case OR:
            case NEQ:
            case EQ:
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr11();
        }
        return 139;
    }

    private int yys47() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '>':
            case '<':
            case ';':
            case OR:
            case NEQ:
            case EQ:
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr10();
        }
        return 139;
    }

    private int yys49() {
        switch (yytok) {
            case '>':
            case '<':
            case OR:
            case '-':
            case '+':
            case NEQ:
            case '/':
            case ';':
            case EQ:
            case '*':
            case ')':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr18();
        }
        return 139;
    }

    private int yys50() {
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
                return 58;
        }
        return 139;
    }

    private int yys53() {
        switch (yytok) {
            case STR:
            case IF:
            case MON:
            case '}':
            case INT:
            case BOOL:
                return yyr31();
        }
        return 139;
    }

    private int yys54() {
        switch (yytok) {
            case STR:
            case IF:
            case MON:
            case '}':
            case INT:
            case BOOL:
                return yyr30();
        }
        return 139;
    }

    private int yys55() {
        switch (yytok) {
            case STR:
            case IF:
            case MON:
            case '}':
            case INT:
            case BOOL:
                return yyr28();
        }
        return 139;
    }

    private int yys56() {
        switch (yytok) {
            case BOOL:
                return 6;
            case INT:
                return 9;
            case MON:
                return 11;
            case STR:
                return 12;
            case IF:
                return 57;
            case '}':
                return 61;
        }
        return 139;
    }

    private int yys58() {
        switch (yytok) {
            case STR:
            case IF:
            case MON:
            case ENDINPUT:
            case '}':
            case INT:
            case BOOL:
                return yyr33();
        }
        return 139;
    }

    private int yys59() {
        switch (yytok) {
            case STR:
            case IF:
            case MON:
            case ENDINPUT:
            case '}':
            case INT:
            case BOOL:
                return yyr32();
        }
        return 139;
    }

    private int yys60() {
        switch (yytok) {
            case STR:
            case IF:
            case MON:
            case '}':
            case INT:
            case BOOL:
                return yyr29();
        }
        return 139;
    }

    private int yys62() {
        switch (yytok) {
            case IDENT:
                return 8;
            case INT_VAL:
                return 10;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
        }
        return 139;
    }

    private int yys63() {
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
                return 64;
        }
        return 139;
    }

    private int yys66() {
        switch (yytok) {
            case BOOL:
                return 6;
            case INT:
                return 9;
            case MON:
                return 11;
            case STR:
                return 12;
            case IF:
                return 57;
            case '}':
                return 67;
        }
        return 139;
    }

    private int yys67() {
        switch (yytok) {
            case STR:
            case IF:
            case MON:
            case '}':
            case INT:
            case BOOL:
                return yyr34();
        }
        return 139;
    }

    private int yyr23() { // top : form
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr24() { // top : expr
        { result = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr25() { // top : question
        { result = ((Question)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr26() { // top : dataType
        { result = ((DataType)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr19() { // dataType : BOOL
        { yyrv = new BooleanType(); }
        yysv[yysp-=1] = yyrv;
        return yypdataType();
    }

    private int yyr20() { // dataType : INT
        { yyrv = new IntegerType(); }
        yysv[yysp-=1] = yyrv;
        return yypdataType();
    }

    private int yyr21() { // dataType : MON
        { yyrv = new MoneyType(); }
        yysv[yysp-=1] = yyrv;
        return yypdataType();
    }

    private int yyr22() { // dataType : STR
        { yyrv = new StringType(); }
        yysv[yysp-=1] = yyrv;
        return yypdataType();
    }

    private int yypdataType() {
        switch (yyst[yysp-1]) {
            case 0: return 2;
            default: return 52;
        }
    }

    private int yyr1() { // expr : '+' expr
        { yyrv = new Positive(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr2() { // expr : '-' expr
        { yyrv = new Negative(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr3() { // expr : '!' expr
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr4() { // expr : expr '*' expr
        { yyrv = new Multiply(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr5() { // expr : expr '/' expr
        { yyrv = new Divide(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr6() { // expr : expr '+' expr
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr7() { // expr : expr '-' expr
        { yyrv = new Substitute(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr8() { // expr : expr EQ expr
        { yyrv = new Equals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr9() { // expr : expr NEQ expr
        { yyrv = new NotEquals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr10() { // expr : expr '>' expr
        { yyrv = new GreaterThan(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr11() { // expr : expr '<' expr
        { yyrv = new SmallerThan(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr12() { // expr : expr GEQ expr
        { yyrv = new GreaterOrEquals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : expr LEQ expr
        { yyrv = new SmallerOrEquals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : expr AND expr
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : expr OR expr
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : INT_VAL
        { yyrv = ((IntegerValue)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : IDENT
        { yyrv = ((Identifier)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : '(' expr ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 35: return 50;
            case 29: return 47;
            case 28: return 46;
            case 27: return 45;
            case 26: return 44;
            case 25: return 43;
            case 24: return 42;
            case 23: return 41;
            case 22: return 40;
            case 21: return 39;
            case 20: return 38;
            case 19: return 37;
            case 18: return 36;
            case 16: return 34;
            case 15: return 33;
            case 14: return 32;
            case 13: return 31;
            case 0: return 3;
            default: return 63;
        }
    }

    private int yyr27() { // form : FORM IDENT '{' compound '}'
        { yyrv = new Form(((Identifier)yysv[yysp-4]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 4;
    }

    private int yyr34() { // ifStm : IF '(' expr ')' '{' compound '}'
        { yyrv = new IfStatement(((Expression)yysv[yysp-5]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 53;
    }

    private int yyr32() { // question : dataType IDENT '=' STRING_VAL ';'
        { yyrv = new Question(((DataType)yysv[yysp-5]), ((Identifier)yysv[yysp-4]), ((StringValue)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return yypquestion();
    }

    private int yyr33() { // question : dataType IDENT '=' expr ';'
        { yyrv = new Computed(((DataType)yysv[yysp-5]), ((Identifier)yysv[yysp-4]), ((Expression)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return yypquestion();
    }

    private int yypquestion() {
        switch (yyst[yysp-1]) {
            case 0: return 5;
            default: return 54;
        }
    }

    private int yyr30() { // stm : question
        { yyrv = ((Question)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypstm();
    }

    private int yyr31() { // stm : ifStm
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypstm();
    }

    private int yypstm() {
        switch (yyst[yysp-1]) {
            case 65: return 55;
            case 48: return 55;
            default: return 60;
        }
    }

    private int yyr28() { // compound : stm
        { yyrv = new CompoundStatement(((Statement)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypcompound();
    }

    private int yyr29() { // compound : compound stm
        { yyrv = new CompoundStatement(((CompoundStatement)yysv[yysp-2]), ((Statement)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypcompound();
    }

    private int yypcompound() {
        switch (yyst[yysp-1]) {
            case 48: return 56;
            default: return 66;
        }
    }

    protected String[] yyerrmsgs = {
    };


private QLLexer lexer; 
private ASTNode result;

public ASTNode getResult(){
        return result;
}
 
public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
