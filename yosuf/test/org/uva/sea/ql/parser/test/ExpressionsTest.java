package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.IntegerLiteral;
import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.GreaterOrEquals;
import org.uva.sea.ql.ast.exp.GreaterThan;
import org.uva.sea.ql.ast.exp.Multiply;
import org.uva.sea.ql.ast.exp.Negative;
import org.uva.sea.ql.ast.exp.Not;
import org.uva.sea.ql.ast.exp.Or;
import org.uva.sea.ql.ast.exp.Positive;
import org.uva.sea.ql.ast.exp.SmallerOrEquals;
import org.uva.sea.ql.ast.exp.SmallerThan;
import org.uva.sea.ql.ast.exp.Substitute;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;

public class ExpressionsTest {
	private IParse parser;

	@Before
	public void setUp() {
		parser = new JACCParser();
	}

	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parse("a + b").getClass(), Add.class);
		assertEquals(parser.parse("a + b + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parse("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parse("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b)").getClass(), Add.class);
		assertEquals(parser.parse("a + b * c").getClass(), Add.class);
		assertEquals(parser.parse("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parse("a * b").getClass(), Multiply.class);
		assertEquals(parser.parse("a * b * c").getClass(), Multiply.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Multiply.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Multiply.class);
		assertEquals(parser.parse("(a * b)").getClass(), Multiply.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Multiply.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Multiply.class);
	}

	@Test
	public void testDevide() throws ParseError {
		assertEquals(parser.parse("a / b").getClass(), Divide.class);
		assertEquals(parser.parse("a / b / c").getClass(), Divide.class);
		assertEquals(parser.parse("a / (b + c)").getClass(), Divide.class);
	}

	@Test
	public void testMinus() throws ParseError {
		assertEquals(parser.parse("a - b").getClass(), Substitute.class);
		assertEquals(parser.parse("a - b / c").getClass(), Substitute.class);
		assertEquals(parser.parse("a - (b + c)").getClass(), Substitute.class);
	}

	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), SmallerThan.class);
		assertEquals(parser.parse("a < b + c").getClass(), SmallerThan.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), SmallerThan.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), SmallerThan.class);
		assertEquals(parser.parse("(a <= b)").getClass(), SmallerOrEquals.class);
		assertEquals(parser.parse("a + b > c").getClass(), GreaterThan.class);
		assertEquals(parser.parse("a > b + c").getClass(), GreaterThan.class);
	}

	@Test
	public void testBools() throws ParseError {
		assertEquals(parser.parse("!b").getClass(), Not.class);
		assertEquals(parser.parse("a && b").getClass(), And.class);
		assertEquals(parser.parse("a > b && b > c").getClass(), And.class);
		assertEquals(parser.parse("(a > b) && (b > c)").getClass(), And.class);
		assertEquals(parser.parse("a || b").getClass(), Or.class);
		assertEquals(parser.parse("(a || b)").getClass(), Or.class);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Identifier.class);
		assertEquals(parser.parse("abc").getClass(), Identifier.class);
		assertEquals(parser.parse("ABC").getClass(), Identifier.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Identifier.class);
		assertEquals(parser.parse("abc2323").getClass(), Identifier.class);
		assertEquals(parser.parse("a2bc232").getClass(), Identifier.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Identifier.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), IntegerLiteral.class);
		assertEquals(parser.parse("1223").getClass(), IntegerLiteral.class);
		assertEquals(parser.parse("234234234").getClass(), IntegerLiteral.class);
	}

	@Test
	public void testGreaterOrEquals() throws ParseError {
		assertEquals(parser.parse("a >= b").getClass(), GreaterOrEquals.class);
		assertEquals(parser.parse("(a >= b)").getClass(), GreaterOrEquals.class);
		assertEquals(parser.parse("(a) >= (b*3)").getClass(),
				GreaterOrEquals.class);
	}

	@Test
	public void testEquals() throws ParseError {
		assertEquals(parser.parse("a == b").getClass(), Equals.class);
		assertEquals(parser.parse("(2 == 2)").getClass(), Equals.class);
	}

	@Test
	public void testUnaries() throws ParseError {
		assertEquals(parser.parse("!a").getClass(), Not.class);
		assertEquals(parser.parse("++a").getClass(), Positive.class);
		assertEquals(parser.parse("--a").getClass(), Negative.class);
	}
}
