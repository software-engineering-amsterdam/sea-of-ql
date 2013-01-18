module lang::ql::tests::ASTTests::TestExpressions

import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::AST;

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

public test bool testSub1() = p("a - b") is sub;
public test bool testSub2() = p("a - b -c") is sub;
public test bool testSub3() = p("a - (b*c)") is sub;
public test bool testSub4() = p("a - ( b * ( d + c ) )") is sub;
public test bool testSub5() = p("a - b") is sub;

public test bool testRel1() = p("a \< b") is lt;
public test bool testRel2() = p("a \< b + c") is lt;
public test bool testRel3() = p("a \< (b * c)") is lt;
public test bool testRel4() = p("(a * b) \< c") is lt;
public test bool testRel5() = p("(a \<= b)") is leq;
public test bool testRel6() = p("a + b \> c") is gt;
public test bool testRel7() = p("a \> b + c") is gt;
public test bool testRel8() = p("a && b + c") is and;
public test bool testRel9() = p("a || b + c") is or;
public test bool testRel10() = p("(a || b) && c") is and;

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

public test bool testFloat1() = p("2.32") is float;
public test bool testFloat2() = p("2.00") is float;
public test bool testFloat3() = p("50000021312.01") is float;

public test bool testDate1() = p("12/21/1999/") is date;

public test bool testMoney1() = p("12.1") is money;
public test bool testMoney2() = p("12.14") is money;

public test bool testBoolean1() = p("true") is boolean;
public test bool testBoolean2() = p("false") is boolean;

public test bool testString1() = p("\"Testing string?\"") is string;
public test bool testString2() = p("\"Do you have any pets?\"") is string;
public test bool testString3() = p("\"Name:\"") is string;
public test bool testString4() = p("\"Grades: (A for [8-10],B for [5,5-8]):\"") is string;
public test bool testString5() = p("\"Grades: (A for [8-10],B for [5,5-8])") is string;



