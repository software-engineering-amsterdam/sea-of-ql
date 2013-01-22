// Output created by jacc on Tue Jan 22 09:58:50 CET 2013

package org.uva.sea.ql.parser.jacc;
 
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.binary.bool.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.expression.unary.bool.*;
import org.uva.sea.ql.ast.expression.literals.*;

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
                case 70:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 140;
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 75:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 143;
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
                case 77:
                    yyn = yys7();
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
                case 78:
                    switch (yytok) {
                        case IDENT:
                            yyn = 28;
                            continue;
                    }
                    yyn = 143;
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
                case 79:
                    yyn = yys9();
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
                case 80:
                    switch (yytok) {
                        case '(':
                            yyn = 30;
                            continue;
                    }
                    yyn = 143;
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
                case 81:
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
                case 82:
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
                case 83:
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
                case 84:
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
                case 85:
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
                case 86:
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
                case 87:
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
                case 88:
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
                case 89:
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
                case 90:
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
                case 91:
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
                case 92:
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
                case 93:
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
                case 94:
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
                case 95:
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
                case 96:
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
                case 97:
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
                case 98:
                    switch (yytok) {
                        case '{':
                            yyn = 48;
                            continue;
                    }
                    yyn = 143;
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
                case 99:
                    switch (yytok) {
                        case TEXT:
                            yyn = 49;
                            continue;
                    }
                    yyn = 143;
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
                case 100:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
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
                case 102:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
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
                case 118:
                    switch (yytok) {
                        case IF:
                            yyn = 10;
                            continue;
                        case IDENT:
                            yyn = 54;
                            continue;
                    }
                    yyn = 143;
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
                case 119:
                    switch (yytok) {
                        case DT_BOOLEAN:
                            yyn = 56;
                            continue;
                        case DT_INTEGER:
                            yyn = 57;
                            continue;
                        case DT_MONEY:
                            yyn = 58;
                            continue;
                        case DT_TEXT:
                            yyn = 59;
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
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
                case 121:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    switch (yytok) {
                        case IF:
                            yyn = 10;
                            continue;
                        case IDENT:
                            yyn = 54;
                            continue;
                        case '}':
                            yyn = 62;
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    switch (yytok) {
                        case ':':
                            yyn = 29;
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr30();
                            continue;
                    }
                    yyn = 143;
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
                case 126:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr31();
                            continue;
                    }
                    yyn = 143;
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
                case 127:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr32();
                            continue;
                    }
                    yyn = 143;
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
                case 128:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr33();
                            continue;
                    }
                    yyn = 143;
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
                case 129:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr34();
                            continue;
                    }
                    yyn = 143;
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
                case 130:
                    switch (yytok) {
                        case '{':
                            yyn = 63;
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case '}':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 143;
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
                case 132:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 143;
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
                case 133:
                    switch (yytok) {
                        case IF:
                            yyn = 10;
                            continue;
                        case IDENT:
                            yyn = 54;
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    switch (yytok) {
                        case IF:
                            yyn = 10;
                            continue;
                        case IDENT:
                            yyn = 54;
                            continue;
                        case '}':
                            yyn = 65;
                            continue;
                    }
                    yyn = 143;
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
                case 135:
                    switch (yytok) {
                        case ELSE:
                            yyn = 66;
                            continue;
                        case IF:
                        case IDENT:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 143;
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
                case 136:
                    switch (yytok) {
                        case '{':
                            yyn = 67;
                            continue;
                    }
                    yyn = 143;
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
                case 137:
                    switch (yytok) {
                        case IF:
                            yyn = 10;
                            continue;
                        case IDENT:
                            yyn = 54;
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    switch (yytok) {
                        case IF:
                            yyn = 10;
                            continue;
                        case IDENT:
                            yyn = 54;
                            continue;
                        case '}':
                            yyn = 69;
                            continue;
                    }
                    yyn = 143;
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
                case 139:
                    switch (yytok) {
                        case IF:
                        case IDENT:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 143;
                    continue;

                case 140:
                    return true;
                case 141:
                    yyerror("stack overflow");
                case 142:
                    return false;
                case 143:
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
                return 7;
            case FORM:
                return 8;
            case IDENT:
                return 9;
            case IF:
                return 10;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
        }
        return 143;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 16;
            case EQ:
                return 17;
            case GEQ:
                return 18;
            case LEQ:
                return 19;
            case NEQ:
                return 20;
            case OR:
                return 21;
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case '<':
                return 26;
            case '>':
                return 27;
            case ENDINPUT:
                return yyr2();
        }
        return 143;
    }

    private int yys7() {
        switch (yytok) {
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case ')':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr27();
        }
        return 143;
    }

    private int yys9() {
        switch (yytok) {
            case ':':
                return 29;
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr28();
        }
        return 143;
    }

    private int yys11() {
        switch (yytok) {
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case ')':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr26();
        }
        return 143;
    }

    private int yys12() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys13() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys14() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys15() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys16() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys17() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys18() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys19() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys20() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys21() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys22() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys23() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys24() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys25() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys26() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys27() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys30() {
        switch (yytok) {
            case BOOL:
                return 7;
            case INT:
                return 11;
            case '!':
                return 12;
            case '(':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case IDENT:
                return 32;
        }
        return 143;
    }

    private int yys31() {
        switch (yytok) {
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case ')':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr13();
        }
        return 143;
    }

    private int yys32() {
        switch (yytok) {
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case ')':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr28();
        }
        return 143;
    }

    private int yys33() {
        switch (yytok) {
            case AND:
                return 16;
            case EQ:
                return 17;
            case GEQ:
                return 18;
            case LEQ:
                return 19;
            case NEQ:
                return 20;
            case OR:
                return 21;
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case '<':
                return 26;
            case '>':
                return 27;
            case ')':
                return 51;
        }
        return 143;
    }

    private int yys34() {
        switch (yytok) {
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case ')':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr11();
        }
        return 143;
    }

    private int yys35() {
        switch (yytok) {
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case ')':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr12();
        }
        return 143;
    }

    private int yys36() {
        switch (yytok) {
            case EQ:
                return 17;
            case GEQ:
                return 18;
            case LEQ:
                return 19;
            case NEQ:
                return 20;
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case '<':
                return 26;
            case '>':
                return 27;
            case ')':
            case ENDINPUT:
            case OR:
            case AND:
                return yyr24();
        }
        return 143;
    }

    private int yys37() {
        switch (yytok) {
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case NEQ:
            case LEQ:
            case ')':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr18();
        }
        return 143;
    }

    private int yys38() {
        switch (yytok) {
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case NEQ:
            case LEQ:
            case ')':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr22();
        }
        return 143;
    }

    private int yys39() {
        switch (yytok) {
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case NEQ:
            case LEQ:
            case ')':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr23();
        }
        return 143;
    }

    private int yys40() {
        switch (yytok) {
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case NEQ:
            case LEQ:
            case ')':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr19();
        }
        return 143;
    }

    private int yys41() {
        switch (yytok) {
            case AND:
                return 16;
            case EQ:
                return 17;
            case GEQ:
                return 18;
            case LEQ:
                return 19;
            case NEQ:
                return 20;
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case '<':
                return 26;
            case '>':
                return 27;
            case ')':
            case ENDINPUT:
            case OR:
                return yyr25();
        }
        return 143;
    }

    private int yys42() {
        switch (yytok) {
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case ')':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr14();
        }
        return 143;
    }

    private int yys43() {
        switch (yytok) {
            case '*':
                return 22;
            case '/':
                return 25;
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case ')':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr16();
        }
        return 143;
    }

    private int yys44() {
        switch (yytok) {
            case '*':
                return 22;
            case '/':
                return 25;
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case ')':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr17();
        }
        return 143;
    }

    private int yys45() {
        switch (yytok) {
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case ')':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr15();
        }
        return 143;
    }

    private int yys46() {
        switch (yytok) {
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case NEQ:
            case LEQ:
            case ')':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr21();
        }
        return 143;
    }

    private int yys47() {
        switch (yytok) {
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case NEQ:
            case LEQ:
            case ')':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr20();
        }
        return 143;
    }

    private int yys50() {
        switch (yytok) {
            case AND:
                return 16;
            case EQ:
                return 17;
            case GEQ:
                return 18;
            case LEQ:
                return 19;
            case NEQ:
                return 20;
            case OR:
                return 21;
            case '*':
                return 22;
            case '+':
                return 23;
            case '-':
                return 24;
            case '/':
                return 25;
            case '<':
                return 26;
            case '>':
                return 27;
            case ')':
                return 60;
        }
        return 143;
    }

    private int yys51() {
        switch (yytok) {
            case NEQ:
            case '-':
            case LEQ:
            case '+':
            case '*':
            case ')':
            case '/':
            case GEQ:
            case '<':
            case ENDINPUT:
            case '>':
            case OR:
            case EQ:
            case AND:
                return yyr29();
        }
        return 143;
    }

    private int yyr1() { // top : frm
        { formResult = ((Form)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr2() { // top : expr
        { exprResult = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr3() { // top : stmnt
        { stmntResult = ((Statement)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr31() { // data_type : DT_BOOLEAN
        { yyrv = DataType.BOOLEAN; }
        yysv[yysp-=1] = yyrv;
        return 55;
    }

    private int yyr32() { // data_type : DT_INTEGER
        { yyrv = DataType.INTEGER; }
        yysv[yysp-=1] = yyrv;
        return 55;
    }

    private int yyr33() { // data_type : DT_MONEY
        { yyrv = DataType.MONEY; }
        yysv[yysp-=1] = yyrv;
        return 55;
    }

    private int yyr34() { // data_type : DT_TEXT
        { yyrv = DataType.TEXT; }
        yysv[yysp-=1] = yyrv;
        return 55;
    }

    private int yyr11() { // expr : '+' expr
        { yyrv = new Pos(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr12() { // expr : '-' expr
        { yyrv = new Neg(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : '!' expr
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : expr '*' expr
        { yyrv = new Mul(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : expr '/' expr
        { yyrv = new Div(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : expr '+' expr
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : expr '-' expr
        { yyrv = new Sub(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : expr EQ expr
        { yyrv = new Eq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : expr NEQ expr
        { yyrv = new NEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : expr '>' expr
        { yyrv = new GT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr21() { // expr : expr '<' expr
        { yyrv = new LT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr22() { // expr : expr GEQ expr
        { yyrv = new GEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr23() { // expr : expr LEQ expr
        { yyrv = new LEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr24() { // expr : expr AND expr
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr25() { // expr : expr OR expr
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr26() { // expr : INT
        { yyrv = ((IntLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr27() { // expr : BOOL
        { yyrv = ((BooleanLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr28() { // expr : IDENT
        { yyrv = ((Ident)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr29() { // expr : '(' expr ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 27: return 47;
            case 26: return 46;
            case 25: return 45;
            case 24: return 44;
            case 23: return 43;
            case 22: return 42;
            case 21: return 41;
            case 20: return 40;
            case 19: return 39;
            case 18: return 38;
            case 17: return 37;
            case 16: return 36;
            case 15: return 35;
            case 14: return 34;
            case 13: return 33;
            case 12: return 31;
            case 0: return 2;
            default: return 50;
        }
    }

    private int yyr4() { // frm : FORM IDENT '{' cmpnd_stmnt '}'
        { yyrv = new Form(((Ident)yysv[yysp-4]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 3;
    }

    private int yyr9() { // if_stmnt : IF '(' expr ')' '{' cmpnd_stmnt '}'
        { yyrv = new IfStatement(((Expression)yysv[yysp-5]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 4;
    }

    private int yyr10() { // if_stmnt : IF '(' expr ')' '{' cmpnd_stmnt '}' ELSE '{' cmpnd_stmnt '}'
        { yyrv = new IfElseStatement(((Expression)yysv[yysp-9]), ((CompoundStatement)yysv[yysp-6]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=11] = yyrv;
        return 4;
    }

    private int yyr30() { // quest : IDENT ':' TEXT data_type
        { yyrv = new Question(((Ident)yysv[yysp-4]), ((TextLiteral)yysv[yysp-2]), ((DataType)yysv[yysp-1])); }
        yysv[yysp-=4] = yyrv;
        return 5;
    }

    private int yyr7() { // stmnt : if_stmnt
        { yyrv = ((IfStatement)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypstmnt();
    }

    private int yyr8() { // stmnt : quest
        { yyrv = ((Question)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypstmnt();
    }

    private int yypstmnt() {
        switch (yyst[yysp-1]) {
            case 67: return 52;
            case 63: return 52;
            case 48: return 52;
            case 0: return 6;
            default: return 61;
        }
    }

    private int yyr5() { // cmpnd_stmnt : stmnt
        { yyrv = new CompoundStatement(((Statement)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypcmpnd_stmnt();
    }

    private int yyr6() { // cmpnd_stmnt : cmpnd_stmnt stmnt
        { ((CompoundStatement)yysv[yysp-2]).add(((Statement)yysv[yysp-1])); yyrv = ((CompoundStatement)yysv[yysp-2]); }
        yysv[yysp-=2] = yyrv;
        return yypcmpnd_stmnt();
    }

    private int yypcmpnd_stmnt() {
        switch (yyst[yysp-1]) {
            case 63: return 64;
            case 48: return 53;
            default: return 68;
        }
    }

    protected String[] yyerrmsgs = {
    };


private QLLexer lexer; 

private Form formResult;

private Expression exprResult;

private Statement stmntResult;

public Form getFormResult() {
  return formResult;
}

public Expression getExpressionResult() {
  return exprResult;
}

public Statement getStatementResult() {
  return stmntResult;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
