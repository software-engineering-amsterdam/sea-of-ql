module lang::ql::tests::expressions::Negation

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import util::Random;

public test bool testNot1() = parseExpr("!a") is not;
public test bool testNot2() = parseExpr("!(a && b)") is not;
public test bool testNot4() = parseExpr("!(!a && !b)") is not;

public test bool testRandomNot() = parseExpr("!<randomWord()>") is not;
