package org.uva.sea.ql.run;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.test.TestAssignments;
import org.uva.sea.ql.test.TestComparisons;
import org.uva.sea.ql.test.TestFields;
import org.uva.sea.ql.test.TestLogical;
import org.uva.sea.ql.test.TestMath;
import org.uva.sea.ql.test.TestValidator;

@RunWith(Suite.class)
@SuiteClasses({ TestComparisons.class, TestFields.class,
		TestLogical.class, TestMath.class, TestAssignments.class, TestValidator.class })
final class TestRunner {
    public TestRunner(){
        
    }
}
