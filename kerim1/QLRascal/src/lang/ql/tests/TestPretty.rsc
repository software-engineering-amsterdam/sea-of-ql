module lang::ql::tests::TestPretty

import lang::ql::generator::Pretty;
import lang::ql::util::Implode;

loc testFile1 = |project://QLRascal/src/lang/ql/tests/ql/Box1HouseOwning.q|;
loc testFile2 = |project://QLRascal/src/lang/ql/tests/ql/IncorrectExpressions.q|;
loc testFile3 = |project://QLRascal/src/lang/ql/tests/ql/IncorrectQuestions.q|;

public test bool testFile1() = 
	load(testFile1) == load(pretty(load(testFile1)));
	
public test bool testFile2() = 
	load(testFile2) == load(pretty(load(testFile2)));
	
public test bool testFile3() = 
	load(testFile3) == load(pretty(load(testFile3)));