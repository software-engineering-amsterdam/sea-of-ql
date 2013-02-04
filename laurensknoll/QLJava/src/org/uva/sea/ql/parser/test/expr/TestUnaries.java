package org.uva.sea.ql.parser.test.expr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestUnaries {

	private IParse parser;

	public TestUnaries() {
		this.parser = new Parser();
	}

	@Test
	public void testNegatives() throws ParseError {
		assertEquals(Neg.class, parser.parse("-a").getClass());
		assertEquals(Neg.class, parser.parse("-123.50").getClass());
		assertEquals(Neg.class, parser.parse("-10").getClass());
	}

	@Test
	public void testPositives() throws ParseError {
		assertEquals(Pos.class, parser.parse("+a").getClass());
		assertEquals(Pos.class, parser.parse("+123.50").getClass());
		assertEquals(Pos.class, parser.parse("+10").getClass());
	}

	@Test
	public void testNots() throws ParseError {
		assertEquals(Not.class, parser.parse("!a").getClass());
	}

}
