package org.uva.sea.ql.parser.test.expr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class Unaries {

	private IParse parser;

	public Unaries() {
		this.parser = new Parser();
	}

	@Test
	public void negatives() throws ParseError {
		assertEquals(Neg.class, parser.parse("-a").getClass());
		assertEquals(Neg.class, parser.parse("-123.50").getClass());
		assertEquals(Neg.class, parser.parse("-10").getClass());
	}

	@Test
	public void positives() throws ParseError {
		assertEquals(Pos.class, parser.parse("+a").getClass());
		assertEquals(Pos.class, parser.parse("+123.50").getClass());
		assertEquals(Pos.class, parser.parse("+10").getClass());
	}

	@Test
	public void nots() throws ParseError {
		assertEquals(Not.class, parser.parse("!a").getClass());
	}

}
