// Output created by jacc on Thu Jan 10 19:32:43 CET 2013

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;

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
                case 26:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 27:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 52;
                            continue;
                    }
                    yyn = 55;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 28:
                    yyn = yys2();
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
                case 29:
                    yyn = yys3();
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
                case 30:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 31:
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
                case 32:
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
                case 33:
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
                case 34:
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
                case 35:
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
                case 36:
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
                case 37:
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
                case 38:
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
                case 39:
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
                case 40:
                    yyn = yys14();
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 41:
                    yyn = yys15();
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 42:
                    yyn = yys16();
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 43:
                    yyn = yys17();
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 44:
                    yyn = yys18();
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 45:
                    yyn = yys19();
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 46:
                    yyn = yys20();
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 47:
                    yyn = yys21();
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 48:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 49:
                    yyn = yys23();
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 50:
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
                case 51:
                    yyn = yys25();
                    continue;

                case 52:
                    return true;
                case 53:
                    yyerror("stack overflow");
                case 54:
                    return false;
                case 55:
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
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 9;
            case OR:
                return 10;
            case '*':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
            case '/':
                return 14;
            case ENDINPUT:
                return yyr1();
        }
        return 55;
    }

    private int yys3() {
        switch (yytok) {
            case ENDINPUT:
            case '/':
            case '-':
            case '+':
            case OR:
            case '*':
            case ')':
            case AND:
                return yyr18();
        }
        return 55;
    }

    private int yys4() {
        switch (yytok) {
            case ENDINPUT:
            case '/':
            case '-':
            case '+':
            case OR:
            case '*':
            case ')':
            case AND:
                return yyr17();
        }
        return 55;
    }

    private int yys5() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys6() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys7() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys8() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys9() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys10() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys11() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys12() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys13() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys14() {
        switch (yytok) {
            case IDENT:
                return 3;
            case INT:
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case '+':
                return 7;
            case '-':
                return 8;
        }
        return 55;
    }

    private int yys15() {
        switch (yytok) {
            case ENDINPUT:
            case '/':
            case '-':
            case '+':
            case OR:
            case '*':
            case ')':
            case AND:
                return yyr10();
        }
        return 55;
    }

    private int yys16() {
        switch (yytok) {
            case AND:
                return 9;
            case OR:
                return 10;
            case '*':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
            case '/':
                return 14;
            case ')':
                return 25;
        }
        return 55;
    }

    private int yys17() {
        switch (yytok) {
            case ENDINPUT:
            case '/':
            case '-':
            case '+':
            case OR:
            case '*':
            case ')':
            case AND:
                return yyr8();
        }
        return 55;
    }

    private int yys18() {
        switch (yytok) {
            case ENDINPUT:
            case '/':
            case '-':
            case '+':
            case OR:
            case '*':
            case ')':
            case AND:
                return yyr9();
        }
        return 55;
    }

    private int yys19() {
        switch (yytok) {
            case '*':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
            case '/':
                return 14;
            case ENDINPUT:
            case OR:
            case ')':
            case AND:
                return yyr15();
        }
        return 55;
    }

    private int yys20() {
        switch (yytok) {
            case AND:
                return 9;
            case '*':
                return 11;
            case '+':
                return 12;
            case '-':
                return 13;
            case '/':
                return 14;
            case ENDINPUT:
            case OR:
            case ')':
                return yyr16();
        }
        return 55;
    }

    private int yys21() {
        switch (yytok) {
            case ENDINPUT:
            case '/':
            case '-':
            case '+':
            case OR:
            case '*':
            case ')':
            case AND:
                return yyr11();
        }
        return 55;
    }

    private int yys22() {
        switch (yytok) {
            case '*':
                return 11;
            case '/':
                return 14;
            case ENDINPUT:
            case '-':
            case '+':
            case OR:
            case ')':
            case AND:
                return yyr13();
        }
        return 55;
    }

    private int yys23() {
        switch (yytok) {
            case '*':
                return 11;
            case '/':
                return 14;
            case ENDINPUT:
            case '-':
            case '+':
            case OR:
            case ')':
            case AND:
                return yyr14();
        }
        return 55;
    }

    private int yys24() {
        switch (yytok) {
            case ENDINPUT:
            case '/':
            case '-':
            case '+':
            case OR:
            case '*':
            case ')':
            case AND:
                return yyr12();
        }
        return 55;
    }

    private int yys25() {
        switch (yytok) {
            case ENDINPUT:
            case '/':
            case '-':
            case '+':
            case OR:
            case '*':
            case ')':
            case AND:
                return yyr19();
        }
        return 55;
    }

    private int yyr1() { // top : expr
        { result = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr8() { // expr : '+' expr
        { yyrv = new Pos(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr9() { // expr : '-' expr
        { yyrv = new Neg(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr10() { // expr : '!' expr
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr11() { // expr : expr '*' expr
        { yyrv = new Mul(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr12() { // expr : expr '/' expr
        { yyrv = new Div(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : expr '+' expr
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr14() { // expr : expr '-' expr
        { yyrv = new Sub(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr15() { // expr : expr AND expr
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr16() { // expr : expr OR expr
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr17() { // expr : INT
        { yyrv = ((Int)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr18() { // expr : IDENT
        { yyrv = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr19() { // expr : '(' expr ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 13: return 23;
            case 12: return 22;
            case 11: return 21;
            case 10: return 20;
            case 9: return 19;
            case 8: return 18;
            case 7: return 17;
            case 6: return 16;
            case 5: return 15;
            case 0: return 2;
            default: return 24;
        }
    }

    protected String[] yyerrmsgs = {
    };

    private QLLexer lexer; 

    private Expression result;

    public Expression getResult() {
        return result;
    }

    public QLParser( QLLexer lexer ) { 
        this.lexer = lexer;
    }

    private void yyerror( String msg ) { 
        System.err.println( msg );
    }

}
