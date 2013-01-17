module lang::ql::tests::GrammarTests::TestTypes

import lang::ql::syntax::QL;
import ParseTree;

public start[Type] parseType(str src) = parse(#start[Type], src, |file:///-|);

public test bool testBoolean() = parseType("boolean") is boolean;
public test bool testInteger() = parseType("integer") is integer;
public test bool testString() = parseType("string") is string;
public test bool testMoney() = parseType("money") is money;