/**
 * This module define test functions for each Expr variant 
 * A test function is a boolean function without arguments 
 * it can also be called automatically by the unit test framework, by typing :test   
 * @author  Gerson Delgado
 * @version 1.0, 20/01/2013
 */
 
module lang::ql::tests::TestExpressions


import lang::ql::ast::AST;
import lang::ql::util::Parse;
import ParseTree;

private Expr p(str src) = implode(#Expr, parseExpression(src));

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

public test bool testString1() = p("\"Testing\"") is string;
public test bool testString2() = p("\"Test or not?\"") is string;
public test bool testString3() = p("\"Test 12345#\"") is string;

public test bool testDate1() = p("20/01/2013/") is date;

public test bool testDecimal1() = p("2.123") is decimal;
public test bool testDecimal2() = p("12.123") is decimal;
public test bool testDecimal3() = p("1234568.123") is decimal;

public test bool testPos1() = p("+3") is pos;

public test bool testNeg1() = p("-3") is neg;

public test bool testNot1() = p("!(a+b)") is not;
public test bool testNot2() = p("!b") is not;

public test bool testMul1() = p("a * b") is mul;
public test bool testMul2() = p("a * b * c") is mul;
public test bool testMul3() = p("a * (b * c)") is mul;
public test bool testMul4() = p("(a * b) * c") is mul;
public test bool testMul5() = p("(a * b)") is mul;
public test bool testMul6() = p("(a + b) * c") is mul;
public test bool testMul7() = p("a * (b + c)") is mul;

public test bool testDiv1() = p("a / b") is div;
public test bool testDiv2() = p("a / b / c") is div;
public test bool testDiv3() = p("a / (b / c)") is div;
public test bool testDiv4() = p("(a / b) / c") is div;
public test bool testDiv5() = p("(a / b)") is div;
public test bool testDiv6() = p("(a * b) / c") is div;
public test bool testDiv7() = p("a / (b + c)") is div;

public test bool testAdd1() = p("a + b") is add;
public test bool testAdd2() = p("a + b + c") is add;
public test bool testAdd3() = p("(a + b + c)") is add;
public test bool testAdd4() = p("a + (b + c)") is add;
public test bool testAdd5() = p("(a + b) + c") is add;
public test bool testAdd6() = p("(a + b)") is add;
public test bool testAdd7() = p("a + b * c") is add;
public test bool testAdd8() = p("a * b + c") is add;

public test bool testSub1() = p("a - b") is sub;
public test bool testSub2() = p("a - b - c") is sub;
public test bool testSub3() = p("(a - b - c)") is sub;
public test bool testSub4() = p("a - (b - c)") is sub;
public test bool testSub5() = p("(a - b) - c") is sub;
public test bool testSub6() = p("(a - b)") is sub;
public test bool testSub7() = p("a - b / c") is sub;
public test bool testSub8() = p("a / b - c") is sub;

public test bool testRel1() = p("a \< b") is lt;
public test bool testRel2() = p("a \< b + c") is lt;
public test bool testRel3() = p("a \< (b * c)") is lt;
public test bool testRel4() = p("(a * b) \< c") is lt;

public test bool testRel5() = p("(a + b) \<= c") is leq;
public test bool testRel6() = p("(a \<= b)") is leq;
public test bool testRel7() = p("(a + b) \<= c") is leq;
public test bool testRel8() = p("a \<= b") is leq;

public test bool testRel9() = p("a + b \> c") is gt;
public test bool testRel10() = p("a \> b + c") is gt;
public test bool testRel11() = p("(a * b) \> c") is gt;
public test bool testRel12() = p("(a \> b)") is gt;

public test bool testRel13() = p("a + b \>= c") is geq;
public test bool testRel14() = p("a \>= b + c") is geq;
public test bool testRel15() = p("(a * b) \>= c") is geq;
public test bool testRel16() = p("(a \>= b)") is geq;

public test bool testRel17() = p("a * b == c") is eq;
public test bool testRel18() = p("a == b + c") is eq;
public test bool testRel19() = p("(a * b) == c") is eq;
public test bool testRel20() = p("(a == b)") is eq;

public test bool testRel21() = p("a * b != c") is neq;
public test bool testRel22() = p("a != b + c") is neq;
public test bool testRel23() = p("(a * b) != c") is neq;
public test bool testRel24() = p("(a != b)") is neq;

public test bool testBoolOperator1() = p("a * b && c") is and;
public test bool testBoolOperator2() = p("(a * b) && c") is and;
public test bool testBoolOperator3() = p("(a && b)") is and;
public test bool testBoolOperator4() = p("a && b") is and;

public test bool testBoolOperator5() = p("a * b || c") is or;
public test bool testBoolOperator6() = p("(a * b) || c") is or;
public test bool testBoolOperator7() = p("(a || b)") is or;
public test bool testBoolOperator8() = p("a || b") is or;
