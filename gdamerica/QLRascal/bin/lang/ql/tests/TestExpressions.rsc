module lang::ql::tests::TestExpressions

import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::AST;

private Expr p(str src) = implode(parse(src, |file:///-|));

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

public test bool testMoney1() = p("1.0") is money;
public test bool testMoney2() = p("1.12") is money;
public test bool testMoney3() = p("12345.12") is money;
public test bool testMoney4() = p("12.123") is money; // doesn't work with .000 need more testing returns parse error

public test bool testString1() = p("\"Testing\"") is string;
public test bool testString2() = p("\"Test or not?\"") is string;
public test bool testString3() = p("\"Test 12345#\"") is string;

public test bool testDate1() = p("15/12/23") is date;

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





