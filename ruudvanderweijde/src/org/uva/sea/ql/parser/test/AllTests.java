package org.uva.sea.ql.parser.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.parser.test.parser.TestParser;
import org.uva.sea.ql.parser.test.semantic.expression.TestBinary;
import org.uva.sea.ql.parser.test.semantic.expression.TestCombinations;
import org.uva.sea.ql.parser.test.semantic.expression.TestPrimary;
import org.uva.sea.ql.parser.test.semantic.expression.TestUnary;
import org.uva.sea.ql.parser.test.semantic.statement.TestForm;
import org.uva.sea.ql.parser.test.semantic.statement.TestIfThenElse;
import org.uva.sea.ql.parser.test.semantic.statement.TestQuestion;

@RunWith(Suite.class)
@SuiteClasses({ TestParser.class, TestBinary.class, TestPrimary.class,
		TestUnary.class, TestCombinations.class, TestForm.class,
		TestQuestion.class, TestIfThenElse.class })
public class AllTests {

}
