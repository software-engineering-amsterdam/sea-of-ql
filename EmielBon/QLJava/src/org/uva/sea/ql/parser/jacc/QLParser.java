// Output created by jacc on Tue Mar 19 01:13:50 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.operators.logical.*;
import org.uva.sea.ql.ast.operators.numeric.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.*;

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
                case 81:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 162;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    switch (yytok) {
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    switch (yytok) {
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys6();
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys7();
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    switch (yytok) {
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys10();
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
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
                case 94:
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
                case 95:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 36;
                            continue;
                    }
                    yyn = 165;
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
                case 96:
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
                case 97:
                    switch (yytok) {
                        case '(':
                            yyn = 38;
                            continue;
                    }
                    yyn = 165;
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
                case 98:
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
                case 99:
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
                case 100:
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
                case 101:
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
                case 102:
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
                case 103:
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
                case 104:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 108:
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
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
                case 113:
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
                case 114:
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
                case 115:
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
                case 116:
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
                case 117:
                    switch (yytok) {
                        case '{':
                            yyn = 56;
                            continue;
                    }
                    yyn = 165;
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
                case 118:
                    switch (yytok) {
                        case STRINGLITERAL:
                            yyn = 57;
                            continue;
                    }
                    yyn = 165;
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
                case 119:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
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
                case 121:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    yyn = yys55();
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
                case 137:
                    switch (yytok) {
                        case IF:
                            yyn = 16;
                            continue;
                        case IDENTIFIER:
                            yyn = 62;
                            continue;
                    }
                    yyn = 165;
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
                case 138:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 64;
                            continue;
                        case INTEGER:
                            yyn = 65;
                            continue;
                        case MONEY:
                            yyn = 66;
                            continue;
                        case STRING:
                            yyn = 67;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
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
                case 140:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    switch (yytok) {
                        case IF:
                            yyn = 16;
                            continue;
                        case IDENTIFIER:
                            yyn = 62;
                            continue;
                        case '}':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    switch (yytok) {
                        case '}':
                            yyn = 70;
                            continue;
                    }
                    yyn = 165;
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
                case 143:
                    switch (yytok) {
                        case ':':
                            yyn = 37;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    switch (yytok) {
                        case '(':
                            yyn = 71;
                            continue;
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 165;
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
                case 145:
                    switch (yytok) {
                        case '(':
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 165;
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
                case 146:
                    switch (yytok) {
                        case '(':
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 165;
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
                case 147:
                    switch (yytok) {
                        case '(':
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr17();
                            continue;
                    }
                    yyn = 165;
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
                case 148:
                    switch (yytok) {
                        case '(':
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 165;
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
                case 149:
                    switch (yytok) {
                        case '{':
                            yyn = 72;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 69:
                    yyst[yysp] = 69;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 150:
                    switch (yytok) {
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 165;
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
                case 151:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 165;
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
                case 152:
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
                case 153:
                    switch (yytok) {
                        case IF:
                            yyn = 16;
                            continue;
                        case IDENTIFIER:
                            yyn = 62;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 73:
                    yyst[yysp] = 73;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
                    yyn = yys73();
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    switch (yytok) {
                        case '}':
                            yyn = 76;
                            continue;
                    }
                    yyn = 165;
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
                case 156:
                    switch (yytok) {
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 165;
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
                case 157:
                    switch (yytok) {
                        case ELSE:
                            yyn = 77;
                            continue;
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 165;
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
                case 158:
                    switch (yytok) {
                        case '{':
                            yyn = 78;
                            continue;
                    }
                    yyn = 165;
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
                case 159:
                    switch (yytok) {
                        case IF:
                            yyn = 16;
                            continue;
                        case IDENTIFIER:
                            yyn = 62;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 79:
                    yyst[yysp] = 79;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 160:
                    switch (yytok) {
                        case '}':
                            yyn = 80;
                            continue;
                    }
                    yyn = 165;
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
                case 161:
                    switch (yytok) {
                        case ENDINPUT:
                        case IF:
                        case '}':
                        case IDENTIFIER:
                            yyn = yyr19();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 162:
                    return true;
                case 163:
                    yyerror("stack overflow");
                case 164:
                    return false;
                case 165:
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
            case BOOLEANLITERAL:
                return 13;
            case FORM:
                return 14;
            case IDENTIFIER:
                return 15;
            case IF:
                return 16;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
        }
        return 165;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 24;
            case EQ:
                return 25;
            case GEQ:
                return 26;
            case LEQ:
                return 27;
            case NEQ:
                return 28;
            case OR:
                return 29;
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case '<':
                return 34;
            case '>':
                return 35;
            case ENDINPUT:
                return yyr4();
        }
        return 165;
    }

    private int yys6() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr23();
        }
        return 165;
    }

    private int yys7() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr21();
        }
        return 165;
    }

    private int yys10() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr22();
        }
        return 165;
    }

    private int yys12() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr20();
        }
        return 165;
    }

    private int yys13() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr43();
        }
        return 165;
    }

    private int yys15() {
        switch (yytok) {
            case ':':
                return 37;
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '/':
            case '*':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr44();
        }
        return 165;
    }

    private int yys17() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr40();
        }
        return 165;
    }

    private int yys18() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr41();
        }
        return 165;
    }

    private int yys19() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr42();
        }
        return 165;
    }

    private int yys20() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys21() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys22() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys23() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys24() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys25() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys26() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys27() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys28() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys29() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys30() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys31() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys32() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys33() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys34() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys35() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys38() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys39() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr31();
        }
        return 165;
    }

    private int yys40() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr44();
        }
        return 165;
    }

    private int yys41() {
        switch (yytok) {
            case AND:
                return 24;
            case EQ:
                return 25;
            case GEQ:
                return 26;
            case LEQ:
                return 27;
            case NEQ:
                return 28;
            case OR:
                return 29;
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case '<':
                return 34;
            case '>':
                return 35;
            case ')':
                return 59;
        }
        return 165;
    }

    private int yys42() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr25();
        }
        return 165;
    }

    private int yys43() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr26();
        }
        return 165;
    }

    private int yys44() {
        switch (yytok) {
            case EQ:
                return 25;
            case GEQ:
                return 26;
            case LEQ:
                return 27;
            case NEQ:
                return 28;
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case '<':
                return 34;
            case '>':
                return 35;
            case ')':
            case ENDINPUT:
            case OR:
            case AND:
                return yyr32();
        }
        return 165;
    }

    private int yys45() {
        switch (yytok) {
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr34();
        }
        return 165;
    }

    private int yys46() {
        switch (yytok) {
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr38();
        }
        return 165;
    }

    private int yys47() {
        switch (yytok) {
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr39();
        }
        return 165;
    }

    private int yys48() {
        switch (yytok) {
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr35();
        }
        return 165;
    }

    private int yys49() {
        switch (yytok) {
            case AND:
                return 24;
            case EQ:
                return 25;
            case GEQ:
                return 26;
            case LEQ:
                return 27;
            case NEQ:
                return 28;
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case '<':
                return 34;
            case '>':
                return 35;
            case ')':
            case ENDINPUT:
            case OR:
                return yyr33();
        }
        return 165;
    }

    private int yys50() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr27();
        }
        return 165;
    }

    private int yys51() {
        switch (yytok) {
            case '*':
                return 30;
            case '/':
                return 33;
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr29();
        }
        return 165;
    }

    private int yys52() {
        switch (yytok) {
            case '*':
                return 30;
            case '/':
                return 33;
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr30();
        }
        return 165;
    }

    private int yys53() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr28();
        }
        return 165;
    }

    private int yys54() {
        switch (yytok) {
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr37();
        }
        return 165;
    }

    private int yys55() {
        switch (yytok) {
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr36();
        }
        return 165;
    }

    private int yys58() {
        switch (yytok) {
            case AND:
                return 24;
            case EQ:
                return 25;
            case GEQ:
                return 26;
            case LEQ:
                return 27;
            case NEQ:
                return 28;
            case OR:
                return 29;
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case '<':
                return 34;
            case '>':
                return 35;
            case ')':
                return 68;
        }
        return 165;
    }

    private int yys59() {
        switch (yytok) {
            case NEQ:
            case '-':
            case GEQ:
            case '+':
            case '*':
            case '/':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case '<':
            case OR:
            case AND:
                return yyr24();
        }
        return 165;
    }

    private int yys71() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 13;
            case INTEGERLITERAL:
                return 17;
            case MONEYLITERAL:
                return 18;
            case STRINGLITERAL:
                return 19;
            case '!':
                return 20;
            case '(':
                return 21;
            case '+':
                return 22;
            case '-':
                return 23;
            case IDENTIFIER:
                return 40;
        }
        return 165;
    }

    private int yys73() {
        switch (yytok) {
            case AND:
                return 24;
            case EQ:
                return 25;
            case GEQ:
                return 26;
            case LEQ:
                return 27;
            case NEQ:
                return 28;
            case OR:
                return 29;
            case '*':
                return 30;
            case '+':
                return 31;
            case '-':
                return 32;
            case '/':
                return 33;
            case '<':
                return 34;
            case '>':
                return 35;
            case ')':
                return 75;
        }
        return 165;
    }

    private int yyr1() { // top : node
        { result = ((ASTNode)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr20() { // expression : arithmetic
        yysp -= 1;
        return yypexpression();
    }

    private int yyr21() { // expression : logical
        yysp -= 1;
        return yypexpression();
    }

    private int yyr22() { // expression : relational
        yysp -= 1;
        return yypexpression();
    }

    private int yyr23() { // expression : literal
        yysp -= 1;
        return yypexpression();
    }

    private int yyr24() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 38: return 58;
            case 35: return 55;
            case 34: return 54;
            case 33: return 53;
            case 32: return 52;
            case 31: return 51;
            case 30: return 50;
            case 29: return 49;
            case 28: return 48;
            case 27: return 47;
            case 26: return 46;
            case 25: return 45;
            case 24: return 44;
            case 23: return 43;
            case 22: return 42;
            case 21: return 41;
            case 20: return 39;
            case 0: return 2;
            default: return 73;
        }
    }

    private int yyr5() { // form : FORM IDENTIFIER '{' statements '}'
        { yyrv = new Form(((Identifier)yysv[yysp-4]), ((Block)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 3;
    }

    private int yyr18() { // ifThen : IF '(' expression ')' '{' statements '}'
        { yyrv = new IfThen(((Expression)yysv[yysp-5]), ((Block)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 4;
    }

    private int yyr19() { // ifThenElse : IF '(' expression ')' '{' statements '}' ELSE '{' statements '}'
        { yyrv = new IfThenElse(((Expression)yysv[yysp-9]), ((Block)yysv[yysp-6]), ((Block)yysv[yysp-2])); }
        yysv[yysp-=11] = yyrv;
        return 5;
    }

    private int yyr40() { // literal : INTEGERLITERAL
        { yyrv = ((IntegerLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 6;
    }

    private int yyr41() { // literal : MONEYLITERAL
        { yyrv = ((MoneyLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 6;
    }

    private int yyr42() { // literal : STRINGLITERAL
        { yyrv = ((StringLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 6;
    }

    private int yyr43() { // literal : BOOLEANLITERAL
        { yyrv = ((BooleanLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 6;
    }

    private int yyr44() { // literal : IDENTIFIER
        { yyrv = ((Identifier)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 6;
    }

    private int yyr31() { // logical : '!' expression
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 7;
    }

    private int yyr32() { // logical : expression AND expression
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 7;
    }

    private int yyr33() { // logical : expression OR expression
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 7;
    }

    private int yyr2() { // node : form
        yysp -= 1;
        return 8;
    }

    private int yyr3() { // node : statement
        yysp -= 1;
        return 8;
    }

    private int yyr4() { // node : expression
        yysp -= 1;
        return 8;
    }

    private int yyr12() { // question : IDENTIFIER ':' STRINGLITERAL type '(' expression ')'
        { yyrv = new ComputedQuestion(((Identifier)yysv[yysp-7]), ((StringLiteral)yysv[yysp-5]), ((Type)yysv[yysp-4]), ((Expression)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 9;
    }

    private int yyr13() { // question : IDENTIFIER ':' STRINGLITERAL type
        { yyrv = new Question(((Identifier)yysv[yysp-4]), ((StringLiteral)yysv[yysp-2]), ((Type)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 9;
    }

    private int yyr34() { // relational : expression EQ expression
        { yyrv = new Eq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 10;
    }

    private int yyr35() { // relational : expression NEQ expression
        { yyrv = new NEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 10;
    }

    private int yyr36() { // relational : expression '>' expression
        { yyrv = new GT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 10;
    }

    private int yyr37() { // relational : expression '<' expression
        { yyrv = new LT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 10;
    }

    private int yyr38() { // relational : expression GEQ expression
        { yyrv = new GEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 10;
    }

    private int yyr39() { // relational : expression LEQ expression
        { yyrv = new LEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 10;
    }

    private int yyr9() { // statement : question
        yysp -= 1;
        return yypstatement();
    }

    private int yyr10() { // statement : ifThen
        yysp -= 1;
        return yypstatement();
    }

    private int yyr11() { // statement : ifThenElse
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 0: return 11;
            default: return 60;
        }
    }

    private int yyr7() { // statements : statement statements
        { yyrv = new Block(((Statement)yysv[yysp-2]), ((Block)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypstatements();
    }

    private int yyr8() { // statements : statement
        { yyrv = new Block(((Statement)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 72: return 74;
            case 60: return 69;
            case 56: return 61;
            default: return 79;
        }
    }

    private int yyr25() { // arithmetic : '+' expression
        { yyrv = new Pos(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 12;
    }

    private int yyr26() { // arithmetic : '-' expression
        { yyrv = new Neg(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 12;
    }

    private int yyr27() { // arithmetic : expression '*' expression
        { yyrv = new Mul(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr28() { // arithmetic : expression '/' expression
        { yyrv = new Div(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr29() { // arithmetic : expression '+' expression
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr30() { // arithmetic : expression '-' expression
        { yyrv = new Sub(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 12;
    }

    private int yyr14() { // type : INTEGER
        { yyrv = new Int(); }
        yysv[yysp-=1] = yyrv;
        return 63;
    }

    private int yyr15() { // type : BOOLEAN
        { yyrv = new Bool(); }
        yysv[yysp-=1] = yyrv;
        return 63;
    }

    private int yyr16() { // type : STRING
        { yyrv = new Str(); }
        yysv[yysp-=1] = yyrv;
        return 63;
    }

    private int yyr17() { // type : MONEY
        { yyrv = new Money(); }
        yysv[yysp-=1] = yyrv;
        return 63;
    }

    protected String[] yyerrmsgs = {
    };
 // Additional code section

private QLLexer lexer; 

private ASTNode result;

public ASTNode getResult() {
  return result;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
