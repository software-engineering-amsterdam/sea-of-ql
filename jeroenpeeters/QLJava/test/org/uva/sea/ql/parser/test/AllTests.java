package org.uva.sea.ql.parser.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.value.ValuesTest;

@RunWith(Suite.class)
@SuiteClasses({ TestExpressions.class, TestStatements.class, TestForms.class, TestSemanticConsistency.class, TestTypeChecking.class, ValuesTest.class })
public class AllTests {

}
