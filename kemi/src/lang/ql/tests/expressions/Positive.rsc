module lang::ql::tests::expressions::Positive

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testPos1() = parse("+0") is pos;
public test bool testPos2() = parse("+1223") is pos;
public test bool testPos3() = parse("+234234234") is pos;
public test bool testPos4() = parse("+(1223 - 10)") is pos;
