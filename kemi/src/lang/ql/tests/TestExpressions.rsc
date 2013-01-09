module lang::ql::tests::TestExpressions

import ParseTree;
import IO;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr load(loc l) = implode(parse(readFile(l), l));


private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testAdd1() = p("a + b") is add;
public test bool testAdd2() = p("a + b + c") is add;
public test bool testAdd3() = p("(a + b + c)") is add;
public test bool testAdd4() = p("a + (b + c)") is add;
public test bool testAdd5() = p("(a + b) + c") is add;
public test bool testAdd6() = p("(a + b)") is add;
public test bool testAdd7() = p("a + b * c") is add;
public test bool testAdd8() = p("a * b + c") is add;


public test bool testMul1() = p("a * b") is mul;
public test bool testMul2() = p("a * b * c") is mul;
public test bool testMul3() = p("a * (b * c)") is mul;
public test bool testMul4() = p("(a * b) * c") is mul;
public test bool testMul5() = p("(a * b)") is mul;
public test bool testMul6() = p("(a + b) * c") is mul;
public test bool testMul7() = p("a * (b + c)") is mul;

public test bool testRel1() = p("a \< b") is lt;
public test bool testRel2() = p("a \< b + c") is lt;
public test bool testRel3() = p("a \< (b * c)") is lt;
public test bool testRel4() = p("(a * b) \< c") is lt;
public test bool testRel5() = p("(a \<= b)") is leq;
public test bool testRel6() = p("a + b \> c") is gt;
public test bool testRel7() = p("a \> b + c") is gt;


public test bool testIdent1() = p("a") is ident;
public test bool testIdent2() = p("abc") is ident;
public test bool testIdent3() = p("ABC") is ident;
public test bool testIdent4() = p("ABCDEF") is ident;
public test bool testIdent5() = p("abc2323") is ident;
public test bool testIdent6() = p("a2bc232") is ident;
public test bool testIdent7() = p("a2bc232aa") is ident;
public test bool testInt1() = p("0") is \int;
public test bool testInt2() = p("1223") is \int;
public test bool testInt3() = p("234234234") is \int;


public test bool testBool1() = p("true") is boolean;
public test bool testBool2() = p("false") is boolean;

public test bool testMoney1() = p("1.21") is money;
public test bool testMoney2() = p("2.") is money;
public test bool testMoney3() = p("0.5") is money;

public test bool testText1() = p("\"afalse\"") is string;
public test bool testText2() = p("\"a b c @ $ ^\"") is string;
public test bool testText3() = p("\"af\\\"alse\"") is string;

public test bool testDate1() = p("$2013-01-08") is date;

//public test bool testQuestion1() = p("\"HAllo?\", bool, var") is question;

public void main() {
    println();
}
