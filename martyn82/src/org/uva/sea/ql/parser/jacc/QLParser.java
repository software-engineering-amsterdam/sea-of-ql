// Output created by jacc on Wed Jan 16 15:32:12 CET 2013

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
                case 69:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 70:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 138;
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
                    switch (yytok) {
                        case ';':
                        case ENDINPUT:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    yyn = yys3();
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    yyn = yys5();
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 75:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    switch (yytok) {
                        case ';':
                        case ENDINPUT:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 141;
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
                case 77:
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
                case 78:
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
                case 79:
                    switch (yytok) {
                        case '(':
                            yyn = 31;
                            continue;
                    }
                    yyn = 141;
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
                case 80:
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
                case 81:
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
                case 82:
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
                case 83:
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
                case 84:
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
                case 85:
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
                case 86:
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
                case 87:
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
                case 88:
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
                case 89:
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
                case 90:
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
                case 91:
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
                case 92:
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
                case 93:
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
                case 94:
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
                case 95:
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
                case 96:
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
                case 97:
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
                case 98:
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
                case 99:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 50;
                            continue;
                        case INTEGER:
                            yyn = 51;
                            continue;
                        case MONEY:
                            yyn = 52;
                            continue;
                        case STRING:
                            yyn = 53;
                            continue;
                    }
                    yyn = 141;
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
                case 100:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
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
                case 102:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    switch (yytok) {
                        case ';':
                        case ENDINPUT:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 141;
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
                case 119:
                    switch (yytok) {
                        case ';':
                        case ENDINPUT:
                            yyn = yyr34();
                            continue;
                    }
                    yyn = 141;
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
                case 120:
                    switch (yytok) {
                        case ';':
                        case ENDINPUT:
                            yyn = yyr36();
                            continue;
                    }
                    yyn = 141;
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
                case 121:
                    switch (yytok) {
                        case ';':
                        case ENDINPUT:
                            yyn = yyr35();
                            continue;
                    }
                    yyn = 141;
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
                case 122:
                    switch (yytok) {
                        case ';':
                        case ENDINPUT:
                            yyn = yyr37();
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
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
                case 124:
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
                case 125:
                    switch (yytok) {
                        case '{':
                            yyn = 57;
                            continue;
                    }
                    yyn = 141;
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
                case 126:
                    switch (yytok) {
                        case IF:
                            yyn = 10;
                            continue;
                        case IDENT:
                            yyn = 60;
                            continue;
                        case '}':
                            yyn = 61;
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    switch (yytok) {
                        case ';':
                            yyn = 62;
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    switch (yytok) {
                        case '}':
                            yyn = 63;
                            continue;
                    }
                    yyn = 141;
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
                case 129:
                    switch (yytok) {
                        case ':':
                            yyn = 30;
                            continue;
                    }
                    yyn = 141;
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
                case 130:
                    switch (yytok) {
                        case ';':
                        case ENDINPUT:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 141;
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
                case 131:
                    switch (yytok) {
                        case IF:
                            yyn = 10;
                            continue;
                        case IDENT:
                            yyn = 60;
                            continue;
                        case '}':
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 141;
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
                case 132:
                    switch (yytok) {
                        case ELSE:
                            yyn = 65;
                            continue;
                        case ';':
                        case ENDINPUT:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    switch (yytok) {
                        case '}':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 141;
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
                case 134:
                    switch (yytok) {
                        case '{':
                            yyn = 66;
                            continue;
                    }
                    yyn = 141;
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
                case 135:
                    switch (yytok) {
                        case IF:
                            yyn = 10;
                            continue;
                        case IDENT:
                            yyn = 60;
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 67:
                    yyst[yysp] = 67;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    switch (yytok) {
                        case '}':
                            yyn = 68;
                            continue;
                    }
                    yyn = 141;
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
                case 137:
                    switch (yytok) {
                        case ';':
                        case ENDINPUT:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 141;
                    continue;

                case 138:
                    return true;
                case 139:
                    yyerror("stack overflow");
                case 140:
                    return false;
                case 141:
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
                return 8;
            case IDENT:
                return 9;
            case IF:
                return 10;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
        }
        return 141;
    }

    private int yys3() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr27();
        }
        return 141;
    }

    private int yys5() {
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
                return yyr2();
        }
        return 141;
    }

    private int yys8() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr29();
        }
        return 141;
    }

    private int yys9() {
        switch (yytok) {
            case ':':
                return 30;
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr33();
        }
        return 141;
    }

    private int yys11() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr31();
        }
        return 141;
    }

    private int yys12() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr30();
        }
        return 141;
    }

    private int yys13() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr32();
        }
        return 141;
    }

    private int yys14() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys15() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys16() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys17() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys18() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys19() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys20() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys21() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys22() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys23() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys24() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys25() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys26() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys27() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys28() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys29() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys31() {
        switch (yytok) {
            case BOOL:
                return 8;
            case INT:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENT:
                return 33;
        }
        return 141;
    }

    private int yys32() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr14();
        }
        return 141;
    }

    private int yys33() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr33();
        }
        return 141;
    }

    private int yys34() {
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
                return 55;
        }
        return 141;
    }

    private int yys35() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr12();
        }
        return 141;
    }

    private int yys36() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr13();
        }
        return 141;
    }

    private int yys37() {
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
            case OR:
            case ')':
            case ENDINPUT:
            case AND:
                return yyr25();
        }
        return 141;
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
            case OR:
            case NEQ:
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr19();
        }
        return 141;
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
            case OR:
            case NEQ:
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr23();
        }
        return 141;
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
            case OR:
            case NEQ:
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr24();
        }
        return 141;
    }

    private int yys41() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case OR:
            case NEQ:
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr20();
        }
        return 141;
    }

    private int yys42() {
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
            case OR:
            case ')':
            case ENDINPUT:
                return yyr26();
        }
        return 141;
    }

    private int yys43() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr15();
        }
        return 141;
    }

    private int yys44() {
        switch (yytok) {
            case '*':
                return 24;
            case '/':
                return 27;
            case OR:
            case NEQ:
            case '-':
            case '+':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr17();
        }
        return 141;
    }

    private int yys45() {
        switch (yytok) {
            case '*':
                return 24;
            case '/':
                return 27;
            case OR:
            case NEQ:
            case '-':
            case '+':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr18();
        }
        return 141;
    }

    private int yys46() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr16();
        }
        return 141;
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
            case OR:
            case NEQ:
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr22();
        }
        return 141;
    }

    private int yys48() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case OR:
            case NEQ:
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr21();
        }
        return 141;
    }

    private int yys54() {
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
                return 56;
        }
        return 141;
    }

    private int yys55() {
        switch (yytok) {
            case OR:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '*':
            case ')':
            case GEQ:
            case '<':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case AND:
                return yyr28();
        }
        return 141;
    }

    private int yyr1() { // start : node
        { result = ((ASTNode)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr8() { // ifblock : IF '(' expression ')' '{' statements '}' ELSE '{' statements '}'
        { yyrv = new If( ((Expression)yysv[yysp-9]), ((Statements)yysv[yysp-6]), ((Statements)yysv[yysp-2]) ); }
        yysv[yysp-=11] = yyrv;
        return 2;
    }

    private int yyr9() { // ifblock : IF '(' expression ')' '{' statements '}'
        { yyrv = new If( ((Expression)yysv[yysp-5]), ((Statements)yysv[yysp-2]) ); }
        yysv[yysp-=7] = yyrv;
        return 2;
    }

    private int yyr10() { // ifblock : IF '(' expression ')' '{' '}'
        { yyrv = new If( ((Expression)yysv[yysp-4]) ); }
        yysv[yysp-=6] = yyrv;
        return 2;
    }

    private int yyr29() { // literal : BOOL
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Bool)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 3;
    }

    private int yyr30() { // literal : MON
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Money)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 3;
    }

    private int yyr31() { // literal : INT
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 3;
    }

    private int yyr32() { // literal : STR
        { yyrv = ((org.uva.sea.ql.ast.expression.value.Str)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 3;
    }

    private int yyr33() { // literal : IDENT
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 3;
    }

    private int yyr2() { // node : expression
        yysp -= 1;
        return 4;
    }

    private int yyr3() { // node : statement
        yysp -= 1;
        return 4;
    }

    private int yyr12() { // expression : '+' expression
        { yyrv = new Pos( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr13() { // expression : '-' expression
        { yyrv = new Neg( ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr14() { // expression : '!' expression
        { yyrv = new Not( ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr15() { // expression : expression '*' expression
        { yyrv = new Mul( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr16() { // expression : expression '/' expression
        { yyrv = new Div( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr17() { // expression : expression '+' expression
        { yyrv = new Add( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr18() { // expression : expression '-' expression
        { yyrv = new Sub( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr19() { // expression : expression EQ expression
        { yyrv = new Eq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr20() { // expression : expression NEQ expression
        { yyrv = new NEq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr21() { // expression : expression '>' expression
        { yyrv = new GT( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr22() { // expression : expression '<' expression
        { yyrv = new LT( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr23() { // expression : expression GEQ expression
        { yyrv = new GEq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr24() { // expression : expression LEQ expression
        { yyrv = new LEq( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr25() { // expression : expression AND expression
        { yyrv = new And( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr26() { // expression : expression OR expression
        { yyrv = new Or( ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr27() { // expression : literal
        yysp -= 1;
        return yypexpression();
    }

    private int yyr28() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 29: return 48;
            case 28: return 47;
            case 27: return 46;
            case 26: return 45;
            case 25: return 44;
            case 24: return 43;
            case 23: return 42;
            case 22: return 41;
            case 21: return 40;
            case 20: return 39;
            case 19: return 38;
            case 18: return 37;
            case 17: return 36;
            case 16: return 35;
            case 15: return 34;
            case 14: return 32;
            case 0: return 5;
            default: return 54;
        }
    }

    private int yyr6() { // statement : ifblock
        yysp -= 1;
        return yypstatement();
    }

    private int yyr7() { // statement : vardecl
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 0: return 6;
            default: return 58;
        }
    }

    private int yyr4() { // statements : statement ';' statements
        { yyrv = new Statements( ((Statement)yysv[yysp-3]), ((Statements)yysv[yysp-1]) ); }
        yysv[yysp-=3] = yyrv;
        return yypstatements();
    }

    private int yyr5() { // statements : statement ';'
        { yyrv = new Statements( ((Statement)yysv[yysp-2]) ); }
        yysv[yysp-=2] = yyrv;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 62: return 64;
            case 57: return 59;
            default: return 67;
        }
    }

    private int yyr34() { // type : BOOLEAN
        { yyrv = ((org.uva.sea.ql.ast.type.Bool)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 49;
    }

    private int yyr35() { // type : MONEY
        { yyrv = ((org.uva.sea.ql.ast.type.Money)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 49;
    }

    private int yyr36() { // type : INTEGER
        { yyrv = ((org.uva.sea.ql.ast.type.Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 49;
    }

    private int yyr37() { // type : STRING
        { yyrv = ((org.uva.sea.ql.ast.type.Str)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 49;
    }

    private int yyr11() { // vardecl : IDENT ':' type
        { yyrv = new VarDeclaration( (Ident) yysv[yysp-3], (Type) yysv[yysp-1] ); }
        yysv[yysp-=3] = yyrv;
        return 7;
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
    private ASTNode result;
    
    /**
     * Retrieves the generated AST.
     *
     * @return The AST.
     */
    public ASTNode getResult() {
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
