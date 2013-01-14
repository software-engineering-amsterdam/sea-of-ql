// Output created by jacc on Mon Jan 14 17:12:25 CET 2013

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
                case 28:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 29:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 56;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 30:
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
                case 31:
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
                case 32:
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
                case 33:
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
                case 34:
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
                case 35:
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
                case 36:
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
                case 37:
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
                case 38:
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
                case 39:
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
                case 40:
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
                case 41:
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
                case 42:
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
                case 43:
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
                case 44:
                    yyn = yys16();
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 45:
                    yyn = yys17();
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 46:
                    yyn = yys18();
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 47:
                    yyn = yys19();
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 48:
                    yyn = yys20();
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 49:
                    yyn = yys21();
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 50:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 51:
                    yyn = yys23();
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 52:
                    yyn = yys24();
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 53:
                    yyn = yys25();
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 54:
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
                case 55:
                    yyn = yys27();
                    continue;

                case 56:
                    return true;
                case 57:
                    yyerror("stack overflow");
                case 58:
                    return false;
                case 59:
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
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 11;
            case OR:
                return 12;
            case '*':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case '/':
                return 16;
            case ENDINPUT:
                return yyr2();
        }
        return 59;
    }

    private int yys3() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr32();
        }
        return 59;
    }

    private int yys4() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr33();
        }
        return 59;
    }

    private int yys5() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr30();
        }
        return 59;
    }

    private int yys6() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr31();
        }
        return 59;
    }

    private int yys7() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys8() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys9() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys10() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys11() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys12() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys13() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys14() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys15() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys16() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 3;
            case IDENTIFIER:
                return 4;
            case NUMBERLITERAL:
                return 5;
            case STRINGLITERAL:
                return 6;
            case '!':
                return 7;
            case '(':
                return 8;
            case '+':
                return 9;
            case '-':
                return 10;
        }
        return 59;
    }

    private int yys17() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 59;
    }

    private int yys18() {
        switch (yytok) {
            case AND:
                return 11;
            case OR:
                return 12;
            case '*':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case '/':
                return 16;
            case ')':
                return 27;
        }
        return 59;
    }

    private int yys19() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr21();
        }
        return 59;
    }

    private int yys20() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr22();
        }
        return 59;
    }

    private int yys21() {
        switch (yytok) {
            case '*':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case '/':
                return 16;
            case OR:
            case ')':
            case ENDINPUT:
            case AND:
                return yyr28();
        }
        return 59;
    }

    private int yys22() {
        switch (yytok) {
            case AND:
                return 11;
            case '*':
                return 13;
            case '+':
                return 14;
            case '-':
                return 15;
            case '/':
                return 16;
            case OR:
            case ')':
            case ENDINPUT:
                return yyr29();
        }
        return 59;
    }

    private int yys23() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr24();
        }
        return 59;
    }

    private int yys24() {
        switch (yytok) {
            case '*':
                return 13;
            case '/':
                return 16;
            case OR:
            case '-':
            case '+':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr26();
        }
        return 59;
    }

    private int yys25() {
        switch (yytok) {
            case '*':
                return 13;
            case '/':
                return 16;
            case OR:
            case '-':
            case '+':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr27();
        }
        return 59;
    }

    private int yys26() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr25();
        }
        return 59;
    }

    private int yys27() {
        switch (yytok) {
            case '/':
            case OR:
            case '-':
            case '+':
            case '*':
            case ')':
            case ENDINPUT:
            case AND:
                return yyr34();
        }
        return 59;
    }

    private int yyr2() { // testexpression : expression
        { result = ((Expression)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr21() { // expression : '+' expression
        { yyrv = new UnaryPlus(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr22() { // expression : '-' expression
        { yyrv = new UnaryMinus(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr23() { // expression : '!' expression
        { yyrv = new UnaryNot(lexer.location(), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpression();
    }

    private int yyr24() { // expression : expression '*' expression
        { yyrv = new Multiplication(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr25() { // expression : expression '/' expression
        { yyrv = new Division(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr26() { // expression : expression '+' expression
        { yyrv = new Addition(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr27() { // expression : expression '-' expression
        { yyrv = new Subtraction(lexer.location(), ((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1]));}
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr28() { // expression : expression AND expression
        { yyrv = new And(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr29() { // expression : expression OR expression
        { yyrv = new Or(lexer.location(),((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yyr30() { // expression : NUMBERLITERAL
        { yyrv = ((NumberLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr31() { // expression : STRINGLITERAL
        { yyrv = ((StringLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr32() { // expression : BOOLEANLITERAL
        { yyrv = ((BooleanLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr33() { // expression : IDENTIFIER
        { yyrv = ((Identifier)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpression();
    }

    private int yyr34() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 15: return 25;
            case 14: return 24;
            case 13: return 23;
            case 12: return 22;
            case 11: return 21;
            case 10: return 20;
            case 9: return 19;
            case 8: return 18;
            case 7: return 17;
            case 0: return 2;
            default: return 26;
        }
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

}
