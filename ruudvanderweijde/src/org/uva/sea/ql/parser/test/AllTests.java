package org.uva.sea.ql.parser.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.parser.test.tests.TestExprSemanticsBinary;
import org.uva.sea.ql.parser.test.tests.TestExprSemanticsPrimary;
import org.uva.sea.ql.parser.test.tests.TestExprSemanticsUnary;

@RunWith(Suite.class)
@SuiteClasses({ TestParser.class, TestExprSemanticsBinary.class,
		TestExprSemanticsPrimary.class, TestExprSemanticsUnary.class })
public class AllTests {

}
