package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;

public class TestExprEval extends TestCase {

	static final private IParse parser = new ANTLRParser();

	@Test
	public void testExprEval() throws Exception {
		try {
			assertEquals(parser.expr("10 + 10").eval(null).getValue(), 10 + 10);
			assertEquals(parser.expr("10 + 11").eval(null).getValue(), 10 + 11);
			assertEquals(parser.expr("10 + 100").eval(null).getValue(),
					10 + 100);
			assertEquals(parser.expr("10 + 100").eval(null).getValue(),
					10 + 100);
			assertEquals(parser.expr("10 + 100 * 100 + 10 ").eval(null)
					.getValue(), 10020);
		} catch (Exception e) {
			System.out.println("try catch");
			e.printStackTrace();
			throw e;
		}
	}
}
