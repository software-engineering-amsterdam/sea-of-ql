// Output created by jacc on Mon Feb 11 14:50:10 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.stm.*;
import org.uva.sea.ql.ast.exp.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.value.*;

@edu.umd.cs.findbugs.annotations.SuppressWarnings(
    value="URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", 
    justification="because this class is generated.")
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
                case 74:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 75:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 148;
                            continue;
                    }
                    yyn = 151;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    switch (yytok) {
                        case IDENT:
                            yyn = 19;
                            continue;
                        case ENDINPUT:
                            yyn = yyr28();
                            continue;
                    }
                    yyn = 151;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 77:
                    yyn = yys3();
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr25();
                            continue;
                    }
                    yyn = 151;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr27();
                            continue;
                    }
                    yyn = 151;
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
                case 80:
                    switch (yytok) {
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr21();
                            continue;
                    }
                    yyn = 151;
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
                case 81:
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
                case 82:
                    switch (yytok) {
                        case IDENT:
                            yyn = 32;
                            continue;
                    }
                    yyn = 151;
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
                case 83:
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
                case 84:
                    switch (yytok) {
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr22();
                            continue;
                    }
                    yyn = 151;
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
                case 85:
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
                case 86:
                    switch (yytok) {
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr23();
                            continue;
                    }
                    yyn = 151;
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
                case 87:
                    switch (yytok) {
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr24();
                            continue;
                    }
                    yyn = 151;
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
                case 88:
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
                case 89:
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
                case 90:
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
                case 91:
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
                case 92:
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
                case 93:
                    switch (yytok) {
                        case '=':
                            yyn = 37;
                            continue;
                    }
                    yyn = 151;
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
                case 94:
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
                case 95:
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
                case 96:
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
                case 97:
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
                case 98:
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
                case 99:
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
                case 100:
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
                case 101:
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
                case 102:
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
                case 103:
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
                case 104:
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
                case 105:
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
                case 106:
                    switch (yytok) {
                        case '{':
                            yyn = 50;
                            continue;
                    }
                    yyn = 151;
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
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
                case 111:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
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
                case 124:
                    switch (yytok) {
                        case BOOL:
                            yyn = 6;
                            continue;
                        case INT:
                            yyn = 10;
                            continue;
                        case MON:
                            yyn = 12;
                            continue;
                        case STR:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 59;
                            continue;
                    }
                    yyn = 151;
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
                case 125:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
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
                case 127:
                    switch (yytok) {
                        case ';':
                            yyn = 61;
                            continue;
                    }
                    yyn = 151;
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    switch (yytok) {
                        case IDENT:
                            yyn = 19;
                            continue;
                    }
                    yyn = 151;
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
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
                case 133:
                    switch (yytok) {
                        case '(':
                            yyn = 64;
                            continue;
                    }
                    yyn = 151;
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
                case 134:
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
                case 135:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
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
                case 137:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr29();
                            continue;
                    }
                    yyn = 151;
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
                case 138:
                    yyn = yys64();
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
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
                case 140:
                    switch (yytok) {
                        case '{':
                            yyn = 67;
                            continue;
                    }
                    yyn = 151;
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
                case 141:
                    switch (yytok) {
                        case BOOL:
                            yyn = 6;
                            continue;
                        case INT:
                            yyn = 10;
                            continue;
                        case MON:
                            yyn = 12;
                            continue;
                        case STR:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 59;
                            continue;
                    }
                    yyn = 151;
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    yyn = yys68();
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
                case 143:
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
                case 144:
                    switch (yytok) {
                        case '{':
                            yyn = 71;
                            continue;
                    }
                    yyn = 151;
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
                case 145:
                    switch (yytok) {
                        case BOOL:
                            yyn = 6;
                            continue;
                        case INT:
                            yyn = 10;
                            continue;
                        case MON:
                            yyn = 12;
                            continue;
                        case STR:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 59;
                            continue;
                    }
                    yyn = 151;
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
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
                case 147:
                    yyn = yys73();
                    continue;

                case 148:
                    return true;
                case 149:
                    yyerror("stack overflow");
                case 150:
                    return false;
                case 151:
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
                return 6;
            case FALSE:
                return 7;
            case FORM:
                return 8;
            case IDENT:
                return 9;
            case INT:
                return 10;
            case INT_VAL:
                return 11;
            case MON:
                return 12;
            case STR:
                return 13;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys3() {
        switch (yytok) {
            case AND:
                return 20;
            case EQ:
                return 21;
            case GEQ:
                return 22;
            case LEQ:
                return 23;
            case NEQ:
                return 24;
            case OR:
                return 25;
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case '<':
                return 30;
            case '>':
                return 31;
            case ENDINPUT:
                return yyr26();
        }
        return 151;
    }

    private int yys7() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr19();
        }
        return 151;
    }

    private int yys9() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr17();
        }
        return 151;
    }

    private int yys11() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr16();
        }
        return 151;
    }

    private int yys14() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr18();
        }
        return 151;
    }

    private int yys15() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys16() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys17() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys18() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys20() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys21() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys22() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys23() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys24() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys25() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys26() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys27() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys28() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys29() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys30() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys31() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys33() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr3();
        }
        return 151;
    }

    private int yys34() {
        switch (yytok) {
            case AND:
                return 20;
            case EQ:
                return 21;
            case GEQ:
                return 22;
            case LEQ:
                return 23;
            case NEQ:
                return 24;
            case OR:
                return 25;
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case '<':
                return 30;
            case '>':
                return 31;
            case ')':
                return 51;
        }
        return 151;
    }

    private int yys35() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr1();
        }
        return 151;
    }

    private int yys36() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr2();
        }
        return 151;
    }

    private int yys37() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
            case STRING_VAL:
                return 53;
        }
        return 151;
    }

    private int yys38() {
        switch (yytok) {
            case EQ:
                return 21;
            case GEQ:
                return 22;
            case LEQ:
                return 23;
            case NEQ:
                return 24;
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case '<':
                return 30;
            case '>':
                return 31;
            case ')':
            case ENDINPUT:
            case OR:
            case ';':
            case AND:
                return yyr14();
        }
        return 151;
    }

    private int yys39() {
        switch (yytok) {
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr8();
        }
        return 151;
    }

    private int yys40() {
        switch (yytok) {
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr12();
        }
        return 151;
    }

    private int yys41() {
        switch (yytok) {
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr13();
        }
        return 151;
    }

    private int yys42() {
        switch (yytok) {
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr9();
        }
        return 151;
    }

    private int yys43() {
        switch (yytok) {
            case AND:
                return 20;
            case EQ:
                return 21;
            case GEQ:
                return 22;
            case LEQ:
                return 23;
            case NEQ:
                return 24;
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case '<':
                return 30;
            case '>':
                return 31;
            case ')':
            case ENDINPUT:
            case OR:
            case ';':
                return yyr15();
        }
        return 151;
    }

    private int yys44() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr4();
        }
        return 151;
    }

    private int yys45() {
        switch (yytok) {
            case '*':
                return 26;
            case '/':
                return 29;
            case '-':
            case '+':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr6();
        }
        return 151;
    }

    private int yys46() {
        switch (yytok) {
            case '*':
                return 26;
            case '/':
                return 29;
            case '-':
            case '+':
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr7();
        }
        return 151;
    }

    private int yys47() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr5();
        }
        return 151;
    }

    private int yys48() {
        switch (yytok) {
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr11();
        }
        return 151;
    }

    private int yys49() {
        switch (yytok) {
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case ')':
            case LEQ:
            case EQ:
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr10();
        }
        return 151;
    }

    private int yys51() {
        switch (yytok) {
            case '-':
            case '+':
            case '*':
            case ')':
            case LEQ:
            case EQ:
            case '/':
            case ENDINPUT:
            case '>':
            case OR:
            case '<':
            case ';':
            case NEQ:
            case GEQ:
            case AND:
                return yyr20();
        }
        return 151;
    }

    private int yys52() {
        switch (yytok) {
            case AND:
                return 20;
            case EQ:
                return 21;
            case GEQ:
                return 22;
            case LEQ:
                return 23;
            case NEQ:
                return 24;
            case OR:
                return 25;
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case '<':
                return 30;
            case '>':
                return 31;
            case ';':
                return 60;
        }
        return 151;
    }

    private int yys54() {
        switch (yytok) {
            case BOOL:
                return 6;
            case INT:
                return 10;
            case MON:
                return 12;
            case STR:
                return 13;
            case IF:
                return 59;
            case '}':
                return 63;
        }
        return 151;
    }

    private int yys56() {
        switch (yytok) {
            case MON:
            case INT:
            case IF:
            case '}':
            case STR:
            case BOOL:
                return yyr33();
        }
        return 151;
    }

    private int yys57() {
        switch (yytok) {
            case MON:
            case INT:
            case IF:
            case '}':
            case STR:
            case BOOL:
                return yyr32();
        }
        return 151;
    }

    private int yys58() {
        switch (yytok) {
            case MON:
            case INT:
            case IF:
            case '}':
            case STR:
            case BOOL:
                return yyr30();
        }
        return 151;
    }

    private int yys60() {
        switch (yytok) {
            case MON:
            case INT:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case BOOL:
                return yyr35();
        }
        return 151;
    }

    private int yys61() {
        switch (yytok) {
            case MON:
            case INT:
            case IF:
            case ENDINPUT:
            case '}':
            case STR:
            case BOOL:
                return yyr34();
        }
        return 151;
    }

    private int yys62() {
        switch (yytok) {
            case MON:
            case INT:
            case IF:
            case '}':
            case STR:
            case BOOL:
                return yyr31();
        }
        return 151;
    }

    private int yys64() {
        switch (yytok) {
            case FALSE:
                return 7;
            case IDENT:
                return 9;
            case INT_VAL:
                return 11;
            case TRUE:
                return 14;
            case '!':
                return 15;
            case '(':
                return 16;
            case '+':
                return 17;
            case '-':
                return 18;
        }
        return 151;
    }

    private int yys65() {
        switch (yytok) {
            case AND:
                return 20;
            case EQ:
                return 21;
            case GEQ:
                return 22;
            case LEQ:
                return 23;
            case NEQ:
                return 24;
            case OR:
                return 25;
            case '*':
                return 26;
            case '+':
                return 27;
            case '-':
                return 28;
            case '/':
                return 29;
            case '<':
                return 30;
            case '>':
                return 31;
            case ')':
                return 66;
        }
        return 151;
    }

    private int yys68() {
        switch (yytok) {
            case BOOL:
                return 6;
            case INT:
                return 10;
            case MON:
                return 12;
            case STR:
                return 13;
            case IF:
                return 59;
            case '}':
                return 69;
        }
        return 151;
    }

    private int yys69() {
        switch (yytok) {
            case ELSE:
                return 70;
            case MON:
            case INT:
            case IF:
            case '}':
            case STR:
            case BOOL:
                return yyr36();
        }
        return 151;
    }

    private int yys72() {
        switch (yytok) {
            case BOOL:
                return 6;
            case INT:
                return 10;
            case MON:
                return 12;
            case STR:
                return 13;
            case IF:
                return 59;
            case '}':
                return 73;
        }
        return 151;
    }

    private int yys73() {
        switch (yytok) {
            case MON:
            case INT:
            case IF:
            case '}':
            case STR:
            case BOOL:
                return yyr37();
        }
        return 151;
    }

    private int yyr25() { // top : form
        { form = ((Form)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr26() { // top : expr
        { result = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr27() { // top : question
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr28() { // top : dataType
        { result = ((DataType)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr30() { // compound : block
        { yyrv = new CompoundStatement(((Block)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypcompound();
    }

    private int yyr31() { // compound : compound block
        { yyrv = new CompoundStatement(((CompoundStatement)yysv[yysp-2]), ((Block)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypcompound();
    }

    private int yypcompound() {
        switch (yyst[yysp-1]) {
            case 67: return 68;
            case 50: return 54;
            default: return 72;
        }
    }

    private int yyr21() { // dataType : BOOL
        { yyrv = new BooleanType(); }
        yysv[yysp-=1] = yyrv;
        return yypdataType();
    }

    private int yyr22() { // dataType : INT
        { yyrv = new IntegerType(); }
        yysv[yysp-=1] = yyrv;
        return yypdataType();
    }

    private int yyr23() { // dataType : MON
        { yyrv = new MoneyType(); }
        yysv[yysp-=1] = yyrv;
        return yypdataType();
    }

    private int yyr24() { // dataType : STR
        { yyrv = new StringType(); }
        yysv[yysp-=1] = yyrv;
        return yypdataType();
    }

    private int yypdataType() {
        switch (yyst[yysp-1]) {
            case 0: return 2;
            default: return 55;
        }
    }

    private int yyr1() { // expr : '+' expr
        { yyrv = new Positive(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr2() { // expr : '-' expr
        { yyrv = new Negative(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr3() { // expr : '!' expr
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr4() { // expr : expr '*' expr
        { yyrv = new Multiply(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr5() { // expr : expr '/' expr
        { yyrv = new Divide(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr6() { // expr : expr '+' expr
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr7() { // expr : expr '-' expr
        { yyrv = new Substitute(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr8() { // expr : expr EQ expr
        { yyrv = new Equals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr9() { // expr : expr NEQ expr
        { yyrv = new NotEquals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr10() { // expr : expr '>' expr
        { yyrv = new GreaterThan(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr11() { // expr : expr '<' expr
        { yyrv = new SmallerThan(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr12() { // expr : expr GEQ expr
        { yyrv = new GreaterOrEquals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : expr LEQ expr
        { yyrv = new SmallerOrEquals(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : expr AND expr
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : expr OR expr
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : INT_VAL
        { yyrv = ((IntegerValue)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : IDENT
        { yyrv = ((Identifier)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : TRUE
        { yyrv = new BooleanValue(true); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : FALSE
        { yyrv = new BooleanValue(false); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : '(' expr ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 37: return 52;
            case 31: return 49;
            case 30: return 48;
            case 29: return 47;
            case 28: return 46;
            case 27: return 45;
            case 26: return 44;
            case 25: return 43;
            case 24: return 42;
            case 23: return 41;
            case 22: return 40;
            case 21: return 39;
            case 20: return 38;
            case 18: return 36;
            case 17: return 35;
            case 16: return 34;
            case 15: return 33;
            case 0: return 3;
            default: return 65;
        }
    }

    private int yyr29() { // form : FORM IDENT '{' compound '}'
        { yyrv = new Form(((Identifier)yysv[yysp-4]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 4;
    }

    private int yyr36() { // ifStm : IF '(' expr ')' '{' compound '}'
        { yyrv = new IfStatement(((Expression)yysv[yysp-5]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=7] = yyrv;
        return 56;
    }

    private int yyr37() { // ifStm : IF '(' expr ')' '{' compound '}' ELSE '{' compound '}'
        { yyrv = new IfElseStatement(((Expression)yysv[yysp-9]), ((CompoundStatement)yysv[yysp-6]), ((CompoundStatement)yysv[yysp-2])); }
        yysv[yysp-=11] = yyrv;
        return 56;
    }

    private int yyr34() { // question : dataType IDENT '=' STRING_VAL ';'
        { yyrv = new Question(((DataType)yysv[yysp-5]), ((Identifier)yysv[yysp-4]), ((StringValue)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return yypquestion();
    }

    private int yyr35() { // question : dataType IDENT '=' expr ';'
        { yyrv = new Computed(((DataType)yysv[yysp-5]), ((Identifier)yysv[yysp-4]), ((Expression)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return yypquestion();
    }

    private int yypquestion() {
        switch (yyst[yysp-1]) {
            case 0: return 5;
            default: return 57;
        }
    }

    private int yyr32() { // block : question
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypblock();
    }

    private int yyr33() { // block : ifStm
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypblock();
    }

    private int yypblock() {
        switch (yyst[yysp-1]) {
            case 71: return 58;
            case 67: return 58;
            case 50: return 58;
            default: return 62;
        }
    }

    protected String[] yyerrmsgs = {
    };


private QLLexer lexer; 
private ASTNode result;
private Form form;
private String errorMessage;

/**
* @return 
*/
protected ASTNode getResult(){
        return result;
}

/**
* @return 
*/
public Form getForm(){
        return form;
}
 
public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  this.errorMessage = msg;
}

public String getErrorMessage(){
        return errorMessage;
}

}
