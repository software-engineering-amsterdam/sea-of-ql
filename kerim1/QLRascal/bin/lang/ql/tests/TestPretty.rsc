module lang::ql::tests::TestPretty

import lang::ql::ast::Pretty;
import lang::ql::util::Implode;

loc testFile = |project://QLRascal/src/lang/ql/tests/test.q|;

public test bool testFile() = load(testFile) == load(pretty(load(testFile)));