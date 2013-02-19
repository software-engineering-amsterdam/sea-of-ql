package org.uva.sea.ql.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.tests.parser.TestParser;
import org.uva.sea.ql.tests.type.TestForm;
import org.uva.sea.ql.tests.type.expression.TestBinary;
import org.uva.sea.ql.tests.type.expression.TestCombinations;
import org.uva.sea.ql.tests.type.expression.TestPrimary;
import org.uva.sea.ql.tests.type.expression.TestUnary;
import org.uva.sea.ql.tests.type.statement.TestIfThen;
import org.uva.sea.ql.tests.type.statement.TestIfThenElse;
import org.uva.sea.ql.tests.type.statement.TestQuestion;
import org.uva.sea.ql.tests.value.expression.TestValues;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestParser.class, 

	TestForm.class,
	
	TestBinary.class, 
	TestCombinations.class, 
	TestPrimary.class,
	TestUnary.class, 
	
	TestIfThen.class,
	TestIfThenElse.class, 
	TestQuestion.class,
	
	TestValues.class 
})
public class AllTests {
}