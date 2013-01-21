module tests::ExpressionTests

import util::Parse;
import util::Implode;
import syntax::AbstractSyntax;
//import syntax::ConcreteSyntax;
import ParseTree;
import Prelude;

private Expression p(str src) = implodeExpression(parseExpression(src, |file:///test.q|));  // |file:///-|
//public start[Expression] parseExpressions(str src) = parse(#start[Expression], src,|file:///test.q|);


// Tests for addion
public test bool testAdd1() = p("a + b") is add;
public test bool testAdd2() = p("a + b + c") is add;
public test bool testAdd3() = p("(a + b + c)") is add;
public test bool testAdd4() = p("a + (b + c)") is add; 
public test bool testAdd5() = p("(a + b) + c") is add;
public test bool testAdd6() = p("(a + b)") is add;
// public test bool testAdd7() = p("(a + b) * c") is add;
// public test bool testAdd8() = p("a * b + c") is add;
// Tests for substraction
public test bool testSub1() = p("a - b") is sub;
public test bool testSub2() = p("a - b - c") is sub;
public test bool testSub3() = p("(a - b - c)") is sub;
public test bool testSub4() = p("a - (b - c)") is sub; 
public test bool testSub5() = p("(a - b) - c") is sub;
public test bool testSub6() = p("(a - b)") is sub;
// public test bool testSub7() = p("a - b * c") is sub;
// public test bool testSub8() = p("a * b - c") is sub; 
// Tests for multiplication
public test bool testMul1() = p("a * b") is mul;
public test bool testMul2() = p("a * b * c") is mul;
public test bool testMul3() = p("a * (b * c)") is mul;
public test bool testMul4() = p("(a * b) * c") is mul;
public test bool testMul5() = p("(a * b)") is mul;
public test bool testMul6() = p("(a + b) * c") is mul;
public test bool testMul7() = p("a * (b + c)") is mul;
// Tests for division
public test bool testDiv1() = p("a / b") is div;
public test bool testDiv2() = p("a / b / c") is div;
public test bool testDiv3() = p("a / (b / c)") is div;
public test bool testDiv4() = p("(a / b) / c") is div;
public test bool testDiv5() = p("(a / b)") is div;
public test bool testDiv6() = p("(a + b) / c") is div;
public test bool testDiv7() = p("a / (b + c)") is div;
// Tests for relations
public test bool testRel1() = p("a \< b") is lt;
public test bool testRel2() = p("a \< b + c") is lt;
public test bool testRel3() = p("a \< (b * c)") is lt;
public test bool testRel4() = p("(a * b) \< c") is lt;
public test bool testRel5() = p("(a \<= b)") is leq;
public test bool testRel6() = p("a + b \> c") is gt;
public test bool testRel7() = p("a \> b + c") is gt;
// Tests for identifications
public test bool testIdent1() = p("a") is id;
public test bool testIdent2() = p("abc") is id;
public test bool testIdent3() = p("ABC") is id;
public test bool testIdent4() = p("ABCDEF") is id;
public test bool testIdent5() = p("abc2323") is id;
public test bool testIdent6() = p("a2bc232") is id;
public test bool testIdent7() = p("a2bc232aa") is id;
public test bool testIdent8() = p("BoxOne") is id;
public test bool testIdent9() = p("hasSoldHouse") is id;
// Tests for Int
public test bool testInt1() = p("0") is \int;
public test bool testInt2() = p("1223") is \int;
public test bool testInt3() = p("234234234") is \int;
// Tests for bools
public test bool testBool1() = p("true") is boolCon;
public test bool testBool2() = p("false") is boolCon;
// Tests for money
public test bool testMoney1() = p("33,32") is moneyCon;
public test bool testMoney2() = p("0,01") is moneyCon;
public test bool testMoney3() = p("1000,99") is moneyCon;
// Test for keywords
// public test bool testKeyword() = p("if") is id;
//Tests for QuestionString
public test bool testString1() = p("\"How are you\"") is string;
public test bool testString2() = p("\"String with numbers 321\"") is string;
public test bool testString3() = p("\"String with specials : ?\"") is string;
