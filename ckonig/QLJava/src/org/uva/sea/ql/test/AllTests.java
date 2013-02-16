package org.uva.sea.ql.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestComparisons.class, TestFields.class,
		TestLogical.class, TestMath.class, TestAssignments.class, TestValidator.class, TestHtmlGenerator.class })
public class AllTests {
    public AllTests(){
        
    }
}
