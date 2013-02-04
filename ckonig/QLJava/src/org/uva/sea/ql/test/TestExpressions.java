package org.uva.sea.ql.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.test.common.TestParser;

public class TestExpressions {
	protected TestParser parser;

	public TestExpressions() {
		this.parser = new TestParser(new ANTLRParser());
	}

	@Test
	public void testDummy() {
		assertNotNull(this);
	}
}
