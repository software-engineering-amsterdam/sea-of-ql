module lang::ql::tests::TestExpressions

import lang::ql::ast::AST;
import lang::ql::util::Implode;


public test bool testAdd1() = loadExpr("a + b") is add;
public test bool testAdd2() = loadExpr("a + b + c") is add;
public test bool testAdd3() = loadExpr("(a + b + c)") is add;
public test bool testAdd4() = loadExpr("a + (b + c)") is add;
public test bool testAdd5() = loadExpr("(a + b) + c") is add;
public test bool testAdd6() = loadExpr("(a + b)") is add;
public test bool testAdd7() = loadExpr("a + b * c") is add;
public test bool testAdd8() = loadExpr("a * b + c") is add;


public test bool testMul1() = loadExpr("a * b") is mul;
public test bool testMul2() = loadExpr("a * b * c") is mul;
public test bool testMul3() = loadExpr("a * (b * c)") is mul;
public test bool testMul4() = loadExpr("(a * b) * c") is mul;
public test bool testMul5() = loadExpr("(a * b)") is mul;
public test bool testMul6() = loadExpr("(a + b) * c") is mul;
public test bool testMul7() = loadExpr("a * (b + c)") is mul; 

public test bool testRel1() = loadExpr("a \< b") is lt;
public test bool testRel2() = loadExpr("a \< b + c") is lt;
public test bool testRel3() = loadExpr("a \< (b * c)") is lt;
public test bool testRel4() = loadExpr("(a * b) \< c") is lt;
public test bool testRel5() = loadExpr("(a \<= b)") is leq;
public test bool testRel6() = loadExpr("a + b \> c") is gt;
public test bool testRel7() = loadExpr("a \> b + c") is gt;


public test bool testIdent1() = loadExpr("a") is ident;
public test bool testIdent2() = loadExpr("abc") is ident;
public test bool testIdent3() = loadExpr("ABC") is ident;
public test bool testIdent4() = loadExpr("ABCDEF") is ident;
public test bool testIdent5() = loadExpr("abc2323") is ident;
public test bool testIdent6() = loadExpr("a2bc232") is ident;
public test bool testIdent7() = loadExpr("a2bc232aa") is ident;
public test bool testInt1() = loadExpr("0") is \intConst;
public test bool testInt2() = loadExpr("1223") is \intConst;
public test bool testInt3() = loadExpr("234234234") is \intConst;


