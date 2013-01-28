package org.uva.sea.ql.parser.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.parser.test.tests.TestExprSemanticsBinary;
import org.uva.sea.ql.parser.test.tests.TestExprSemanticsPrimary;
import org.uva.sea.ql.parser.test.tests.TestExprSemanticsUnary;
import org.uva.sea.ql.parser.test.tests.TestFormSemantics;
import org.uva.sea.ql.parser.test.tests.TestParser;

@RunWith(Suite.class)
@SuiteClasses({ TestParser.class, TestExprSemanticsBinary.class,
		TestExprSemanticsPrimary.class, TestExprSemanticsUnary.class, 
		TestFormSemantics.class })
public class AllTests {

}
