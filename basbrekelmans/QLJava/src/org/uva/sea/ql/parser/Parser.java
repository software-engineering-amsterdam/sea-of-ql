// Output created by jacc on Sun Jan 20 19:06:27 GMT 2013

package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;

class Parser implements Tokens {
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
                case 90:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 180;
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    yyn = yys3();
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    yyn = yys6();
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    yyn = yys10();
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 40;
                            continue;
                        case ENDINPUT:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    yyn = yys14();
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
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
                case 106:
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
                case 107:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 41;
                            continue;
                    }
                    yyn = 183;
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
                case 108:
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
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
                case 113:
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
                case 114:
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
                case 115:
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
                case 116:
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
                case 117:
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
                case 118:
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
                case 119:
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
                case 120:
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
                case 121:
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
                case 122:
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
                case 123:
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
                case 124:
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
                case 125:
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
                case 126:
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
                case 127:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 40;
                            continue;
                        case ENDINPUT:
                        case '}':
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 183;
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
                case 130:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 45;
                            continue;
                    }
                    yyn = 183;
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
                case 131:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 40;
                            continue;
                        case ENDINPUT:
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
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
                case 133:
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
                case 134:
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
                case 135:
                    switch (yytok) {
                        case ':':
                            yyn = 65;
                            continue;
                        case '=':
                            yyn = 66;
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 147:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 148:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 149:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 150:
                    yyn = yys60();
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 151:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 152:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 40;
                            continue;
                        case ENDINPUT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 183;
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
                case 153:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 40;
                            continue;
                        case '}':
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
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
                case 155:
                    switch (yytok) {
                        case TYPE:
                            yyn = 70;
                            continue;
                    }
                    yyn = 183;
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
                case 156:
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
                case 157:
                    yyn = yys67();
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 158:
                    switch (yytok) {
                        case '}':
                            yyn = 72;
                            continue;
                        case STRINGLITERAL:
                        case IF:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 183;
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
                case 159:
                    yyn = yys69();
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
                case 160:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 161:
                    yyn = yys71();
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 162:
                    switch (yytok) {
                        case ELSE:
                            yyn = 74;
                            continue;
                    }
                    yyn = 183;
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
                case 163:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 40;
                            continue;
                        case '}':
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 164:
                    switch (yytok) {
                        case '{':
                            yyn = 77;
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 165:
                    switch (yytok) {
                        case '}':
                            yyn = 78;
                            continue;
                        case STRINGLITERAL:
                        case IF:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 76:
                    yyst[yysp] = 76;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 166:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 40;
                            continue;
                        case '}':
                            yyn = 79;
                            continue;
                    }
                    yyn = 183;
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
                case 167:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 40;
                            continue;
                        case '}':
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 183;
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
                case 168:
                    switch (yytok) {
                        case ELSE:
                            yyn = 81;
                            continue;
                    }
                    yyn = 183;
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
                case 169:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 80:
                    yyst[yysp] = 80;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 170:
                    switch (yytok) {
                        case '}':
                            yyn = 82;
                            continue;
                        case STRINGLITERAL:
                        case IF:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 183;
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
                case 171:
                    switch (yytok) {
                        case '{':
                            yyn = 83;
                            continue;
                    }
                    yyn = 183;
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
                case 172:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 183;
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
                case 173:
                    switch (yytok) {
                        case IF:
                            yyn = 85;
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 84:
                    yyst[yysp] = 84;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 174:
                    switch (yytok) {
                        case '}':
                            yyn = 86;
                            continue;
                    }
                    yyn = 183;
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
                case 175:
                    switch (yytok) {
                        case '(':
                            yyn = 87;
                            continue;
                    }
                    yyn = 183;
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
                case 176:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case ENDINPUT:
                        case '}':
                        case IF:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 183;
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
                case 177:
                    yyn = yys87();
                    continue;

                case 88:
                    yyst[yysp] = 88;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 178:
                    yyn = yys88();
                    continue;

                case 89:
                    yyst[yysp] = 89;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 179:
                    switch (yytok) {
                        case '{':
                            yyn = 73;
                            continue;
                    }
                    yyn = 183;
                    continue;

                case 180:
                    return true;
                case 181:
                    yyerror("stack overflow");
                case 182:
                    return false;
                case 183:
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

    private int yys0() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case FORM:
                return 17;
            case IDENTIFIER:
                return 18;
            case IF:
                return 19;
            case NUMBERLITERAL:
                return 20;
            case STRINGLITERAL:
                return 21;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case ENDINPUT:
                return yyr18();
        }
        return 183;
    }

    private int yys3() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr23();
    }

    private int yys4() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case OR:
                return 30;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case ENDINPUT:
                return yyr2();
        }
        return 183;
    }

    private int yys6() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr20();
    }

    private int yys10() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr22();
    }

    private int yys14() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr21();
    }

    private int yys15() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr19();
    }

    private int yys16() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr42();
    }

    private int yys18() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr43();
    }

    private int yys19() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
            case '(':
                return 44;
        }
        return 183;
    }

    private int yys20() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr40();
    }

    private int yys21() {
        switch (yytok) {
            case IDENTIFIER:
                return 45;
            case '>':
            case '<':
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case NEQ:
            case LEQ:
            case ENDINPUT:
            case '^':
            case EQ:
            case AND:
                return yyr41();
        }
        return 183;
    }

    private int yys22() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys23() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys24() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys25() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys26() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys27() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys28() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys29() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys30() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys31() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys32() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys33() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys34() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys35() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys36() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys37() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys42() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case OR:
                return 30;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case '{':
                return 63;
        }
        return 183;
    }

    private int yys43() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr41();
    }

    private int yys44() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys46() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr32();
        }
        return 183;
    }

    private int yys47() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case OR:
                return 30;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case ')':
                return 67;
        }
        return 183;
    }

    private int yys48() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr30();
        }
        return 183;
    }

    private int yys49() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr31();
        }
        return 183;
    }

    private int yys50() {
        switch (yytok) {
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case STRINGLITERAL:
            case OR:
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case IF:
            case AND:
                return yyr33();
        }
        return 183;
    }

    private int yys51() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case OR:
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr25();
        }
        return 183;
    }

    private int yys52() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case OR:
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr29();
        }
        return 183;
    }

    private int yys53() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case OR:
                return 30;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case STRINGLITERAL:
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case IF:
                return yyr26();
        }
        return 183;
    }

    private int yys54() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case STRINGLITERAL:
            case OR:
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case IF:
                return yyr34();
        }
        return 183;
    }

    private int yys55() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr36();
        }
        return 183;
    }

    private int yys56() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '*':
                return 31;
            case '/':
                return 34;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case OR:
            case '-':
            case '+':
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr38();
        }
        return 183;
    }

    private int yys57() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '*':
                return 31;
            case '/':
                return 34;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case OR:
            case '-':
            case '+':
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr39();
        }
        return 183;
    }

    private int yys58() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr37();
        }
        return 183;
    }

    private int yys59() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case OR:
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr28();
        }
        return 183;
    }

    private int yys60() {
        switch (yytok) {
            case NEQ:
                return 29;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '^':
                return 37;
            case '>':
            case '<':
            case STRINGLITERAL:
            case OR:
            case ')':
            case LEQ:
            case '}':
            case '{':
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr27();
        }
        return 183;
    }

    private int yys61() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case OR:
                return 30;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case STRINGLITERAL:
            case ')':
            case ENDINPUT:
            case '}':
            case '{':
            case IF:
                return yyr35();
        }
        return 183;
    }

    private int yys64() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case OR:
                return 30;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case ')':
                return 69;
        }
        return 183;
    }

    private int yys66() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys67() {
        switch (yytok) {
            case GEQ:
            case error:
            case '=':
            case ':':
            case IDENTIFIER:
            case '!':
            case UMIN:
            case TYPE:
            case FORM:
            case ';':
            case ELSE:
            case NUMBERLITERAL:
            case NEW:
            case '(':
            case UNOT:
            case BOOLEANLITERAL:
            case UPLUS:
                return 183;
        }
        return yyr24();
    }

    private int yys69() {
        switch (yytok) {
            case '{':
                return 73;
            case '>':
            case '<':
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case NEQ:
            case LEQ:
            case '^':
            case EQ:
            case AND:
                return yyr24();
        }
        return 183;
    }

    private int yys71() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case OR:
                return 30;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case STRINGLITERAL:
            case ENDINPUT:
            case '}':
            case IF:
                return yyr17();
        }
        return 183;
    }

    private int yys87() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case '!':
                return 22;
            case '(':
                return 23;
            case '+':
                return 24;
            case '-':
                return 25;
            case STRINGLITERAL:
                return 43;
        }
        return 183;
    }

    private int yys88() {
        switch (yytok) {
            case AND:
                return 26;
            case EQ:
                return 27;
            case LEQ:
                return 28;
            case NEQ:
                return 29;
            case OR:
                return 30;
            case '*':
                return 31;
            case '+':
                return 32;
            case '-':
                return 33;
            case '/':
                return 34;
            case '<':
                return 35;
            case '>':
                return 36;
            case '^':
                return 37;
            case ')':
                return 89;
        }
        return 183;
    }

    private int yyr1() { // top : node
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr13() { // closedstatement : statements
        yysp -= 1;
        return yypclosedstatement();
    }

    private int yyr14() { // closedstatement : IF expression '{' closedstatement '}' ELSE '{' closedstatement '}'
        { yyrv = new If(lexer.location(), ((Expression)yysv[yysp-8]), yysv[yysp-6], yysv[yysp-2]); }
        yysv[yysp-=9] = yyrv;
        return yypclosedstatement();
    }

    private int yypclosedstatement() {
        switch (yyst[yysp-1]) {
            case 77: return 80;
            case 73: return 75;
            case 63: return 68;
            default: return 2;
        }
    }

    private int yyr25() { // comparison : expression EQ expression
        { yyrv = new Equals(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr26() { // comparison : expression NEQ expression
        { yyrv = new NotEquals(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr27() { // comparison : expression '>' expression
        { yyrv = new GreaterThan(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr28() { // comparison : expression '<' expression
        { yyrv = new LessThan(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr29() { // comparison : expression LEQ expression
        { yyrv = new LessThanOrEquals(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr19() { // expression : unary
        yysp -= 1;
        return yypexpression();
    }

    private int yyr20() { // expression : logical
        yysp -= 1;
        return yypexpression();
    }

    private int yyr21() { // expression : arithmetic
        yysp -= 1;
        return yypexpression();
    }

    private int yyr22() { // expression : simple
        yysp -= 1;
        return yypexpression();
    }

    private int yyr23() { // expression : comparison
        yysp -= 1;
        return yypexpression();
    }

    private int yyr24() { // expression : '(' expression ')'
        yysp -= 3;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 66: return 71;
            case 44: return 64;
            case 37: return 61;
            case 36: return 60;
            case 35: return 59;
            case 34: return 58;
            case 33: return 57;
            case 32: return 56;
            case 31: return 55;
            case 30: return 54;
            case 29: return 53;
            case 28: return 52;
            case 27: return 51;
            case 26: return 50;
            case 25: return 49;
            case 24: return 48;
            case 23: return 47;
            case 22: return 46;
            case 19: return 42;
            case 0: return 4;
            default: return 88;
        }
    }

    private int yyr5() { // form : FORM IDENTIFIER statements
        { result = new Form(lexer.location(), ((Identifier)yysv[yysp-2]), yysv[yysp-1]);  }
        yysv[yysp-=3] = yyrv;
        return 5;
    }

    private int yyr33() { // logical : expression AND expression
        { yyrv = new And(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr34() { // logical : expression OR expression
        { yyrv = new Or(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr35() { // logical : expression '^' expression
        { yyrv = new Xor(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr2() { // node : expression
        yysp -= 1;
        return 7;
    }

    private int yyr3() { // node : form
        yysp -= 1;
        return 7;
    }

    private int yyr4() { // node : statements
        yysp -= 1;
        return 7;
    }

    private int yyr11() { // openstatement : IF '(' expression ')' '{' statements '}'
        { yyrv = new If(lexer.location(), ((Expression)yysv[yysp-5]), yysv[yysp-2]); }
        yysv[yysp-=7] = yyrv;
        return yypopenstatement();
    }

    private int yyr12() { // openstatement : IF '(' expression ')' '{' closedstatement '}' ELSE '{' openstatement '}'
        { yyrv = new If(lexer.location(), ((Expression)yysv[yysp-9]), yysv[yysp-6], yysv[yysp-2]); }
        yysv[yysp-=11] = yyrv;
        return yypopenstatement();
    }

    private int yypopenstatement() {
        switch (yyst[yysp-1]) {
            case 83: return 84;
            default: return 8;
        }
    }

    private int yyr16() { // question : STRINGLITERAL IDENTIFIER ':' TYPE
        { yyrv = new Question(lexer.location(), ((StringLiteral)yysv[yysp-4]), ((Identifier)yysv[yysp-3]), ((TypeDeclaration)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 9;
    }

    private int yyr17() { // question : STRINGLITERAL IDENTIFIER '=' expression
        { yyrv = new Question(lexer.location(), ((StringLiteral)yysv[yysp-4]), ((Identifier)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 9;
    }

    private int yyr18() { // question : /* empty */
        return 9;
    }

    private int yyr40() { // simple : NUMBERLITERAL
        { yyrv = ((NumberLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 10;
    }

    private int yyr41() { // simple : STRINGLITERAL
        { yyrv = ((StringLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 10;
    }

    private int yyr42() { // simple : BOOLEANLITERAL
        { yyrv = ((BooleanLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 10;
    }

    private int yyr43() { // simple : IDENTIFIER
        { yyrv = ((Identifier)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 10;
    }

    private int yyr15() { // simplestatement : question
        yysp -= 1;
        return 11;
    }

    private int yyr8() { // statement : openstatement
        yysp -= 1;
        return yypstatement();
    }

    private int yyr9() { // statement : closedstatement
        yysp -= 1;
        return yypstatement();
    }

    private int yyr10() { // statement : simplestatement
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 76: return 38;
            case 62: return 38;
            case 39: return 38;
            case 13: return 38;
            default: return 12;
        }
    }

    private int yyr6() { // statements : statements statement
        { yyrv = chainStatements(yysv[yysp-2], ((Statement)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypstatements();
    }

    private int yyr7() { // statements : statement
        yysp -= 1;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 73: return 76;
            case 41: return 62;
            case 0: return 13;
            default: return 39;
        }
    }

    private int yyr36() { // arithmetic : expression '*' expression
        { yyrv = new Multiplication(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 14;
    }

    private int yyr37() { // arithmetic : expression '/' expression
        { yyrv = new Division(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 14;
    }

    private int yyr38() { // arithmetic : expression '+' expression
        { yyrv = new Addition(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 14;
    }

    private int yyr39() { // arithmetic : expression '-' expression
        { yyrv = new Subtraction(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]));}
        yysv[yysp-=3] = yyrv;
        return 14;
    }

    private int yyr30() { // unary : '+' expression
        { yyrv = new UnaryPlus(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 15;
    }

    private int yyr31() { // unary : '-' expression
        { yyrv = new UnaryMinus(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 15;
    }

    private int yyr32() { // unary : '!' expression
        { yyrv = new UnaryNot(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 15;
    }

    protected String[] yyerrmsgs = {
    };

private Lexer lexer; 

private Node result;

public Node getResult() {
  return result;
}

public Parser(Lexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

private static Statement chainStatements(Statement... statements) {
                Statements block = null;
                for (Statement s : statements) {
                        if (s instanceof Statements) {
                                block = (Statements) s;
                                break;
                        }
                }
                if (block == null) {
                        block = new Statements(statements[0], statements);
                } else {
                        for (Statement s : statements) {
                                if (s != block) {
                                        block.addChild(s);
                                }
                        }
                }
                return block;
        }

}
