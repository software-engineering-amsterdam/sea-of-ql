package org.uva.sea.ql.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.tests.parser.TestParser;
import org.uva.sea.ql.tests.semantic.TestForm;
import org.uva.sea.ql.tests.semantic.expression.TestBinary;
import org.uva.sea.ql.tests.semantic.expression.TestCombinations;
import org.uva.sea.ql.tests.semantic.expression.TestPrimary;
import org.uva.sea.ql.tests.semantic.expression.TestUnary;
import org.uva.sea.ql.tests.semantic.expression.TestValues;
import org.uva.sea.ql.tests.semantic.statement.TestIfThen;
import org.uva.sea.ql.tests.semantic.statement.TestIfThenElse;
import org.uva.sea.ql.tests.semantic.statement.TestQuestion;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestParser.class, 

	TestForm.class,
	
	TestBinary.class, 
	TestCombinations.class, 
	TestPrimary.class,
	TestUnary.class, 
	TestValues.class, 
	
	TestIfThen.class,
	TestIfThenElse.class, 
	TestQuestion.class
})
public class AllTests {

}
