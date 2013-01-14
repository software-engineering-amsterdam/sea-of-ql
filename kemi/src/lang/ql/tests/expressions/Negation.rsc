module lang::ql::tests::expressions::Negation

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testNot1() = parse("!a") is not;
public test bool testNot2() = parse("!(a && b)") is not;
public test bool testNot4() = parse("!(!a && !b)") is not;
