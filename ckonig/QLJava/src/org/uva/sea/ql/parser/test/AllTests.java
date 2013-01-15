package org.uva.sea.ql.parser.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestComparisons.class, TestExpressions.class, TestFields.class,
		TestLogical.class, TestMath.class })
public class AllTests {

}
