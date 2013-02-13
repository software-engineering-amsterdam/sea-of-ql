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
import org.uva.sea.ql.tests.semantic.statement.TestIfThenElse;
import org.uva.sea.ql.tests.semantic.statement.TestQuestion;

@RunWith(Suite.class)
@SuiteClasses({ TestParser.class, TestBinary.class, TestPrimary.class,
		TestUnary.class, TestCombinations.class, TestForm.class,
		TestQuestion.class, TestIfThenElse.class })
public class AllTests {

}
