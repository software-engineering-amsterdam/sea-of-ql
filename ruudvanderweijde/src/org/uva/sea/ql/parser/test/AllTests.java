package org.uva.sea.ql.parser.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.parser.test.tests.TestSemanticsBinary;
import org.uva.sea.ql.parser.test.tests.TestSemanticsPrimary;
import org.uva.sea.ql.parser.test.tests.TestSemanticsUnary;

@RunWith(Suite.class)
@SuiteClasses({ TestParser.class, TestSemanticsBinary.class,
		TestSemanticsPrimary.class, TestSemanticsUnary.class })
public class AllTests {

}
