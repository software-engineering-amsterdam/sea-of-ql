// Output created by jacc on Mon Feb 04 16:28:05 CET 2013

package khosrow.uva.sea.ql.parser.jacc;

import khosrow.uva.sea.ql.ast.decl.*;
import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.ast.stmt.*;
import khosrow.uva.sea.ql.ast.type.*;

class QLParser implements QLTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private khosrow.uva.sea.ql.ast.ASTNode[] yysv;
    private khosrow.uva.sea.ql.ast.ASTNode yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new khosrow.uva.sea.ql.ast.ASTNode[yyss];
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
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    switch (yytok) {
                        case ENDINPUT:
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr10();
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
                            yyn = yyr2();
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
                case 87:
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
                case 88:
                    switch (yytok) {
                        case IDENT:
                            yyn = 30;
                            continue;
                    }
                    yyn = 165;
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
                case 89:
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
                case 90:
                    switch (yytok) {
                        case '(':
                            yyn = 34;
                            continue;
                    }
                    yyn = 165;
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
                case 91:
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
                case 92:
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
                    switch (yytok) {
                        case '{':
                            yyn = 55;
                            continue;
                    }
                    yyn = 165;
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
                    switch (yytok) {
                        case STRING_LITERAL:
                            yyn = 58;
                            continue;
                    }
                    yyn = 165;
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
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
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
                case 118:
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
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
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
                case 139:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 65;
                            continue;
                        case INTEGER:
                            yyn = 66;
                            continue;
                        case MONEY:
                            yyn = 67;
                            continue;
                        case STRING:
                            yyn = 68;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 59:
                    yyst[yysp] = 59;
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
                case 142:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    switch (yytok) {
                        case IF:
                            yyn = 9;
                            continue;
                        case IDENT:
                            yyn = 72;
                            continue;
                        case STRING_LITERAL:
                            yyn = 73;
                            continue;
                        case '}':
                            yyn = 74;
                            continue;
                    }
                    yyn = 165;
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
                case 144:
                    switch (yytok) {
                        case ':':
                            yyn = 75;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    switch (yytok) {
                        case ENDINPUT:
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr11();
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
                        case ENDINPUT:
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr36();
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
                        case ENDINPUT:
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr35();
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
                        case ENDINPUT:
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr38();
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
                        case ENDINPUT:
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr37();
                            continue;
                    }
                    yyn = 165;
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
                case 150:
                    switch (yytok) {
                        case '{':
                            yyn = 76;
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
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 152:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 165;
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
                        case BECOMES:
                            yyn = 31;
                            continue;
                        case '(':
                            yyn = 32;
                            continue;
                        case ':':
                            yyn = 33;
                            continue;
                    }
                    yyn = 165;
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
                case 154:
                    switch (yytok) {
                        case '(':
                            yyn = 35;
                            continue;
                    }
                    yyn = 165;
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
                case 155:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr4();
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
                        case STRING_LITERAL:
                            yyn = 77;
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
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr6();
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
                        case BOOLEAN:
                            yyn = 65;
                            continue;
                        case INTEGER:
                            yyn = 66;
                            continue;
                        case MONEY:
                            yyn = 67;
                            continue;
                        case STRING:
                            yyn = 68;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 78:
                    yyst[yysp] = 78;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 159:
                    switch (yytok) {
                        case IF:
                            yyn = 9;
                            continue;
                        case IDENT:
                            yyn = 72;
                            continue;
                        case STRING_LITERAL:
                            yyn = 73;
                            continue;
                        case '}':
                            yyn = 80;
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
                        case ENDINPUT:
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr12();
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
                        case STRING_LITERAL:
                        case IF:
                        case '}':
                        case IDENT:
                            yyn = yyr8();
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
        khosrow.uva.sea.ql.ast.ASTNode[] newyysv = new khosrow.uva.sea.ql.ast.ASTNode[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys0() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case FORM:
                return 7;
            case IDENT:
                return 8;
            case IF:
                return 9;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case STRING_LITERAL:
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
        return 165;
    }

    private int yys5() {
        switch (yytok) {
            case AND:
                return 17;
            case EQ:
                return 18;
            case GEQ:
                return 19;
            case LEQ:
                return 20;
            case NEQ:
                return 21;
            case OR:
                return 22;
            case '%':
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
                return yyr3();
        }
        return 165;
    }

    private int yys6() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr33();
    }

    private int yys8() {
        switch (yytok) {
            case BECOMES:
                return 31;
            case '(':
                return 32;
            case ':':
                return 33;
            case NEQ:
            case '+':
            case GEQ:
            case '*':
            case '%':
            case '-':
            case '/':
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

    private int yys10() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr29();
    }

    private int yys11() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr32();
    }

    private int yys12() {
        switch (yytok) {
            case '(':
                return 35;
            case NEQ:
            case '+':
            case GEQ:
            case '*':
            case '%':
            case '-':
            case '/':
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

    private int yys13() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys14() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys15() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys16() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys17() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys18() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys19() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys20() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys21() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys22() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys23() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys24() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys25() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys26() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys27() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys28() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys29() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys31() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys32() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys34() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys35() {
        switch (yytok) {
            case BOOL_LITERAL:
                return 6;
            case INT_LITERAL:
                return 10;
            case MONEY_LITERAL:
                return 11;
            case '!':
                return 13;
            case '(':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case IDENT:
                return 37;
            case STRING_LITERAL:
                return 38;
        }
        return 165;
    }

    private int yys36() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr15();
    }

    private int yys37() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr30();
    }

    private int yys38() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr31();
    }

    private int yys39() {
        switch (yytok) {
            case AND:
                return 17;
            case EQ:
                return 18;
            case GEQ:
                return 19;
            case LEQ:
                return 20;
            case NEQ:
                return 21;
            case OR:
                return 22;
            case '%':
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
                return 61;
        }
        return 165;
    }

    private int yys40() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr13();
    }

    private int yys41() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr14();
    }

    private int yys42() {
        switch (yytok) {
            case EQ:
                return 18;
            case GEQ:
                return 19;
            case LEQ:
                return 20;
            case NEQ:
                return 21;
            case '%':
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
            case STRING_LITERAL:
            case IF:
            case '}':
            case OR:
            case IDENT:
            case ENDINPUT:
            case AND:
                return yyr27();
        }
        return 165;
    }

    private int yys43() {
        switch (yytok) {
            case '%':
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case STRING_LITERAL:
            case IF:
            case '}':
            case '>':
            case '<':
            case OR:
            case IDENT:
            case ENDINPUT:
            case AND:
                return yyr21();
        }
        return 165;
    }

    private int yys44() {
        switch (yytok) {
            case '%':
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case STRING_LITERAL:
            case IF:
            case '}':
            case '>':
            case '<':
            case OR:
            case IDENT:
            case ENDINPUT:
            case AND:
                return yyr25();
        }
        return 165;
    }

    private int yys45() {
        switch (yytok) {
            case '%':
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case STRING_LITERAL:
            case IF:
            case '}':
            case '>':
            case '<':
            case OR:
            case IDENT:
            case ENDINPUT:
            case AND:
                return yyr26();
        }
        return 165;
    }

    private int yys46() {
        switch (yytok) {
            case '%':
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case STRING_LITERAL:
            case IF:
            case '}':
            case '>':
            case '<':
            case OR:
            case IDENT:
            case ENDINPUT:
            case AND:
                return yyr22();
        }
        return 165;
    }

    private int yys47() {
        switch (yytok) {
            case AND:
                return 17;
            case EQ:
                return 18;
            case GEQ:
                return 19;
            case LEQ:
                return 20;
            case NEQ:
                return 21;
            case '%':
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
            case STRING_LITERAL:
            case IF:
            case '}':
            case OR:
            case ENDINPUT:
            case IDENT:
                return yyr28();
        }
        return 165;
    }

    private int yys48() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr18();
    }

    private int yys49() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr16();
    }

    private int yys50() {
        switch (yytok) {
            case '%':
                return 23;
            case '*':
                return 24;
            case '/':
                return 27;
            case NEQ:
            case '+':
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case STRING_LITERAL:
            case '-':
            case IF:
            case '}':
            case '>':
            case '<':
            case OR:
            case IDENT:
            case ENDINPUT:
            case AND:
                return yyr19();
        }
        return 165;
    }

    private int yys51() {
        switch (yytok) {
            case '%':
                return 23;
            case '*':
                return 24;
            case '/':
                return 27;
            case NEQ:
            case '+':
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case STRING_LITERAL:
            case '-':
            case IF:
            case '}':
            case '>':
            case '<':
            case OR:
            case IDENT:
            case ENDINPUT:
            case AND:
                return yyr20();
        }
        return 165;
    }

    private int yys52() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr17();
    }

    private int yys53() {
        switch (yytok) {
            case '%':
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case STRING_LITERAL:
            case IF:
            case '}':
            case '>':
            case '<':
            case OR:
            case IDENT:
            case ENDINPUT:
            case AND:
                return yyr24();
        }
        return 165;
    }

    private int yys54() {
        switch (yytok) {
            case '%':
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case NEQ:
            case GEQ:
            case ')':
            case LEQ:
            case EQ:
            case STRING_LITERAL:
            case IF:
            case '}':
            case '>':
            case '<':
            case OR:
            case IDENT:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 165;
    }

    private int yys56() {
        switch (yytok) {
            case AND:
                return 17;
            case EQ:
                return 18;
            case GEQ:
                return 19;
            case LEQ:
                return 20;
            case NEQ:
                return 21;
            case OR:
                return 22;
            case '%':
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
            case STRING_LITERAL:
            case IF:
            case '}':
            case IDENT:
                return yyr7();
        }
        return 165;
    }

    private int yys57() {
        switch (yytok) {
            case AND:
                return 17;
            case EQ:
                return 18;
            case GEQ:
                return 19;
            case LEQ:
                return 20;
            case NEQ:
                return 21;
            case OR:
                return 22;
            case '%':
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
                return 63;
        }
        return 165;
    }

    private int yys59() {
        switch (yytok) {
            case AND:
                return 17;
            case EQ:
                return 18;
            case GEQ:
                return 19;
            case LEQ:
                return 20;
            case NEQ:
                return 21;
            case OR:
                return 22;
            case '%':
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
                return 69;
        }
        return 165;
    }

    private int yys60() {
        switch (yytok) {
            case AND:
                return 17;
            case EQ:
                return 18;
            case GEQ:
                return 19;
            case LEQ:
                return 20;
            case NEQ:
                return 21;
            case OR:
                return 22;
            case '%':
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
                return 70;
        }
        return 165;
    }

    private int yys61() {
        switch (yytok) {
            case '(':
            case UMIN:
            case MONEY_LITERAL:
            case MONEY:
            case '!':
            case UNOT:
            case BECOMES:
            case ':':
            case INTEGER:
            case INT_LITERAL:
            case BOOLEAN:
            case FORM:
            case error:
            case UPLUS:
            case STRING:
            case '{':
            case BOOL_LITERAL:
                return 165;
        }
        return yyr34();
    }

    private int yyr1() { // top : form
        { formResult = ((Form)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr2() { // top : stmt
        { stmtResult = ((Stmt)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr3() { // top : expr
        { exprResult = ((Expr)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr4() { // form : FORM IDENT '{' stmts '}'
        { yyrv = new Form(((Ident)yysv[yysp-4]), ((Stmts)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 2;
    }

    private int yyr11() { // question : IDENT ':' STRING_LITERAL type
        { yyrv = new SimpleQuestion(((Ident)yysv[yysp-4]), ((StringLiteral)yysv[yysp-2]), ((Type)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 3;
    }

    private int yyr12() { // question : IDENT '(' expr ')' ':' STRING_LITERAL type
        { yyrv = new ExpressionQuestion(((Ident)yysv[yysp-7]), ((Expr)yysv[yysp-5]), ((StringLiteral)yysv[yysp-2]), ((Type)yysv[yysp-1])); }
        yysv[yysp-=7] = yyrv;
        return 3;
    }

    private int yyr7() { // stmt : IDENT BECOMES expr
        { yyrv = new Assign(((Ident)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypstmt();
    }

    private int yyr8() { // stmt : IF '(' expr ')' '{' stmts '}'
        { yyrv = new If(((Expr)yysv[yysp-5]), ((Stmts)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return yypstmt();
    }

    private int yyr9() { // stmt : STRING_LITERAL '(' expr ')'
        { yyrv = new Label(((StringLiteral)yysv[yysp-4]), ((Expr)yysv[yysp-2])); }
        yysv[yysp-=4] = yyrv;
        return yypstmt();
    }

    private int yyr10() { // stmt : question
        { yyrv = ((Question)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypstmt();
    }

    private int yypstmt() {
        switch (yyst[yysp-1]) {
            case 0: return 4;
            default: return 71;
        }
    }

    private int yyr5() { // stmts : stmts stmt
        { yyrv = new Stmts(((Stmts)yysv[yysp-2]), ((Stmt)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypstmts();
    }

    private int yyr6() { // stmts : /* empty */
        { yyrv = new Stmts(); }
        yysv[yysp-=0] = yyrv;
        return yypstmts();
    }

    private int yypstmts() {
        switch (yyst[yysp-1]) {
            case 55: return 62;
            default: return 78;
        }
    }

    private int yyr13() { // expr : '+' expr
        { yyrv = new Pos(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : '-' expr
        { yyrv = new Neg(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : '!' expr
        { yyrv = new Not(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : expr '*' expr
        { yyrv = new Mul(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : expr '/' expr
        { yyrv = new Div(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : expr '%' expr
        { yyrv = new Mod(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
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

    private int yyr29() { // expr : INT_LITERAL
        { yyrv = ((IntLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr30() { // expr : IDENT
        { yyrv = ((Ident)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr31() { // expr : STRING_LITERAL
        { yyrv = ((StringLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr32() { // expr : MONEY_LITERAL
        { yyrv = ((MoneyLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr33() { // expr : BOOL_LITERAL
        { yyrv = ((BoolLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr34() { // expr : '(' expr ')'
        { yyrv = ((Expr)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 34: return 59;
            case 32: return 57;
            case 31: return 56;
            case 29: return 54;
            case 28: return 53;
            case 27: return 52;
            case 26: return 51;
            case 25: return 50;
            case 24: return 49;
            case 23: return 48;
            case 22: return 47;
            case 21: return 46;
            case 20: return 45;
            case 19: return 44;
            case 18: return 43;
            case 17: return 42;
            case 16: return 41;
            case 15: return 40;
            case 14: return 39;
            case 13: return 36;
            case 0: return 5;
            default: return 60;
        }
    }

    private int yyr35() { // type : INTEGER
        { yyrv = new Int(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr36() { // type : BOOLEAN
        { yyrv = new Bool(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr37() { // type : STRING
        { yyrv = new Str(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr38() { // type : MONEY
        { yyrv = new Money(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyptype() {
        switch (yyst[yysp-1]) {
            case 58: return 64;
            default: return 79;
        }
    }

    protected String[] yyerrmsgs = {
    };

private QLLexer lexer; 

private Form formResult;
private Stmt stmtResult;
private Expr exprResult;

public Form getFormResult() {
  return formResult;
}

public Stmt getStatementResult(){
        return stmtResult;
}

public Expr getExpressionResult(){
        return exprResult;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
