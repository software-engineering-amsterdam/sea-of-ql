// Output created by jacc on Sun Mar 03 20:36:43 CET 2013

package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.binary.comparison.*;
import org.uva.sea.ql.ast.expression.binary.arithmetic.*;
import org.uva.sea.ql.ast.expression.binary.logic.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.statement.*;
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
                case 76:
                    switch (yytok) {
                        case FORM:
                            yyn = 3;
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 77:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 152;
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 155;
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
                case 79:
                    switch (yytok) {
                        case IDENT:
                            yyn = 4;
                            continue;
                    }
                    yyn = 155;
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
                case 80:
                    switch (yytok) {
                        case '{':
                            yyn = 5;
                            continue;
                    }
                    yyn = 155;
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
                case 81:
                    switch (yytok) {
                        case IF:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                        case '}':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    switch (yytok) {
                        case IF:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                        case '}':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    switch (yytok) {
                        case '}':
                            yyn = 14;
                            continue;
                    }
                    yyn = 155;
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
                case 87:
                    switch (yytok) {
                        case '(':
                            yyn = 15;
                            continue;
                    }
                    yyn = 155;
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
                case 88:
                    switch (yytok) {
                        case IDENT:
                            yyn = 17;
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    switch (yytok) {
                        case '}':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 155;
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
                case 90:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 155;
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
                case 91:
                    yyn = yys15();
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 155;
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
                case 93:
                    switch (yytok) {
                        case ':':
                            yyn = 30;
                            continue;
                        case '=':
                            yyn = 31;
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys18();
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
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
                case 96:
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
                case 97:
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
                case 98:
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
                case 99:
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
                case 100:
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
                case 101:
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
                case 102:
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
                case 103:
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
                case 104:
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
                case 105:
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
                case 106:
                    switch (yytok) {
                        case tBool:
                            yyn = 50;
                            continue;
                        case tInt:
                            yyn = 51;
                            continue;
                        case tStr:
                            yyn = 52;
                            continue;
                    }
                    yyn = 155;
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
                case 107:
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
                case 108:
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
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
                case 113:
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
                case 114:
                    switch (yytok) {
                        case '{':
                            yyn = 60;
                            continue;
                    }
                    yyn = 155;
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
                case 115:
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
                case 116:
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
                case 117:
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
                case 118:
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
                case 119:
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
                case 120:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 155;
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
                case 126:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr38();
                            continue;
                    }
                    yyn = 155;
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
                case 127:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr39();
                            continue;
                    }
                    yyn = 155;
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
                case 128:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr40();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    yyn = yys59();
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
                case 136:
                    switch (yytok) {
                        case IF:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                        case '}':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    yyn = yys62();
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    yyn = yys63();
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
                    yyn = yys64();
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    yyn = yys65();
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
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
                case 143:
                    yyn = yys67();
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    switch (yytok) {
                        case '}':
                            yyn = 69;
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 69:
                    yyst[yysp] = 69;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    switch (yytok) {
                        case ELSE:
                            yyn = 70;
                            continue;
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
                    switch (yytok) {
                        case IF:
                            yyn = 11;
                            continue;
                        case '{':
                            yyn = 73;
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 147:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 148:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 73:
                    yyst[yysp] = 73;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 149:
                    switch (yytok) {
                        case IF:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                        case '}':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 150:
                    switch (yytok) {
                        case '}':
                            yyn = 75;
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 151:
                    switch (yytok) {
                        case STR:
                        case '}':
                        case IF:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 155;
                    continue;

                case 152:
                    return true;
                case 153:
                    yyerror("stack overflow");
                case 154:
                    return false;
                case 155:
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

    private int yys15() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys18() {
        switch (yytok) {
            case AND:
                return 32;
            case EQ:
                return 33;
            case GEQ:
                return 34;
            case LEQ:
                return 35;
            case NEQ:
                return 36;
            case OR:
                return 37;
            case ')':
                return 38;
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case '<':
                return 43;
            case '>':
                return 44;
        }
        return 155;
    }

    private int yys19() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr31();
        }
        return 155;
    }

    private int yys20() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr33();
        }
        return 155;
    }

    private int yys21() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr35();
        }
        return 155;
    }

    private int yys22() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr37();
        }
        return 155;
    }

    private int yys23() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr32();
        }
        return 155;
    }

    private int yys24() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr36();
        }
        return 155;
    }

    private int yys25() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr34();
        }
        return 155;
    }

    private int yys26() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys27() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys28() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys29() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys31() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys32() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys33() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys34() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys35() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys36() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys37() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys39() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys40() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys41() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys42() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys43() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys44() {
        switch (yytok) {
            case BOOL:
                return 20;
            case FALSE:
                return 21;
            case IDENT:
                return 22;
            case INT:
                return 23;
            case STR:
                return 24;
            case TRUE:
                return 25;
            case '!':
                return 26;
            case '(':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
        }
        return 155;
    }

    private int yys45() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr17();
        }
        return 155;
    }

    private int yys46() {
        switch (yytok) {
            case AND:
                return 32;
            case EQ:
                return 33;
            case GEQ:
                return 34;
            case LEQ:
                return 35;
            case NEQ:
                return 36;
            case OR:
                return 37;
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case '<':
                return 43;
            case '>':
                return 44;
            case ')':
                return 67;
        }
        return 155;
    }

    private int yys47() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr15();
        }
        return 155;
    }

    private int yys48() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr16();
        }
        return 155;
    }

    private int yys53() {
        switch (yytok) {
            case AND:
                return 32;
            case EQ:
                return 33;
            case GEQ:
                return 34;
            case LEQ:
                return 35;
            case NEQ:
                return 36;
            case OR:
                return 37;
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case '<':
                return 43;
            case '>':
                return 44;
            case STR:
            case '}':
            case IF:
                return yyr9();
        }
        return 155;
    }

    private int yys54() {
        switch (yytok) {
            case EQ:
                return 33;
            case GEQ:
                return 34;
            case LEQ:
                return 35;
            case NEQ:
                return 36;
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case '<':
                return 43;
            case '>':
                return 44;
            case STR:
            case ')':
            case OR:
            case '}':
            case IF:
            case AND:
                return yyr28();
        }
        return 155;
    }

    private int yys55() {
        switch (yytok) {
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case STR:
            case GEQ:
            case ')':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr22();
        }
        return 155;
    }

    private int yys56() {
        switch (yytok) {
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case STR:
            case GEQ:
            case ')':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr26();
        }
        return 155;
    }

    private int yys57() {
        switch (yytok) {
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case STR:
            case GEQ:
            case ')':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr27();
        }
        return 155;
    }

    private int yys58() {
        switch (yytok) {
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case STR:
            case GEQ:
            case ')':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr23();
        }
        return 155;
    }

    private int yys59() {
        switch (yytok) {
            case AND:
                return 32;
            case EQ:
                return 33;
            case GEQ:
                return 34;
            case LEQ:
                return 35;
            case NEQ:
                return 36;
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case '<':
                return 43;
            case '>':
                return 44;
            case STR:
            case ')':
            case OR:
            case '}':
            case IF:
                return yyr29();
        }
        return 155;
    }

    private int yys61() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr18();
        }
        return 155;
    }

    private int yys62() {
        switch (yytok) {
            case '*':
                return 39;
            case '/':
                return 42;
            case STR:
            case GEQ:
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr20();
        }
        return 155;
    }

    private int yys63() {
        switch (yytok) {
            case '*':
                return 39;
            case '/':
                return 42;
            case STR:
            case GEQ:
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr21();
        }
        return 155;
    }

    private int yys64() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr19();
        }
        return 155;
    }

    private int yys65() {
        switch (yytok) {
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case STR:
            case GEQ:
            case ')':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr25();
        }
        return 155;
    }

    private int yys66() {
        switch (yytok) {
            case '*':
                return 39;
            case '+':
                return 40;
            case '-':
                return 41;
            case '/':
                return 42;
            case STR:
            case GEQ:
            case ')':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr24();
        }
        return 155;
    }

    private int yys67() {
        switch (yytok) {
            case '/':
            case STR:
            case GEQ:
            case '*':
            case ')':
            case '+':
            case '-':
            case OR:
            case NEQ:
            case LEQ:
            case '}':
            case IF:
            case '>':
            case '<':
            case EQ:
            case AND:
                return yyr30();
        }
        return 155;
    }

    private int yyr1() { // top : form
        { result = ((org.uva.sea.ql.ast.Form)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr38() { // dType : tBool
        { yyrv = new org.uva.sea.ql.ast.type.Bool(); }
        yysv[yysp-=1] = yyrv;
        return 49;
    }

    private int yyr39() { // dType : tInt
        { yyrv = new org.uva.sea.ql.ast.type.Int(); }
        yysv[yysp-=1] = yyrv;
        return 49;
    }

    private int yyr40() { // dType : tStr
        { yyrv = new org.uva.sea.ql.ast.type.Str(); }
        yysv[yysp-=1] = yyrv;
        return 49;
    }

    private int yyr10() { // dec : IDENT ':' dType
        { yyrv = new Var(((org.uva.sea.ql.ast.expression.Ident)yysv[yysp-3]),((org.uva.sea.ql.ast.Type)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 16;
    }

    private int yyr15() { // expression : '+' expression
        { yyrv = new Pos(((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr16() { // expression : '-' expression
        { yyrv = new Neg(((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr17() { // expression : '!' expression
        { yyrv = new Not(((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr18() { // expression : expression '*' expression
        { yyrv = new Mul(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr19() { // expression : expression '/' expression
        { yyrv = new Div(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr20() { // expression : expression '+' expression
        { yyrv = new Add(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr21() { // expression : expression '-' expression
        { yyrv = new Sub(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr22() { // expression : expression EQ expression
        { yyrv = new Eq(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr23() { // expression : expression NEQ expression
        { yyrv = new NEq(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr24() { // expression : expression '>' expression
        { yyrv = new GT(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr25() { // expression : expression '<' expression
        { yyrv = new LT(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr26() { // expression : expression GEQ expression
        { yyrv = new GEq(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr27() { // expression : expression LEQ expression
        { yyrv = new LEq(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr28() { // expression : expression AND expression
        { yyrv = new And(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr29() { // expression : expression OR expression
        { yyrv = new Or(((org.uva.sea.ql.ast.Expression)yysv[yysp-3]), ((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr30() { // expression : '(' expression ')'
        { yyrv = ((org.uva.sea.ql.ast.Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr31() { // expression : type
        yysp -= 1;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 43: return 65;
            case 42: return 64;
            case 41: return 63;
            case 40: return 62;
            case 39: return 61;
            case 37: return 59;
            case 36: return 58;
            case 35: return 57;
            case 34: return 56;
            case 33: return 55;
            case 32: return 54;
            case 31: return 53;
            case 29: return 48;
            case 28: return 47;
            case 27: return 46;
            case 26: return 45;
            case 15: return 18;
            default: return 66;
        }
    }

    private int yyr2() { // form : FORM IDENT '{' block '}'
        { yyrv = new Form(((org.uva.sea.ql.ast.expression.Ident)yysv[yysp-4]),((org.uva.sea.ql.ast.statement.Block)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 2;
    }

    private int yyr11() { // if : IF '(' expression ')' '{' block '}'
        { yyrv = new If(((org.uva.sea.ql.ast.Expression)yysv[yysp-5]),((org.uva.sea.ql.ast.statement.Block)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        switch (yyst[yysp-1]) {
            case 70: return 71;
            default: return 6;
        }
    }

    private int yyr12() { // ifcon : IF '(' expression ')' '{' block '}' ELSE '{' block '}'
        { yyrv = new If(((org.uva.sea.ql.ast.Expression)yysv[yysp-9]),((org.uva.sea.ql.ast.statement.Block)yysv[yysp-6]),((org.uva.sea.ql.ast.statement.Block)yysv[yysp-2])); }
        yysv[yysp-=11] = yyrv;
        return yypifcon();
    }

    private int yyr13() { // ifcon : IF '(' expression ')' '{' block '}' ELSE if
        { yyrv = new If(((org.uva.sea.ql.ast.Expression)yysv[yysp-7]),((org.uva.sea.ql.ast.statement.Block)yysv[yysp-4]),new Block(((org.uva.sea.ql.ast.statement.If)yysv[yysp-1]))); }
        yysv[yysp-=9] = yyrv;
        return yypifcon();
    }

    private int yyr14() { // ifcon : IF '(' expression ')' '{' block '}' ELSE ifcon
        { yyrv = new If(((org.uva.sea.ql.ast.Expression)yysv[yysp-7]),((org.uva.sea.ql.ast.statement.Block)yysv[yysp-4]),new Block(((org.uva.sea.ql.ast.statement.Block)yysv[yysp-1]))); }
        yysv[yysp-=9] = yyrv;
        return yypifcon();
    }

    private int yypifcon() {
        switch (yyst[yysp-1]) {
            case 70: return 72;
            default: return 7;
        }
    }

    private int yyr8() { // question : STR dec
        { yyrv = new QuestionVar(((org.uva.sea.ql.ast.expression.value.Str)yysv[yysp-2]),((org.uva.sea.ql.ast.statement.Var)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 8;
    }

    private int yyr9() { // question : STR IDENT '=' expression
        { yyrv = new QuestionComputed(((org.uva.sea.ql.ast.expression.value.Str)yysv[yysp-4]),((org.uva.sea.ql.ast.expression.Ident)yysv[yysp-3]),((org.uva.sea.ql.ast.Expression)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 8;
    }

    private int yyr5() { // statement : question
        yysp -= 1;
        return 9;
    }

    private int yyr6() { // statement : ifcon
        yysp -= 1;
        return 9;
    }

    private int yyr7() { // statement : if
        yysp -= 1;
        return 9;
    }

    private int yyr3() { // block : /* empty */
        { yyrv = new Block(); }
        yysv[yysp-=0] = yyrv;
        return yypblock();
    }

    private int yyr4() { // block : statement block
        { yyrv = new Block(((org.uva.sea.ql.ast.Statement)yysv[yysp-2]), ((org.uva.sea.ql.ast.statement.Block)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypblock();
    }

    private int yypblock() {
        switch (yyst[yysp-1]) {
            case 60: return 68;
            case 9: return 13;
            case 5: return 10;
            default: return 74;
        }
    }

    private int yyr32() { // type : INT
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 19;
    }

    private int yyr33() { // type : BOOL
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Bool)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 19;
    }

    private int yyr34() { // type : TRUE
        { yyrv = new org.uva.sea.ql.ast.expression.value.Bool(true); }
        yysv[yysp-=1] = yyrv;
        return 19;
    }

    private int yyr35() { // type : FALSE
        { yyrv = new org.uva.sea.ql.ast.expression.value.Bool(false); }
        yysv[yysp-=1] = yyrv;
        return 19;
    }

    private int yyr36() { // type : STR
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Str)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 19;
    }

    private int yyr37() { // type : IDENT
        { yyrv = ((org.uva.sea.ql.ast.expression.Ident)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 19;
    }

    protected String[] yyerrmsgs = {
    };

private QLLexer lexer; 

private Form result;

public Form getResult() {
  return result;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
