module lang::ql::tests::expressions::Boolean

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testBool1() = parse("true") is boolean;
public test bool testBool2() = parse("false") is boolean;
