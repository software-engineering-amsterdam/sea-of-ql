package org.uva.sea.ql.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.test.common.CurrentTest;

public class TestExpressions {

	public TestExpressions() {
		CurrentTest.setParser(new ANTLRParser());
	}

	@Test
	public void testDummy() {
		assertNotNull(this);
	}
}
