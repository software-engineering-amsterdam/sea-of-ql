module lang::ql::tests::TestPretty

import lang::ql::generator::Pretty;
import lang::ql::util::Implode;

loc testFile = |project://QLRascal/src/lang/ql/tests/ql/Box1HouseOwning.q|;

public test bool testFile() = load(testFile) == load(pretty(load(testFile)));