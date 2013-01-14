module lang::ql::tests::expressions::Positive

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

public test bool testPos1() = parseExpr("+0") is pos;
public test bool testPos2() = parseExpr("+1223") is pos;
public test bool testPos3() = parseExpr("+234234234") is pos;
public test bool testPos4() = parseExpr("+(1223 - 10)") is pos;
