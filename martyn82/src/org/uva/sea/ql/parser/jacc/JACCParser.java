// Output created by jacc on Mon Feb 18 17:01:20 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.arithmetic.*;
import org.uva.sea.ql.ast.expression.binary.comparison.*;
import org.uva.sea.ql.ast.expression.binary.logical.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.unary.logical.*;
import org.uva.sea.ql.ast.expression.unary.numeric.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.*;

class JACCParser implements QLTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private org.uva.sea.ql.ast.Node[] yysv;
    private org.uva.sea.ql.ast.Node yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new org.uva.sea.ql.ast.Node[yyss];
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
                case 89:
                    switch (yytok) {
                        case FORM:
                            yyn = 9;
                            continue;
                        case IDENT:
                            yyn = 10;
                            continue;
                        case IF:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 178;
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    yyn = yys3();
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys5();
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    yyn = yys6();
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    yyn = yys7();
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 181;
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
                case 98:
                    switch (yytok) {
                        case IDENT:
                            yyn = 13;
                            continue;
                    }
                    yyn = 181;
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
                case 99:
                    switch (yytok) {
                        case '=':
                            yyn = 14;
                            continue;
                    }
                    yyn = 181;
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
                case 100:
                    switch (yytok) {
                        case '(':
                            yyn = 15;
                            continue;
                    }
                    yyn = 181;
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
                case 101:
                    switch (yytok) {
                        case IDENT:
                            yyn = 18;
                            continue;
                    }
                    yyn = 181;
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
                case 102:
                    switch (yytok) {
                        case '{':
                            yyn = 19;
                            continue;
                    }
                    yyn = 181;
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
                case 103:
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
                case 104:
                    yyn = yys15();
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    yyn = yys16();
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
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
                case 107:
                    switch (yytok) {
                        case '=':
                            yyn = 14;
                            continue;
                        case ':':
                            yyn = 38;
                            continue;
                    }
                    yyn = 181;
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
                case 108:
                    switch (yytok) {
                        case FORM:
                            yyn = 9;
                            continue;
                        case IDENT:
                            yyn = 10;
                            continue;
                        case IF:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    yyn = yys20();
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    yyn = yys21();
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    yyn = yys23();
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    yyn = yys24();
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
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
                case 115:
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
                case 116:
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
                case 117:
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
                case 118:
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
                case 119:
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
                case 120:
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
                case 121:
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
                case 122:
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
                case 123:
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
                case 124:
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
                case 125:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
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
                case 127:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 60;
                            continue;
                        case INTEGER:
                            yyn = 61;
                            continue;
                        case MONEY:
                            yyn = 62;
                            continue;
                        case STRING:
                            yyn = 63;
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    switch (yytok) {
                        case '}':
                            yyn = 64;
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    switch (yytok) {
                        case FORM:
                            yyn = 9;
                            continue;
                        case IDENT:
                            yyn = 10;
                            continue;
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
                    yyn = 181;
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    switch (yytok) {
                        case '}':
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 181;
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
                case 131:
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
                case 132:
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
                case 133:
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
                case 134:
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
                case 135:
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
                case 136:
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
                case 137:
                    yyn = yys48();
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
                case 138:
                    yyn = yys49();
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
                case 139:
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
                case 140:
                    yyn = yys51();
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
                case 141:
                    yyn = yys52();
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
                case 142:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
                    yyn = yys57();
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
                case 147:
                    switch (yytok) {
                        case '{':
                            yyn = 79;
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 148:
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
                case 149:
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
                case 150:
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
                case 151:
                    yyn = yys62();
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
                case 152:
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
                case 153:
                    yyn = yys64();
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
                    switch (yytok) {
                        case '}':
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    yyn = yys66();
                    continue;

                case 67:
                    yyst[yysp] = 67;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 156:
                    yyn = yys67();
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 157:
                    yyn = yys68();
                    continue;

                case 69:
                    yyst[yysp] = 69;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 158:
                    yyn = yys69();
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 159:
                    yyn = yys70();
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 160:
                    yyn = yys71();
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 161:
                    yyn = yys72();
                    continue;

                case 73:
                    yyst[yysp] = 73;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 162:
                    yyn = yys73();
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 163:
                    yyn = yys74();
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 164:
                    yyn = yys75();
                    continue;

                case 76:
                    yyst[yysp] = 76;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 165:
                    yyn = yys76();
                    continue;

                case 77:
                    yyst[yysp] = 77;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 166:
                    yyn = yys77();
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
                case 167:
                    yyn = yys78();
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
                case 168:
                    switch (yytok) {
                        case FORM:
                            yyn = 9;
                            continue;
                        case IDENT:
                            yyn = 10;
                            continue;
                        case IF:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                        case '}':
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 80:
                    yyst[yysp] = 80;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 169:
                    switch (yytok) {
                        case '}':
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 81:
                    yyst[yysp] = 81;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 170:
                    switch (yytok) {
                        case '}':
                            yyn = 82;
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 82:
                    yyst[yysp] = 82;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 171:
                    yyn = yys82();
                    continue;

                case 83:
                    yyst[yysp] = 83;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 172:
                    switch (yytok) {
                        case IF:
                            yyn = 11;
                            continue;
                        case '{':
                            yyn = 86;
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 84:
                    yyst[yysp] = 84;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 173:
                    yyn = yys84();
                    continue;

                case 85:
                    yyst[yysp] = 85;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 174:
                    yyn = yys85();
                    continue;

                case 86:
                    yyst[yysp] = 86;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 175:
                    switch (yytok) {
                        case FORM:
                            yyn = 9;
                            continue;
                        case IDENT:
                            yyn = 10;
                            continue;
                        case IF:
                            yyn = 11;
                            continue;
                        case STR:
                            yyn = 12;
                            continue;
                        case '}':
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 87:
                    yyst[yysp] = 87;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 176:
                    switch (yytok) {
                        case '}':
                            yyn = 88;
                            continue;
                    }
                    yyn = 181;
                    continue;

                case 88:
                    yyst[yysp] = 88;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 177:
                    yyn = yys88();
                    continue;

                case 178:
                    return true;
                case 179:
                    yyerror("stack overflow");
                case 180:
                    return false;
                case 181:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        org.uva.sea.ql.ast.Node[] newyysv = new org.uva.sea.ql.ast.Node[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys2() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr7();
        }
        return 181;
    }

    private int yys3() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr6();
        }
        return 181;
    }

    private int yys4() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr4();
        }
        return 181;
    }

    private int yys5() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr12();
        }
        return 181;
    }

    private int yys6() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr13();
        }
        return 181;
    }

    private int yys7() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr5();
        }
        return 181;
    }

    private int yys14() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys15() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys16() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr11();
        }
        return 181;
    }

    private int yys17() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr10();
        }
        return 181;
    }

    private int yys20() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr47();
        }
        return 181;
    }

    private int yys21() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr37();
        }
        return 181;
    }

    private int yys22() {
        switch (yytok) {
            case AND:
                return 42;
            case EQ:
                return 43;
            case GEQ:
                return 44;
            case LEQ:
                return 45;
            case NEQ:
                return 46;
            case OR:
                return 47;
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case '<':
                return 52;
            case '>':
                return 53;
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr21();
        }
        return 181;
    }

    private int yys23() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr40();
        }
        return 181;
    }

    private int yys24() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr39();
        }
        return 181;
    }

    private int yys25() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr38();
        }
        return 181;
    }

    private int yys26() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr42();
        }
        return 181;
    }

    private int yys27() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr49();
        }
        return 181;
    }

    private int yys28() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr46();
        }
        return 181;
    }

    private int yys29() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr44();
        }
        return 181;
    }

    private int yys30() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr43();
        }
        return 181;
    }

    private int yys31() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr45();
        }
        return 181;
    }

    private int yys32() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr48();
        }
        return 181;
    }

    private int yys33() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys34() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys35() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys36() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys37() {
        switch (yytok) {
            case AND:
                return 42;
            case EQ:
                return 43;
            case GEQ:
                return 44;
            case LEQ:
                return 45;
            case NEQ:
                return 46;
            case OR:
                return 47;
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case '<':
                return 52;
            case '>':
                return 53;
            case ')':
                return 58;
        }
        return 181;
    }

    private int yys42() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys43() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys44() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys45() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys46() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys47() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys48() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys49() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys50() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys51() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys52() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys53() {
        switch (yytok) {
            case BOOL:
                return 26;
            case FALSE:
                return 27;
            case IDENT:
                return 28;
            case INT:
                return 29;
            case MON:
                return 30;
            case STR:
                return 31;
            case TRUE:
                return 32;
            case '!':
                return 33;
            case '(':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
        }
        return 181;
    }

    private int yys54() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr36();
        }
        return 181;
    }

    private int yys55() {
        switch (yytok) {
            case AND:
                return 42;
            case EQ:
                return 43;
            case GEQ:
                return 44;
            case LEQ:
                return 45;
            case NEQ:
                return 46;
            case OR:
                return 47;
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case '<':
                return 52;
            case '>':
                return 53;
            case ')':
                return 78;
        }
        return 181;
    }

    private int yys56() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr34();
        }
        return 181;
    }

    private int yys57() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr35();
        }
        return 181;
    }

    private int yys59() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr20();
        }
        return 181;
    }

    private int yys60() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr50();
        }
        return 181;
    }

    private int yys61() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr52();
        }
        return 181;
    }

    private int yys62() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr51();
        }
        return 181;
    }

    private int yys63() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr53();
        }
        return 181;
    }

    private int yys64() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr8();
        }
        return 181;
    }

    private int yys66() {
        switch (yytok) {
            case EQ:
                return 43;
            case GEQ:
                return 44;
            case LEQ:
                return 45;
            case NEQ:
                return 46;
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case '<':
                return 52;
            case '>':
                return 53;
            case FORM:
            case ')':
            case IF:
            case '}':
            case STR:
            case IDENT:
            case OR:
            case ENDINPUT:
            case AND:
                return yyr32();
        }
        return 181;
    }

    private int yys67() {
        switch (yytok) {
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '}':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr22();
        }
        return 181;
    }

    private int yys68() {
        switch (yytok) {
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '}':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr26();
        }
        return 181;
    }

    private int yys69() {
        switch (yytok) {
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '}':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr27();
        }
        return 181;
    }

    private int yys70() {
        switch (yytok) {
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '}':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 181;
    }

    private int yys71() {
        switch (yytok) {
            case AND:
                return 42;
            case EQ:
                return 43;
            case GEQ:
                return 44;
            case LEQ:
                return 45;
            case NEQ:
                return 46;
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case '<':
                return 52;
            case '>':
                return 53;
            case FORM:
            case ')':
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
            case OR:
                return yyr33();
        }
        return 181;
    }

    private int yys72() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr28();
        }
        return 181;
    }

    private int yys73() {
        switch (yytok) {
            case '*':
                return 48;
            case '/':
                return 51;
            case '-':
            case '+':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '}':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr30();
        }
        return 181;
    }

    private int yys74() {
        switch (yytok) {
            case '*':
                return 48;
            case '/':
                return 51;
            case '-':
            case '+':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '}':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr31();
        }
        return 181;
    }

    private int yys75() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr29();
        }
        return 181;
    }

    private int yys76() {
        switch (yytok) {
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '}':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr25();
        }
        return 181;
    }

    private int yys77() {
        switch (yytok) {
            case '*':
                return 48;
            case '+':
                return 49;
            case '-':
                return 50;
            case '/':
                return 51;
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '}':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr24();
        }
        return 181;
    }

    private int yys78() {
        switch (yytok) {
            case '-':
            case '*':
            case FORM:
            case ')':
            case LEQ:
            case IF:
            case EQ:
            case '+':
            case '}':
            case '/':
            case STR:
            case IDENT:
            case '>':
            case OR:
            case '<':
            case NEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr41();
        }
        return 181;
    }

    private int yys82() {
        switch (yytok) {
            case ELSE:
                return 83;
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr16();
        }
        return 181;
    }

    private int yys84() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr18();
        }
        return 181;
    }

    private int yys85() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr19();
        }
        return 181;
    }

    private int yys88() {
        switch (yytok) {
            case FORM:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case IDENT:
                return yyr17();
        }
        return 181;
    }

    private int yyr1() { // start : statement
        { result = ((Statement)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr21() { // assignment : IDENT '=' expression
        { yyrv = new Assignment( ((IdentifierExpression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        switch (yyst[yysp-1]) {
            case 12: return 16;
            default: return 2;
        }
    }

    private int yyr12() { // blockstatement : ifthen
        yysp -= 1;
        return 3;
    }

    private int yyr13() { // blockstatement : ifthenelse
        yysp -= 1;
        return 3;
    }

    private int yyr48() { // boolliteral : TRUE
        { yyrv = new BooleanLiteral( true ); }
        yysv[yysp-=1] = yyrv;
        return 20;
    }

    private int yyr49() { // boolliteral : FALSE
        { yyrv = new BooleanLiteral( false ); }
        yysv[yysp-=1] = yyrv;
        return 20;
    }

    private int yyr22() { // comparison : expression EQ expression
        { yyrv = new EqualExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 21;
    }

    private int yyr23() { // comparison : expression NEQ expression
        { yyrv = new NotEqualExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 21;
    }

    private int yyr24() { // comparison : expression '>' expression
        { yyrv = new GreaterThanExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 21;
    }

    private int yyr25() { // comparison : expression '<' expression
        { yyrv = new LesserThanExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 21;
    }

    private int yyr26() { // comparison : expression GEQ expression
        { yyrv = new GreaterThanOrEqualExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 21;
    }

    private int yyr27() { // comparison : expression LEQ expression
        { yyrv = new LesserThanOrEqualExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 21;
    }

    private int yyr50() { // datatype : BOOLEAN
        { yyrv = BooleanType.BOOLEAN; }
        yysv[yysp-=1] = yyrv;
        return 59;
    }

    private int yyr51() { // datatype : MONEY
        { yyrv = MoneyType.MONEY; }
        yysv[yysp-=1] = yyrv;
        return 59;
    }

    private int yyr52() { // datatype : INTEGER
        { yyrv = IntegerType.INTEGER; }
        yysv[yysp-=1] = yyrv;
        return 59;
    }

    private int yyr53() { // datatype : STRING
        { yyrv = StringType.STRING; }
        yysv[yysp-=1] = yyrv;
        return 59;
    }

    private int yyr34() { // expression : '+' expression
        { yyrv = new PositiveExpression( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr35() { // expression : '-' expression
        { yyrv = new NegativeExpression( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr36() { // expression : '!' expression
        { yyrv = new NotExpression( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr37() { // expression : comparison
        yysp -= 1;
        return yypexpression();
    }

    private int yyr38() { // expression : arithmetic
        yysp -= 1;
        return yypexpression();
    }

    private int yyr39() { // expression : logical
        yysp -= 1;
        return yypexpression();
    }

    private int yyr40() { // expression : literal
        yysp -= 1;
        return yypexpression();
    }

    private int yyr41() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 52: return 76;
            case 51: return 75;
            case 50: return 74;
            case 49: return 73;
            case 48: return 72;
            case 47: return 71;
            case 46: return 70;
            case 45: return 69;
            case 44: return 68;
            case 43: return 67;
            case 42: return 66;
            case 36: return 57;
            case 35: return 56;
            case 34: return 55;
            case 33: return 54;
            case 15: return 37;
            case 14: return 22;
            default: return 77;
        }
    }

    private int yyr8() { // form : FORM IDENT '{' formbody '}'
        { yyrv = new FormDeclaration( ((IdentifierExpression)yysv[yysp-4]).getName(), ((Statements)yysv[yysp-2]) ); }
        yysv[yysp-=5] = yyrv;
        return 4;
    }

    private int yyr9() { // formbody : statements
        yysp -= 1;
        switch (yyst[yysp-1]) {
            case 19: return 39;
            default: return 80;
        }
    }

    private int yyr14() { // ifbody : formbody
        yysp -= 1;
        return yypifbody();
    }

    private int yyr15() { // ifbody : /* empty */
        { yyrv = new Statements(); }
        yysv[yysp-=0] = yyrv;
        return yypifbody();
    }

    private int yypifbody() {
        switch (yyst[yysp-1]) {
            case 79: return 81;
            default: return 87;
        }
    }

    private int yyr16() { // ifthen : IF '(' expression ')' '{' ifbody '}'
        { yyrv = new IfThen( ((Expression)yysv[yysp-5]), ((Statements)yysv[yysp-2]) ); }
        yysv[yysp-=7] = yyrv;
        switch (yyst[yysp-1]) {
            case 83: return 84;
            default: return 5;
        }
    }

    private int yyr17() { // ifthenelse : IF '(' expression ')' '{' ifbody '}' ELSE '{' ifbody '}'
        { yyrv = new IfThenElse( ((Expression)yysv[yysp-9]), ((Statements)yysv[yysp-6]), ((Statements)yysv[yysp-2]) ); }
        yysv[yysp-=11] = yyrv;
        return yypifthenelse();
    }

    private int yyr18() { // ifthenelse : IF '(' expression ')' '{' ifbody '}' ELSE ifthen
        { yyrv = new IfThenElse( ((Expression)yysv[yysp-7]), ((Statements)yysv[yysp-4]), new Statements( ((IfThen)yysv[yysp-1]) ) ); }
        yysv[yysp-=9] = yyrv;
        return yypifthenelse();
    }

    private int yyr19() { // ifthenelse : IF '(' expression ')' '{' ifbody '}' ELSE ifthenelse
        { yyrv = new IfThenElse( ((Expression)yysv[yysp-7]), ((Statements)yysv[yysp-4]), new Statements( ((IfThenElse)yysv[yysp-1]) ) ); }
        yysv[yysp-=9] = yyrv;
        return yypifthenelse();
    }

    private int yypifthenelse() {
        switch (yyst[yysp-1]) {
            case 83: return 85;
            default: return 6;
        }
    }

    private int yyr42() { // literal : BOOL
        { yyrv = ((BooleanLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 23;
    }

    private int yyr43() { // literal : MON
        { yyrv = ((MoneyLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 23;
    }

    private int yyr44() { // literal : INT
        { yyrv = ((IntegerLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 23;
    }

    private int yyr45() { // literal : STR
        { yyrv = ((StringLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 23;
    }

    private int yyr46() { // literal : IDENT
        { yyrv = ((IdentifierExpression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 23;
    }

    private int yyr47() { // literal : boolliteral
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 23;
    }

    private int yyr32() { // logical : expression AND expression
        { yyrv = new AndExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 24;
    }

    private int yyr33() { // logical : expression OR expression
        { yyrv = new OrExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 24;
    }

    private int yyr10() { // question : STR vardeclaration
        { yyrv = new VariableQuestion( ((StringLiteral)yysv[yysp-2]), ((VariableDeclaration)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return 7;
    }

    private int yyr11() { // question : STR assignment
        { yyrv = new ComputedQuestion( ((StringLiteral)yysv[yysp-2]), ((Assignment)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return 7;
    }

    private int yyr28() { // arithmetic : expression '*' expression
        { yyrv = new MultiplyExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 25;
    }

    private int yyr29() { // arithmetic : expression '/' expression
        { yyrv = new DivideExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 25;
    }

    private int yyr30() { // arithmetic : expression '+' expression
        { yyrv = new AddExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 25;
    }

    private int yyr31() { // arithmetic : expression '-' expression
        { yyrv = new SubtractExpression( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 25;
    }

    private int yyr4() { // statement : form
        yysp -= 1;
        return yypstatement();
    }

    private int yyr5() { // statement : question
        yysp -= 1;
        return yypstatement();
    }

    private int yyr6() { // statement : blockstatement
        yysp -= 1;
        return yypstatement();
    }

    private int yyr7() { // statement : assignment
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 0: return 8;
            default: return 40;
        }
    }

    private int yyr2() { // statements : statement statements
        { yyrv = new Statements( ((Statement)yysv[yysp-2]), ((Statements)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypstatements();
    }

    private int yyr3() { // statements : statement
        { yyrv = new Statements( ((Statement)yysv[yysp-1]) ); }
        yysv[yysp-=1] = yyrv;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 40: return 65;
            default: return 41;
        }
    }

    private int yyr20() { // vardeclaration : IDENT ':' datatype
        { yyrv = new VariableDeclaration( ((IdentifierExpression)yysv[yysp-3]), ((Type)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return 17;
    }

    protected String[] yyerrmsgs = {
    };

    private QLLexer lexer;
    private Statement result;
    
    public JACCParser( QLLexer lexer ) { 
        this.lexer = lexer;
    }
    
    public Statement getResult() {
        return result;
    }
    
    private void yyerror( String msg ) { 
        System.err.println( msg );
    }

}
