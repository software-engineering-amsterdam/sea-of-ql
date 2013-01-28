// Output created by jacc on Mon Jan 28 13:44:21 CET 2013

package khosrow.uva.sea.ql.parser.jacc;

import khosrow.uva.sea.ql.ast.*;
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
                case 73:
                    switch (yytok) {
                        case FORM:
                            yyn = 2;
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 146;
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 2:
                    yyst[yysp] = 2;
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
                            yyn = 3;
                            continue;
                    }
                    yyn = 149;
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
                case 76:
                    switch (yytok) {
                        case '{':
                            yyn = 4;
                            continue;
                    }
                    yyn = 149;
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
                case 77:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case IDENT:
                            yyn = 8;
                            continue;
                        case IF:
                            yyn = 9;
                            continue;
                        case STRING_LITERAL:
                            yyn = 10;
                            continue;
                        case '}':
                            yyn = 11;
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 80:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 149;
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
                case 81:
                    switch (yytok) {
                        case '(':
                            yyn = 12;
                            continue;
                        case ':':
                            yyn = 13;
                            continue;
                    }
                    yyn = 149;
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
                case 82:
                    switch (yytok) {
                        case '(':
                            yyn = 14;
                            continue;
                    }
                    yyn = 149;
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
                case 83:
                    switch (yytok) {
                        case '(':
                            yyn = 15;
                            continue;
                    }
                    yyn = 149;
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
                case 84:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 149;
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
                case 85:
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
                case 86:
                    switch (yytok) {
                        case STRING_LITERAL:
                            yyn = 25;
                            continue;
                    }
                    yyn = 149;
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
                case 87:
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
                case 88:
                    yyn = yys15();
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
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
                case 90:
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
                case 91:
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
                case 92:
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
                case 93:
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
                case 94:
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
                case 95:
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
                case 96:
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
                case 97:
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
                case 98:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 47;
                            continue;
                        case INTEGER:
                            yyn = 48;
                            continue;
                        case MONEY:
                            yyn = 49;
                            continue;
                        case STRING:
                            yyn = 50;
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
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
                case 101:
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
                case 102:
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
                case 103:
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
                case 104:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 108:
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
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
                case 113:
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
                case 114:
                    switch (yytok) {
                        case ':':
                            yyn = 66;
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 149;
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
                case 120:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr34();
                            continue;
                    }
                    yyn = 149;
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
                case 121:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr33();
                            continue;
                    }
                    yyn = 149;
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
                case 122:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr36();
                            continue;
                    }
                    yyn = 149;
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
                case 123:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr35();
                            continue;
                    }
                    yyn = 149;
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
                case 124:
                    switch (yytok) {
                        case '{':
                            yyn = 68;
                            continue;
                    }
                    yyn = 149;
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
                case 125:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    yyn = yys60();
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    yyn = yys62();
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    yyn = yys63();
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    yyn = yys64();
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    yyn = yys65();
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
                case 139:
                    switch (yytok) {
                        case STRING_LITERAL:
                            yyn = 69;
                            continue;
                    }
                    yyn = 149;
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
                case 140:
                    yyn = yys67();
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
                case 141:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 149;
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
                case 142:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 47;
                            continue;
                        case INTEGER:
                            yyn = 48;
                            continue;
                        case MONEY:
                            yyn = 49;
                            continue;
                        case STRING:
                            yyn = 50;
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    switch (yytok) {
                        case IDENT:
                            yyn = 8;
                            continue;
                        case IF:
                            yyn = 9;
                            continue;
                        case STRING_LITERAL:
                            yyn = 10;
                            continue;
                        case '}':
                            yyn = 72;
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 149;
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
                case 145:
                    switch (yytok) {
                        case STRING_LITERAL:
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 149;
                    continue;

                case 146:
                    return true;
                case 147:
                    yyerror("stack overflow");
                case 148:
                    return false;
                case 149:
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

    private int yys12() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys14() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys15() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys16() {
        switch (yytok) {
            case ADD:
                return 28;
            case AND:
                return 29;
            case DIV:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case GT:
                return 33;
            case LEQ:
                return 34;
            case LT:
                return 35;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case NEQ:
                return 38;
            case OR:
                return 39;
            case SUB:
                return 40;
            case ')':
                return 41;
        }
        return 149;
    }

    private int yys17() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr29();
        }
        return 149;
    }

    private int yys18() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr28();
        }
        return 149;
    }

    private int yys19() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr31();
        }
        return 149;
    }

    private int yys20() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr30();
        }
        return 149;
    }

    private int yys21() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys22() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys23() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys24() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys26() {
        switch (yytok) {
            case ADD:
                return 28;
            case AND:
                return 29;
            case DIV:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case GT:
                return 33;
            case LEQ:
                return 34;
            case LT:
                return 35;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case NEQ:
                return 38;
            case OR:
                return 39;
            case SUB:
                return 40;
            case ')':
                return 51;
        }
        return 149;
    }

    private int yys27() {
        switch (yytok) {
            case ADD:
                return 28;
            case AND:
                return 29;
            case DIV:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case GT:
                return 33;
            case LEQ:
                return 34;
            case LT:
                return 35;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case NEQ:
                return 38;
            case OR:
                return 39;
            case SUB:
                return 40;
            case ')':
                return 52;
        }
        return 149;
    }

    private int yys28() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys29() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys30() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys31() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys32() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys33() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys34() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys35() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys36() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys37() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys38() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys39() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys40() {
        switch (yytok) {
            case IDENT:
                return 17;
            case INT:
                return 18;
            case MONEY:
                return 19;
            case STRING_LITERAL:
                return 20;
            case '!':
                return 21;
            case '(':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
        }
        return 149;
    }

    private int yys42() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr14();
        }
        return 149;
    }

    private int yys43() {
        switch (yytok) {
            case ADD:
                return 28;
            case AND:
                return 29;
            case DIV:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case GT:
                return 33;
            case LEQ:
                return 34;
            case LT:
                return 35;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case NEQ:
                return 38;
            case OR:
                return 39;
            case SUB:
                return 40;
            case ')':
                return 67;
        }
        return 149;
    }

    private int yys44() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr12();
        }
        return 149;
    }

    private int yys45() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr13();
        }
        return 149;
    }

    private int yys53() {
        switch (yytok) {
            case DIV:
                return 30;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case LT:
            case GEQ:
            case LEQ:
            case ')':
            case SUB:
            case EQ:
            case OR:
            case NEQ:
            case GT:
            case AND:
            case ADD:
                return yyr18();
        }
        return 149;
    }

    private int yys54() {
        switch (yytok) {
            case ADD:
                return 28;
            case DIV:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case GT:
                return 33;
            case LEQ:
                return 34;
            case LT:
                return 35;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case NEQ:
                return 38;
            case SUB:
                return 40;
            case ')':
            case OR:
            case AND:
                return yyr26();
        }
        return 149;
    }

    private int yys55() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr16();
        }
        return 149;
    }

    private int yys56() {
        switch (yytok) {
            case ADD:
                return 28;
            case DIV:
                return 30;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case SUB:
                return 40;
            case ')':
            case LT:
            case GEQ:
            case LEQ:
            case EQ:
            case OR:
            case NEQ:
            case GT:
            case AND:
                return yyr20();
        }
        return 149;
    }

    private int yys57() {
        switch (yytok) {
            case ADD:
                return 28;
            case DIV:
                return 30;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case SUB:
                return 40;
            case ')':
            case LT:
            case GEQ:
            case LEQ:
            case EQ:
            case OR:
            case NEQ:
            case GT:
            case AND:
                return yyr24();
        }
        return 149;
    }

    private int yys58() {
        switch (yytok) {
            case ADD:
                return 28;
            case DIV:
                return 30;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case SUB:
                return 40;
            case ')':
            case LT:
            case GEQ:
            case LEQ:
            case EQ:
            case OR:
            case NEQ:
            case GT:
            case AND:
                return yyr22();
        }
        return 149;
    }

    private int yys59() {
        switch (yytok) {
            case ADD:
                return 28;
            case DIV:
                return 30;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case SUB:
                return 40;
            case ')':
            case LT:
            case GEQ:
            case LEQ:
            case EQ:
            case OR:
            case NEQ:
            case GT:
            case AND:
                return yyr25();
        }
        return 149;
    }

    private int yys60() {
        switch (yytok) {
            case ADD:
                return 28;
            case DIV:
                return 30;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case SUB:
                return 40;
            case ')':
            case LT:
            case GEQ:
            case LEQ:
            case EQ:
            case OR:
            case NEQ:
            case GT:
            case AND:
                return yyr23();
        }
        return 149;
    }

    private int yys61() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr17();
        }
        return 149;
    }

    private int yys62() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr15();
        }
        return 149;
    }

    private int yys63() {
        switch (yytok) {
            case ADD:
                return 28;
            case DIV:
                return 30;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case SUB:
                return 40;
            case ')':
            case LT:
            case GEQ:
            case LEQ:
            case EQ:
            case OR:
            case NEQ:
            case GT:
            case AND:
                return yyr21();
        }
        return 149;
    }

    private int yys64() {
        switch (yytok) {
            case ADD:
                return 28;
            case AND:
                return 29;
            case DIV:
                return 30;
            case EQ:
                return 31;
            case GEQ:
                return 32;
            case GT:
                return 33;
            case LEQ:
                return 34;
            case LT:
                return 35;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case NEQ:
                return 38;
            case SUB:
                return 40;
            case ')':
            case OR:
                return yyr27();
        }
        return 149;
    }

    private int yys65() {
        switch (yytok) {
            case DIV:
                return 30;
            case MOD:
                return 36;
            case MUL:
                return 37;
            case LT:
            case GEQ:
            case LEQ:
            case ')':
            case SUB:
            case EQ:
            case OR:
            case NEQ:
            case GT:
            case AND:
            case ADD:
                return yyr19();
        }
        return 149;
    }

    private int yys67() {
        switch (yytok) {
            case MOD:
            case LT:
            case GEQ:
            case LEQ:
            case SUB:
            case EQ:
            case ')':
            case OR:
            case NEQ:
            case MUL:
            case GT:
            case DIV:
            case AND:
            case ADD:
                return yyr32();
        }
        return 149;
    }

    private int yyr4() { // form : FORM IDENT '{' stmts '}'
        { result = new Form(((Ident)yysv[yysp-4]), ((Stmts)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 1;
    }

    private int yyr12() { // expr : '+' expr
        { yyrv = new Pos(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : '-' expr
        { yyrv = new Neg(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : '!' expr
        { yyrv = new Not(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : expr MUL expr
        { yyrv = new Mul(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : expr DIV expr
        { yyrv = new Div(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : expr MOD expr
        { yyrv = new Mod(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : expr ADD expr
        { yyrv = new Add(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : expr SUB expr
        { yyrv = new Sub(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : expr EQ expr
        { yyrv = new Eq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr21() { // expr : expr NEQ expr
        { yyrv = new NEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr22() { // expr : expr GT expr
        { yyrv = new GT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr23() { // expr : expr LT expr
        { yyrv = new LT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr24() { // expr : expr GEQ expr
        { yyrv = new GEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr25() { // expr : expr LEQ expr
        { yyrv = new LEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr26() { // expr : expr AND expr
        { yyrv = new And(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr27() { // expr : expr OR expr
        { yyrv = new Or(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr28() { // expr : INT
        { yyrv = ((IntLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr29() { // expr : IDENT
        { yyrv = ((Ident)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr30() { // expr : STRING_LITERAL
        { yyrv = ((StringLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr31() { // expr : MONEY
        { yyrv = ((MoneyLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr32() { // expr : '(' expr ')'
        { yyrv = yysv[yysp-3]; }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 39: return 64;
            case 38: return 63;
            case 37: return 62;
            case 36: return 61;
            case 35: return 60;
            case 34: return 59;
            case 33: return 58;
            case 32: return 57;
            case 31: return 56;
            case 30: return 55;
            case 29: return 54;
            case 28: return 53;
            case 24: return 45;
            case 23: return 44;
            case 22: return 43;
            case 21: return 42;
            case 15: return 27;
            case 14: return 26;
            case 12: return 16;
            default: return 65;
        }
    }

    private int yyr10() { // question : IDENT ':' STRING_LITERAL type
        { yyrv = new SimpleQuestion(((Ident)yysv[yysp-4]), ((StringLiteral)yysv[yysp-2]), ((Type)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 6;
    }

    private int yyr11() { // question : IDENT '(' expr ')' ':' STRING_LITERAL type
        { yyrv = new ExpressionQuestion(((Ident)yysv[yysp-7]), ((Expr)yysv[yysp-5]), ((StringLiteral)yysv[yysp-2]), ((Type)yysv[yysp-1])); }
        yysv[yysp-=7] = yyrv;
        return 6;
    }

    private int yyr7() { // stmt : IF '(' expr ')' '{' stmts '}'
        { yyrv = new If(((Expr)yysv[yysp-5]), ((Stmts)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 7;
    }

    private int yyr8() { // stmt : STRING_LITERAL '(' expr ')'
        { yyrv = new Label(((StringLiteral)yysv[yysp-4]), ((Expr)yysv[yysp-2])); }
        yysv[yysp-=4] = yyrv;
        return 7;
    }

    private int yyr9() { // stmt : question
        { yyrv = ((Question)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 7;
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
            case 4: return 5;
            default: return 70;
        }
    }

    private int yyr33() { // type : INTEGER
        { yyrv = new Int(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr34() { // type : BOOLEAN
        { yyrv = new Bool(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr35() { // type : STRING
        { yyrv = new Str(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr36() { // type : MONEY
        { yyrv = new Money(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyptype() {
        switch (yyst[yysp-1]) {
            case 25: return 46;
            default: return 71;
        }
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
