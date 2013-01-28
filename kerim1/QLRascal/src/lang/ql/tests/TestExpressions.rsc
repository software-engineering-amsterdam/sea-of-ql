module lang::ql::tests::TestExpressions

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::util::Parse;

private Expr p(str src) = implode(#Expr, parseExpr(src));

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
public test bool testSub2() = p("a - b - c") is sub;
public test bool testSub3() = p("(a - b - c)") is sub;
public test bool testSub4() = p("a - (b - c)") is sub;
public test bool testSub5() = p("(a - b) - c") is sub;
public test bool testSub6() = p("(a - b)") is sub;
public test bool testSub7() = p("a - b / c") is sub;
public test bool testSub8() = p("a / b - c") is sub;

public test bool testDiv1() = p("a / b") is div;
public test bool testDiv2() = p("a / b / c") is div;
public test bool testDiv3() = p("a / (b / c)") is div;
public test bool testDiv4() = p("(a / b) / c") is div;
public test bool testDiv5() = p("(a / b)") is div;
public test bool testDiv6() = p("(a - b) / c") is div;
public test bool testDiv7() = p("a / (b - c)") is div;

public test bool testPos1() = p("+1") is pos;
public test bool testPos2() = p("+234") is pos;
public test bool testPos3() = p("+(12 + 13)") is pos;
public test bool testPos4() = p("+(12 * 13)") is pos;

public test bool testNeg1() = p("-1") is neg;
public test bool testNeg2() = p("-234") is neg;
public test bool testNeg3() = p("-(12 - 13)") is neg;
public test bool testNeg4() = p("-(12 / 13)") is neg;

public test bool testNot1() = p("!true") is not;
public test bool testNot2() = p("!(1 \< 2)") is not;

public test bool testRel1() = p("a \< b") is lt;
public test bool testRel2() = p("a \< b + c") is lt;
public test bool testRel3() = p("a \< (b * c)") is lt;
public test bool testRel4() = p("(a * b) \< c") is lt;
public test bool testRel5() = p("(a \<= b)") is leq;
public test bool testRel6() = p("a + b \> c") is gt;
public test bool testRel7() = p("a \> b + c") is gt;
public test bool testRel8() = p("a \>= b + c") is geq;
public test bool testRel9() = p("a == b") is eq;
public test bool testRel10() = p("a == (b + c)") is eq;
public test bool testRel11() = p("a != b") is neq;
public test bool testRel12() = p("a != (b + c)") is neq;

public test bool testAnd1() = p("true && (1 \< 2)") is and;
public test bool testAnd2() = p("true && 1 \< 2") is and;
public test bool testAnd3() = p("(1 \> 2) && false") is and;
public test bool testAnd4() = p("1 \> 2 && false") is and;

public test bool testOr1() = p("true || (1 \< 2)") is or;
public test bool testOr2() = p("true || 1 \< 2") is or;
public test bool testOr3() = p("(1 \> 2) || false") is or;
public test bool testOr4() = p("1 \> 2 || false") is or;

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

public test bool testBool1() = p("true") is \bool;
public test bool testBool2() = p("false") is \bool;

public test bool testString1() = p("\"a\"") is string;
public test bool testString2() = p("\"abc\"") is string;
public test bool testString3() = p("\"abc2323\"") is string;
public test bool testString4() = p("\"a2bc 232\"") is string;
public test bool testString5() = p("\"a2bc 232aa 123abc\"") is string;
