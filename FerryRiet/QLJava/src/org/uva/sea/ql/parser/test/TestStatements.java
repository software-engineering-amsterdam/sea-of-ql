package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.LineStatement;

public class TestStatements extends TestCase {

	static final private IParse parser = new ANTLRParser();

	@Test
	public void testStatements() throws ParseError {
		String s0 = "hasSoldHouse: \"Did you sell a house in 2010?\" boolean";
		String s1 = "hasSoldHouse: \"Did you sell a house in 2010?\" string";
		String s2 = "hasSoldHouse: \"Did you sell a house in 2010?\" money";
		String s3 = "hasSoldHouse: \"Did you sell a house in 2010?\" money (hasSoldHouse * 120)";

		String s4 = "if ( 10 > 20 ) { hasSoldHouse: \"Did you sell a house in 2010?\" money (hasSoldHouse * 120) }";
		String s5 = "if ( hasSoldHouse ) { hasSoldHouse: \"Did you sell a house in 2010?\" string }";
		String s6 = "if ( 10 ) { hasSoldHouse: \"Did you sell a house in 2010?\" boolean }";
		String s7 = "if ( hasSoldHouse < 10 ) { hasSoldHouse: \"Did you sell a house < 10?\""
				+ " money (hasSoldHouse * 120) } else { hasSoldHouse: \"Did you sell a house < 10?\""
				+ " money (hasSoldHouse < 120) }";

		assertEquals(parser.statement(s0).getClass(), LineStatement.class);
		assertEquals(parser.statement(s1).getClass(), LineStatement.class);
		assertEquals(parser.statement(s2).getClass(), LineStatement.class);
		assertEquals(parser.statement(s3).getClass(), LineStatement.class);

		assertEquals(parser.statement(s4).getClass(),
				ConditionalStatement.class);
		assertEquals(parser.statement(s5).getClass(),
				ConditionalStatement.class);
		assertEquals(parser.statement(s6).getClass(),
				ConditionalStatement.class);
		assertEquals(parser.statement(s7).getClass(),
				ConditionalStatement.class);

	}
}
