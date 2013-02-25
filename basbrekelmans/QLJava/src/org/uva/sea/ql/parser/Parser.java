// Output created by jacc on Mon Feb 25 12:41:08 CET 2013

package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ICodeLocationInformation;

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
                case 84:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 168;
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys3();
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys7();
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys10();
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 41;
                            continue;
                        case ENDINPUT:
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    yyn = yys14();
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
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
                case 100:
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
                case 101:
                    switch (yytok) {
                        case STRINGLITERAL:
                            yyn = 42;
                            continue;
                    }
                    yyn = 171;
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
                case 102:
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
                case 103:
                    switch (yytok) {
                        case '(':
                            yyn = 43;
                            continue;
                    }
                    yyn = 171;
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
                case 104:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 108:
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
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
                case 113:
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
                case 114:
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
                case 115:
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
                case 116:
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
                case 117:
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
                case 118:
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
                case 119:
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
                case 120:
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
                case 121:
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
                case 122:
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
                case 123:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 171;
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
                case 125:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 44;
                            continue;
                    }
                    yyn = 171;
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
                case 126:
                    switch (yytok) {
                        case '{':
                            yyn = 63;
                            continue;
                    }
                    yyn = 171;
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
                case 127:
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
                case 128:
                    switch (yytok) {
                        case ':':
                            yyn = 65;
                            continue;
                        case '=':
                            yyn = 66;
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
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
                case 130:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    yyn = yys60();
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
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
                case 147:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 41;
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 148:
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
                case 149:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 71;
                            continue;
                        case INTEGER:
                            yyn = 72;
                            continue;
                        case MONEY:
                            yyn = 73;
                            continue;
                        case STRING:
                            yyn = 74;
                            continue;
                    }
                    yyn = 171;
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
                case 150:
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
                case 151:
                    yyn = yys67();
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 152:
                    switch (yytok) {
                        case '}':
                            yyn = 76;
                            continue;
                    }
                    yyn = 171;
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
                case 153:
                    switch (yytok) {
                        case '{':
                            yyn = 77;
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 171;
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
                case 156:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr17();
                            continue;
                    }
                    yyn = 171;
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
                case 157:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 171;
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
                case 158:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 159:
                    yyn = yys75();
                    continue;

                case 76:
                    yyst[yysp] = 76;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 160:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 171;
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
                case 161:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 41;
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 78:
                    yyst[yysp] = 78;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 162:
                    switch (yytok) {
                        case '}':
                            yyn = 79;
                            continue;
                    }
                    yyn = 171;
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
                case 163:
                    switch (yytok) {
                        case ELSE:
                            yyn = 80;
                            continue;
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 80:
                    yyst[yysp] = 80;
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
                            yyn = 81;
                            continue;
                    }
                    yyn = 171;
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
                case 165:
                    switch (yytok) {
                        case IF:
                            yyn = 19;
                            continue;
                        case STRINGLITERAL:
                            yyn = 41;
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 82:
                    yyst[yysp] = 82;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 166:
                    switch (yytok) {
                        case '}':
                            yyn = 83;
                            continue;
                    }
                    yyn = 171;
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
                case 167:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case STRINGLITERAL:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 171;
                    continue;

                case 168:
                    return true;
                case 169:
                    yyerror("stack overflow");
                case 170:
                    return false;
                case 171:
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
            case FALSE:
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
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
        }
        return 171;
    }

    private int yys2() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr43();
    }

    private int yys3() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr23();
    }

    private int yys4() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case OR:
                return 32;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case '^':
                return 39;
            case ENDINPUT:
                return yyr2();
        }
        return 171;
    }

    private int yys7() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr20();
    }

    private int yys10() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr22();
    }

    private int yys14() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr21();
    }

    private int yys15() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr19();
    }

    private int yys16() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr46();
    }

    private int yys18() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr44();
    }

    private int yys20() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr41();
    }

    private int yys21() {
        switch (yytok) {
            case IDENTIFIER:
                return 44;
            case OR:
            case '<':
            case GEQ:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '>':
            case LEQ:
            case ENDINPUT:
            case '^':
            case EQ:
            case AND:
                return yyr42();
        }
        return 171;
    }

    private int yys22() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr45();
    }

    private int yys23() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys24() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys25() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys26() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys27() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys28() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys29() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys30() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys31() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys32() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys33() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys34() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys35() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys36() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys37() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys38() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys39() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys43() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys45() {
        switch (yytok) {
            case '*':
                return 33;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr33();
        }
        return 171;
    }

    private int yys46() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr42();
    }

    private int yys47() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case OR:
                return 32;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case '^':
                return 39;
            case ')':
                return 67;
        }
        return 171;
    }

    private int yys48() {
        switch (yytok) {
            case '*':
                return 33;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr31();
        }
        return 171;
    }

    private int yys49() {
        switch (yytok) {
            case '*':
                return 33;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr32();
        }
        return 171;
    }

    private int yys50() {
        switch (yytok) {
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case OR:
            case ')':
            case IF:
            case ENDINPUT:
            case '}':
            case STRINGLITERAL:
            case '^':
            case AND:
                return yyr34();
        }
        return 171;
    }

    private int yys51() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr25();
        }
        return 171;
    }

    private int yys52() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr28();
        }
        return 171;
    }

    private int yys53() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr30();
        }
        return 171;
    }

    private int yys54() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr26();
        }
        return 171;
    }

    private int yys55() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case OR:
            case ')':
            case IF:
            case ENDINPUT:
            case '}':
            case STRINGLITERAL:
            case '^':
                return yyr35();
        }
        return 171;
    }

    private int yys56() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr37();
    }

    private int yys57() {
        switch (yytok) {
            case '*':
                return 33;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr39();
        }
        return 171;
    }

    private int yys58() {
        switch (yytok) {
            case '*':
                return 33;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr40();
        }
        return 171;
    }

    private int yys59() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr38();
    }

    private int yys60() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr29();
        }
        return 171;
    }

    private int yys61() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case OR:
            case '<':
            case GEQ:
            case NEQ:
            case ')':
            case LEQ:
            case IF:
            case '}':
            case '>':
            case STRINGLITERAL:
            case '^':
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr27();
        }
        return 171;
    }

    private int yys62() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case OR:
            case ')':
            case IF:
            case ENDINPUT:
            case '}':
            case STRINGLITERAL:
            case '^':
                return yyr36();
        }
        return 171;
    }

    private int yys64() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case OR:
                return 32;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case '^':
                return 39;
            case ')':
                return 69;
        }
        return 171;
    }

    private int yys66() {
        switch (yytok) {
            case FALSE:
                return 16;
            case IDENTIFIER:
                return 18;
            case NUMBERLITERAL:
                return 20;
            case TRUE:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case STRINGLITERAL:
                return 46;
        }
        return 171;
    }

    private int yys67() {
        switch (yytok) {
            case FORM:
            case error:
            case '=':
            case ':':
            case NUMBERLITERAL:
            case '!':
            case '{':
            case STRING:
            case INTEGER:
            case ';':
            case ELSE:
            case MONEY:
            case FALSE:
            case '(':
            case IDENTIFIER:
            case BOOLEAN:
            case TRUE:
                return 171;
        }
        return yyr24();
    }

    private int yys75() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case OR:
                return 32;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case '^':
                return 39;
            case IF:
            case ENDINPUT:
            case '}':
            case STRINGLITERAL:
                return yyr14();
        }
        return 171;
    }

    private int yyr1() { // top : node
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr45() { // booleanliteral : TRUE
        { yyrv = new BooleanLiteral(lexer.location(), true); }
        yysv[yysp-=1] = yyrv;
        return 2;
    }

    private int yyr46() { // booleanliteral : FALSE
        { yyrv = new BooleanLiteral(lexer.location(), false); }
        yysv[yysp-=1] = yyrv;
        return 2;
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

    private int yyr28() { // comparison : expression GEQ expression
        { yyrv = new GreaterThanOrEquals(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr29() { // comparison : expression '<' expression
        { yyrv = new LessThan(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr30() { // comparison : expression LEQ expression
        { yyrv = new LessThanOrEquals(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 3;
    }

    private int yyr19() { // expression : unary
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr20() { // expression : logical
        { yyrv = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr21() { // expression : arithmetic
        { yyrv = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr22() { // expression : simple
        { yyrv = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr23() { // expression : comparison
        { yyrv = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr24() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 43: return 64;
            case 39: return 62;
            case 38: return 61;
            case 37: return 60;
            case 36: return 59;
            case 35: return 58;
            case 34: return 57;
            case 33: return 56;
            case 32: return 55;
            case 31: return 54;
            case 30: return 53;
            case 29: return 52;
            case 28: return 51;
            case 27: return 50;
            case 26: return 49;
            case 25: return 48;
            case 24: return 47;
            case 23: return 45;
            case 0: return 4;
            default: return 75;
        }
    }

    private int yyr5() { // form : FORM STRINGLITERAL '{' statements '}'
        { yyrv = new Form(lexer.location(), ((StringLiteral)yysv[yysp-4]).getValue(), ((Statements)yysv[yysp-2]));  }
        yysv[yysp-=5] = yyrv;
        return 5;
    }

    private int yyr10() { // ifstatement : IF '(' expression ')' '{' statements '}'
        { yyrv = new If(lexer.location(), ((Expression)yysv[yysp-5]), ((Statements)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 6;
    }

    private int yyr11() { // ifstatement : IF '(' expression ')' '{' statements '}' ELSE '{' statements '}'
        { yyrv = new IfElse(lexer.location(), ((Expression)yysv[yysp-9]), ((Statements)yysv[yysp-6]), ((Statements)yysv[yysp-2])); }
        yysv[yysp-=11] = yyrv;
        return 6;
    }

    private int yyr34() { // logical : expression AND expression
        { yyrv = new And(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 7;
    }

    private int yyr35() { // logical : expression OR expression
        { yyrv = new Or(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 7;
    }

    private int yyr36() { // logical : expression '^' expression
        { yyrv = new Xor(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 7;
    }

    private int yyr2() { // node : expression
        { yyrv = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 8;
    }

    private int yyr3() { // node : form
        { yyrv = ((Form)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 8;
    }

    private int yyr4() { // node : statements
        { yyrv = ((Statements)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 8;
    }

    private int yyr13() { // question : STRINGLITERAL IDENTIFIER ':' type
        { yyrv = new InputQuestion(lexer.location(), ((StringLiteral)yysv[yysp-4]), ((Identifier)yysv[yysp-3]), ((TypeNode)yysv[yysp-1]).getType()); }
        yysv[yysp-=4] = yyrv;
        return 9;
    }

    private int yyr14() { // question : STRINGLITERAL IDENTIFIER '=' expression
        { yyrv = new ComputedQuestion(lexer.location(), ((StringLiteral)yysv[yysp-4]), ((Identifier)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 9;
    }

    private int yyr41() { // simple : NUMBERLITERAL
        yysp -= 1;
        return 10;
    }

    private int yyr42() { // simple : STRINGLITERAL
        yysp -= 1;
        return 10;
    }

    private int yyr43() { // simple : booleanliteral
        yysp -= 1;
        return 10;
    }

    private int yyr44() { // simple : IDENTIFIER
        yysp -= 1;
        return 10;
    }

    private int yyr12() { // simplestatement : question
        yysp -= 1;
        return 11;
    }

    private int yyr8() { // statement : simplestatement
        yysp -= 1;
        return 12;
    }

    private int yyr9() { // statement : ifstatement
        yysp -= 1;
        return 12;
    }

    private int yyr6() { // statements : statement statements
        { yyrv = new Statements(lexer.location(), ((Statement)yysv[yysp-2]), ((Statements)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypstatements();
    }

    private int yyr7() { // statements : statement
        { yyrv = new Statements(lexer.location(), ((Statement)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 77: return 78;
            case 63: return 68;
            case 12: return 40;
            case 0: return 13;
            default: return 82;
        }
    }

    private int yyr37() { // arithmetic : expression '*' expression
        { yyrv = new Multiplication(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 14;
    }

    private int yyr38() { // arithmetic : expression '/' expression
        { yyrv = new Division(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 14;
    }

    private int yyr39() { // arithmetic : expression '+' expression
        { yyrv = new Addition(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 14;
    }

    private int yyr40() { // arithmetic : expression '-' expression
        { yyrv = new Subtraction(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]));}
        yysv[yysp-=3] = yyrv;
        return 14;
    }

    private int yyr15() { // type : BOOLEAN
        { yyrv = new TypeNode(lexer.location(), Type.BOOLEAN); }
        yysv[yysp-=1] = yyrv;
        return 70;
    }

    private int yyr16() { // type : STRING
        { yyrv = new TypeNode(lexer.location(), Type.STRING); }
        yysv[yysp-=1] = yyrv;
        return 70;
    }

    private int yyr17() { // type : INTEGER
        { yyrv = new TypeNode(lexer.location(), Type.INTEGER); }
        yysv[yysp-=1] = yyrv;
        return 70;
    }

    private int yyr18() { // type : MONEY
        { yyrv = new TypeNode(lexer.location(), Type.MONEY); }
        yysv[yysp-=1] = yyrv;
        return 70;
    }

    private int yyr31() { // unary : '+' expression
        { yyrv = new UnaryPlus(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 15;
    }

    private int yyr32() { // unary : '-' expression
        { yyrv = new UnaryMinus(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 15;
    }

    private int yyr33() { // unary : '!' expression
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
  ICodeLocationInformation info = lexer.location(); 
  System.err.println(String.format("'%s' near line %d, column %d in '%s'", msg, info.getLineNumber(), info.getColumn(), info.getFileName()));
}

}
