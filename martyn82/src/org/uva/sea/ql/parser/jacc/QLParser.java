// Output created by jacc on Sun Jan 20 00:33:12 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.Type;

class QLParser implements QLTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private org.uva.sea.ql.ast.INode[] yysv;
    private org.uva.sea.ql.ast.INode yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new org.uva.sea.ql.ast.INode[yyss];
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
                case 94:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 188;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    yyn = yys5();
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    yyn = yys8();
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    yyn = yys9();
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys12();
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 191;
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
                case 109:
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
                case 110:
                    switch (yytok) {
                        case IDENT:
                            yyn = 39;
                            continue;
                    }
                    yyn = 191;
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
                case 111:
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
                case 112:
                    switch (yytok) {
                        case '(':
                            yyn = 42;
                            continue;
                    }
                    yyn = 191;
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
                case 113:
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
                case 114:
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
                case 115:
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
                case 116:
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
                case 117:
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
                case 118:
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
                case 119:
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
                case 120:
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
                case 121:
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
                case 122:
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
                case 123:
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
                case 124:
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
                case 125:
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
                case 126:
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
                case 127:
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
                case 128:
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
                case 129:
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
                case 130:
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
                case 131:
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
                case 132:
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
                case 133:
                    switch (yytok) {
                        case '{':
                            yyn = 65;
                            continue;
                    }
                    yyn = 191;
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
                case 134:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 67;
                            continue;
                        case INTEGER:
                            yyn = 68;
                            continue;
                        case MONEY:
                            yyn = 69;
                            continue;
                        case STRING:
                            yyn = 70;
                            continue;
                    }
                    yyn = 191;
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
                case 135:
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
                case 136:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 191;
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
                case 139:
                    switch (yytok) {
                        case ':':
                            yyn = 40;
                            continue;
                        case '=':
                            yyn = 41;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
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
                case 141:
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
                case 142:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 147:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 148:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 149:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 150:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 151:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 152:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 153:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
                    yyn = yys60();
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 156:
                    yyn = yys62();
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 157:
                    yyn = yys63();
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 158:
                    yyn = yys64();
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
                case 159:
                    switch (yytok) {
                        case IF:
                            yyn = 18;
                            continue;
                        case IDENT:
                            yyn = 45;
                            continue;
                        case STR:
                            yyn = 77;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 160:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr24();
                            continue;
                    }
                    yyn = 191;
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
                case 161:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr52();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 162:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr54();
                            continue;
                    }
                    yyn = 191;
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
                case 163:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr53();
                            continue;
                    }
                    yyn = 191;
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
                case 164:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr55();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 165:
                    yyn = yys71();
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 166:
                    yyn = yys72();
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
                case 167:
                    yyn = yys73();
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 168:
                    switch (yytok) {
                        case '}':
                            yyn = 79;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 169:
                    switch (yytok) {
                        case IF:
                            yyn = 18;
                            continue;
                        case IDENT:
                            yyn = 45;
                            continue;
                        case STR:
                            yyn = 77;
                            continue;
                        case '}':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 76:
                    yyst[yysp] = 76;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 170:
                    switch (yytok) {
                        case '}':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 77:
                    yyst[yysp] = 77;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 171:
                    switch (yytok) {
                        case IDENT:
                            yyn = 45;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 78:
                    yyst[yysp] = 78;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 172:
                    switch (yytok) {
                        case '{':
                            yyn = 81;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 79:
                    yyst[yysp] = 79;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 173:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 80:
                    yyst[yysp] = 80;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 174:
                    switch (yytok) {
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 81:
                    yyst[yysp] = 81;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 175:
                    switch (yytok) {
                        case IF:
                            yyn = 18;
                            continue;
                        case IDENT:
                            yyn = 45;
                            continue;
                        case STR:
                            yyn = 77;
                            continue;
                        case '}':
                            yyn = 84;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 82:
                    yyst[yysp] = 82;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 176:
                    switch (yytok) {
                        case '}':
                            yyn = yyr23();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 83:
                    yyst[yysp] = 83;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 177:
                    switch (yytok) {
                        case '}':
                            yyn = 85;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 84:
                    yyst[yysp] = 84;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 178:
                    yyn = yys84();
                    continue;

                case 85:
                    yyst[yysp] = 85;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 179:
                    yyn = yys85();
                    continue;

                case 86:
                    yyst[yysp] = 86;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 180:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 87:
                    yyst[yysp] = 87;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 181:
                    switch (yytok) {
                        case IF:
                            yyn = 18;
                            continue;
                        case '{':
                            yyn = 90;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 88:
                    yyst[yysp] = 88;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 182:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 89:
                    yyst[yysp] = 89;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 183:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr20();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 90:
                    yyst[yysp] = 90;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 184:
                    switch (yytok) {
                        case IF:
                            yyn = 18;
                            continue;
                        case IDENT:
                            yyn = 45;
                            continue;
                        case STR:
                            yyn = 77;
                            continue;
                        case '}':
                            yyn = 92;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 91:
                    yyst[yysp] = 91;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 185:
                    switch (yytok) {
                        case '}':
                            yyn = 93;
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 92:
                    yyst[yysp] = 92;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 186:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr22();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 93:
                    yyst[yysp] = 93;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 187:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IF:
                        case STR:
                        case IDENT:
                            yyn = yyr21();
                            continue;
                    }
                    yyn = 191;
                    continue;

                case 188:
                    return true;
                case 189:
                    yyerror("stack overflow");
                case 190:
                    return false;
                case 191:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        org.uva.sea.ql.ast.INode[] newyysv = new org.uva.sea.ql.ast.INode[2*yyst.length];
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
                return 15;
            case FORM:
                return 16;
            case IDENT:
                return 17;
            case IF:
                return 18;
            case INT:
                return 19;
            case MON:
                return 20;
            case STR:
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
        return 191;
    }

    private int yys4() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr42();
        }
        return 191;
    }

    private int yys5() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case GEQ:
                return 28;
            case LEQ:
                return 29;
            case NEQ:
                return 30;
            case OR:
                return 31;
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '<':
                return 36;
            case '>':
                return 37;
            case '^':
                return 38;
            case ENDINPUT:
                return yyr4();
        }
        return 191;
    }

    private int yys8() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr45();
        }
        return 191;
    }

    private int yys9() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr44();
        }
        return 191;
    }

    private int yys12() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr43();
        }
        return 191;
    }

    private int yys15() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr47();
        }
        return 191;
    }

    private int yys17() {
        switch (yytok) {
            case ':':
                return 40;
            case '=':
                return 41;
            case NEQ:
            case '/':
            case '-':
            case GEQ:
            case '+':
            case '*':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '^':
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr51();
        }
        return 191;
    }

    private int yys19() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr49();
        }
        return 191;
    }

    private int yys20() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr48();
        }
        return 191;
    }

    private int yys21() {
        switch (yytok) {
            case IDENT:
                return 45;
            case NEQ:
            case '/':
            case '-':
            case GEQ:
            case '+':
            case '*':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '^':
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr50();
        }
        return 191;
    }

    private int yys22() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys23() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys24() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys25() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys26() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys27() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys28() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys29() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys30() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys31() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys32() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys33() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys34() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys35() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys36() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys37() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys38() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys41() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys42() {
        switch (yytok) {
            case BOOL:
                return 15;
            case INT:
                return 19;
            case MON:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case IDENT:
                return 47;
            case STR:
                return 48;
        }
        return 191;
    }

    private int yys46() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr41();
        }
        return 191;
    }

    private int yys47() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr51();
        }
        return 191;
    }

    private int yys48() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr50();
        }
        return 191;
    }

    private int yys49() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case GEQ:
                return 28;
            case LEQ:
                return 29;
            case NEQ:
                return 30;
            case OR:
                return 31;
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '<':
                return 36;
            case '>':
                return 37;
            case '^':
                return 38;
            case ')':
                return 73;
        }
        return 191;
    }

    private int yys50() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr39();
        }
        return 191;
    }

    private int yys51() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr40();
        }
        return 191;
    }

    private int yys52() {
        switch (yytok) {
            case EQ:
                return 27;
            case GEQ:
                return 28;
            case LEQ:
                return 29;
            case NEQ:
                return 30;
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '<':
                return 36;
            case '>':
                return 37;
            case '^':
                return 38;
            case ')':
            case ENDINPUT:
            case '}':
            case IF:
            case STR:
            case OR:
            case IDENT:
            case AND:
                return yyr37();
        }
        return 191;
    }

    private int yys53() {
        switch (yytok) {
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '^':
                return 38;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr26();
        }
        return 191;
    }

    private int yys54() {
        switch (yytok) {
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '^':
                return 38;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr30();
        }
        return 191;
    }

    private int yys55() {
        switch (yytok) {
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '^':
                return 38;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr31();
        }
        return 191;
    }

    private int yys56() {
        switch (yytok) {
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '^':
                return 38;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr27();
        }
        return 191;
    }

    private int yys57() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case GEQ:
                return 28;
            case LEQ:
                return 29;
            case NEQ:
                return 30;
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '<':
                return 36;
            case '>':
                return 37;
            case '^':
                return 38;
            case ')':
            case ENDINPUT:
            case '}':
            case IF:
            case STR:
            case OR:
            case IDENT:
                return yyr38();
        }
        return 191;
    }

    private int yys58() {
        switch (yytok) {
            case '^':
                return 38;
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case ')':
            case LEQ:
            case '/':
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr32();
        }
        return 191;
    }

    private int yys59() {
        switch (yytok) {
            case '*':
                return 32;
            case '/':
                return 35;
            case '^':
                return 38;
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr34();
        }
        return 191;
    }

    private int yys60() {
        switch (yytok) {
            case '*':
                return 32;
            case '/':
                return 35;
            case '^':
                return 38;
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr35();
        }
        return 191;
    }

    private int yys61() {
        switch (yytok) {
            case '^':
                return 38;
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case ')':
            case LEQ:
            case '/':
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr33();
        }
        return 191;
    }

    private int yys62() {
        switch (yytok) {
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '^':
                return 38;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr29();
        }
        return 191;
    }

    private int yys63() {
        switch (yytok) {
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '^':
                return 38;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '}':
            case IF:
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr28();
        }
        return 191;
    }

    private int yys64() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr36();
        }
        return 191;
    }

    private int yys71() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case GEQ:
                return 28;
            case LEQ:
                return 29;
            case NEQ:
                return 30;
            case OR:
                return 31;
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '<':
                return 36;
            case '>':
                return 37;
            case '^':
                return 38;
            case ENDINPUT:
            case '}':
            case IF:
            case STR:
            case IDENT:
                return yyr25();
        }
        return 191;
    }

    private int yys72() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case GEQ:
                return 28;
            case LEQ:
                return 29;
            case NEQ:
                return 30;
            case OR:
                return 31;
            case '*':
                return 32;
            case '+':
                return 33;
            case '-':
                return 34;
            case '/':
                return 35;
            case '<':
                return 36;
            case '>':
                return 37;
            case '^':
                return 38;
            case ')':
                return 78;
        }
        return 191;
    }

    private int yys73() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '*':
            case ')':
            case LEQ:
            case '+':
            case EQ:
            case '/':
            case ENDINPUT:
            case '}':
            case IF:
            case '^':
            case '>':
            case STR:
            case '<':
            case OR:
            case IDENT:
            case AND:
                return yyr46();
        }
        return 191;
    }

    private int yys84() {
        switch (yytok) {
            case ELSE:
                return 87;
            case ENDINPUT:
            case '}':
            case IF:
            case STR:
            case IDENT:
                return yyr19();
        }
        return 191;
    }

    private int yys85() {
        switch (yytok) {
            case ELSE:
                return 87;
            case ENDINPUT:
            case '}':
            case IF:
            case STR:
            case IDENT:
                return yyr17();
        }
        return 191;
    }

    private int yyr1() { // start : node
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr25() { // assignment : IDENT '=' expression
        { yyrv = new Assignment( ((org.uva.sea.ql.ast.expression.Ident)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        switch (yyst[yysp-1]) {
            case 77: return 43;
            case 21: return 43;
            default: return 2;
        }
    }

    private int yyr15() { // blockstatement : ifblock
        yysp -= 1;
        return 3;
    }

    private int yyr26() { // comparison : expression EQ expression
        { yyrv = new Eq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 4;
    }

    private int yyr27() { // comparison : expression NEQ expression
        { yyrv = new NEq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 4;
    }

    private int yyr28() { // comparison : expression '>' expression
        { yyrv = new GT( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 4;
    }

    private int yyr29() { // comparison : expression '<' expression
        { yyrv = new LT( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 4;
    }

    private int yyr30() { // comparison : expression GEQ expression
        { yyrv = new GEq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 4;
    }

    private int yyr31() { // comparison : expression LEQ expression
        { yyrv = new LEq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 4;
    }

    private int yyr39() { // expression : '+' expression
        { yyrv = new Pos( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr40() { // expression : '-' expression
        { yyrv = new Neg( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr41() { // expression : '!' expression
        { yyrv = new Not( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr42() { // expression : comparison
        yysp -= 1;
        return yypexpression();
    }

    private int yyr43() { // expression : arithmetic
        yysp -= 1;
        return yypexpression();
    }

    private int yyr44() { // expression : logical
        yysp -= 1;
        return yypexpression();
    }

    private int yyr45() { // expression : literal
        yysp -= 1;
        return yypexpression();
    }

    private int yyr46() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 41: return 71;
            case 38: return 64;
            case 37: return 63;
            case 36: return 62;
            case 35: return 61;
            case 34: return 60;
            case 33: return 59;
            case 32: return 58;
            case 31: return 57;
            case 30: return 56;
            case 29: return 55;
            case 28: return 54;
            case 27: return 53;
            case 26: return 52;
            case 25: return 51;
            case 24: return 50;
            case 23: return 49;
            case 22: return 46;
            case 0: return 5;
            default: return 72;
        }
    }

    private int yyr5() { // form : FORM IDENT '{' formbody '}'
        { yyrv = new FormDeclaration( ((org.uva.sea.ql.ast.expression.Ident)yysv[yysp-4]), ((Statements)yysv[yysp-2]) ); }
        yysv[yysp-=5] = yyrv;
        return 6;
    }

    private int yyr6() { // formbody : statements
        yysp -= 1;
        switch (yyst[yysp-1]) {
            case 65: return 74;
            default: return 82;
        }
    }

    private int yyr16() { // ifblock : IF '(' expression ')' '{' ifbody '}' ifelse
        { yyrv = new IfThenElse( ((Expression)yysv[yysp-6]), ((Statements)yysv[yysp-3]), ((Statements)yysv[yysp-1]) ); }
        yysv[yysp-=8] = yyrv;
        return yypifblock();
    }

    private int yyr17() { // ifblock : IF '(' expression ')' '{' ifbody '}'
        { yyrv = new IfThenElse( ((Expression)yysv[yysp-5]), ((Statements)yysv[yysp-2]) ); }
        yysv[yysp-=7] = yyrv;
        return yypifblock();
    }

    private int yyr18() { // ifblock : IF '(' expression ')' '{' '}' ifelse
        { yyrv = new IfThenElse( ((Expression)yysv[yysp-5]), null, ((Statements)yysv[yysp-1]) ); }
        yysv[yysp-=7] = yyrv;
        return yypifblock();
    }

    private int yyr19() { // ifblock : IF '(' expression ')' '{' '}'
        { yyrv = new IfThenElse( ((Expression)yysv[yysp-4]) ); }
        yysv[yysp-=6] = yyrv;
        return yypifblock();
    }

    private int yypifblock() {
        switch (yyst[yysp-1]) {
            case 87: return 89;
            default: return 7;
        }
    }

    private int yyr23() { // ifbody : formbody
        yysp -= 1;
        switch (yyst[yysp-1]) {
            case 81: return 83;
            default: return 91;
        }
    }

    private int yyr20() { // ifelse : ELSE ifblock
        { yyrv = new Statements( ((IfThenElse)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypifelse();
    }

    private int yyr21() { // ifelse : ELSE '{' ifbody '}'
        { yyrv = ((Statements)yysv[yysp-2]); }
        yysv[yysp-=4] = yyrv;
        return yypifelse();
    }

    private int yyr22() { // ifelse : ELSE '{' '}'
        { yyrv = null; }
        yysv[yysp-=3] = yyrv;
        return yypifelse();
    }

    private int yypifelse() {
        switch (yyst[yysp-1]) {
            case 84: return 86;
            default: return 88;
        }
    }

    private int yyr47() { // literal : BOOL
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Bool)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 8;
    }

    private int yyr48() { // literal : MON
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Money)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 8;
    }

    private int yyr49() { // literal : INT
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 8;
    }

    private int yyr50() { // literal : STR
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Str)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 8;
    }

    private int yyr51() { // literal : IDENT
        { yyrv = ((org.uva.sea.ql.ast.expression.Ident)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 8;
    }

    private int yyr37() { // logical : expression AND expression
        { yyrv = new And( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    private int yyr38() { // logical : expression OR expression
        { yyrv = new Or( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    private int yyr2() { // node : form
        yysp -= 1;
        return 10;
    }

    private int yyr3() { // node : statement
        yysp -= 1;
        return 10;
    }

    private int yyr4() { // node : expression
        yysp -= 1;
        return 10;
    }

    private int yyr13() { // question : STR vardeclaration
        { yyrv = new QuestionDeclaration( ((org.uva.sea.ql.ast.expression.value.Str)yysv[yysp-2]), ((VarDeclaration)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return 11;
    }

    private int yyr14() { // question : STR assignment
        { yyrv = new QuestionDeclaration( ((org.uva.sea.ql.ast.expression.value.Str)yysv[yysp-2]), ((Assignment)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return 11;
    }

    private int yyr32() { // arithmetic : expression '*' expression
        { yyrv = new Mul( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr33() { // arithmetic : expression '/' expression
        { yyrv = new Div( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr34() { // arithmetic : expression '+' expression
        { yyrv = new Add( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr35() { // arithmetic : expression '-' expression
        { yyrv = new Sub( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr36() { // arithmetic : expression '^' expression
        { yyrv = new Pow( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr9() { // statement : question
        yysp -= 1;
        return yypstatement();
    }

    private int yyr10() { // statement : blockstatement
        yysp -= 1;
        return yypstatement();
    }

    private int yyr11() { // statement : vardeclaration
        yysp -= 1;
        return yypstatement();
    }

    private int yyr12() { // statement : assignment
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 0: return 13;
            default: return 75;
        }
    }

    private int yyr7() { // statements : statement statements
        { yyrv = new Statements( ((Statement)yysv[yysp-2]), ((Statements)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypstatements();
    }

    private int yyr8() { // statements : statement
        { yyrv = new Statements( ((Statement)yysv[yysp-1]) ); }
        yysv[yysp-=1] = yyrv;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 75: return 80;
            default: return 76;
        }
    }

    private int yyr52() { // type : BOOLEAN
        { yyrv = ((org.uva.sea.ql.ast.type.Bool)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 66;
    }

    private int yyr53() { // type : MONEY
        { yyrv = ((org.uva.sea.ql.ast.type.Money)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 66;
    }

    private int yyr54() { // type : INTEGER
        { yyrv = ((org.uva.sea.ql.ast.type.Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 66;
    }

    private int yyr55() { // type : STRING
        { yyrv = ((org.uva.sea.ql.ast.type.Str)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 66;
    }

    private int yyr24() { // vardeclaration : IDENT ':' type
        { yyrv = new VarDeclaration( ((org.uva.sea.ql.ast.expression.Ident)yysv[yysp-3]), ((Type)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        switch (yyst[yysp-1]) {
            case 77: return 44;
            case 21: return 44;
            default: return 14;
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
    private INode result;
    
    /**
     * Retrieves the generated AST.
     *
     * @return The AST.
     */
    public INode getResult() {
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
