package org.uva.sea.ql.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.GreaterOrEquals;
import org.uva.sea.ql.ast.exp.GreaterThan;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.exp.Multiply;
import org.uva.sea.ql.ast.exp.Negative;
import org.uva.sea.ql.ast.exp.Not;
import org.uva.sea.ql.ast.exp.Or;
import org.uva.sea.ql.ast.exp.Positive;
import org.uva.sea.ql.ast.exp.SmallerOrEquals;
import org.uva.sea.ql.ast.exp.SmallerThan;
import org.uva.sea.ql.ast.exp.Substitute;
import org.uva.sea.ql.ast.value.NumericValue;
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
		assertEquals(Add.class, parser.parse("a + b").getClass());
		assertEquals(Add.class, parser.parse("a + b + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b + c)").getClass());
		assertEquals(Add.class, parser.parse("a + (b + c)").getClass());
		assertEquals(Add.class, parser.parse("(a + b) + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b)").getClass());
		assertEquals(Add.class, parser.parse("a + b * c").getClass());
		assertEquals(Add.class, parser.parse("a * b + c").getClass());
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(Multiply.class, parser.parse("a * b").getClass());
		assertEquals(Multiply.class, parser.parse("a * b * c").getClass());
		assertEquals(Multiply.class, parser.parse("a * (b * c)").getClass());
		assertEquals(Multiply.class, parser.parse("(a * b) * c").getClass());
		assertEquals(Multiply.class, parser.parse("(a * b)").getClass());
		assertEquals(Multiply.class, parser.parse("(a + b) * c").getClass());
		assertEquals(Multiply.class, parser.parse("a * (b + c)").getClass());
	}

	@Test
	public void testDevide() throws ParseError {
		assertEquals(Divide.class, parser.parse("a / b").getClass());
		assertEquals(Divide.class, parser.parse("a / b / c").getClass());
		assertEquals(Divide.class, parser.parse("a / (b + c)").getClass());
	}

	@Test
	public void testMinus() throws ParseError {
		assertEquals(Substitute.class, parser.parse("a - b").getClass());
		assertEquals(Substitute.class, parser.parse("a - b / c").getClass());
		assertEquals(Substitute.class, parser.parse("a - (b + c)").getClass());
	}

	@Test
	public void testRels() throws ParseError {
		assertEquals(SmallerThan.class, parser.parse("a < b").getClass());
		assertEquals(SmallerThan.class, parser.parse("a < b + c").getClass());
		assertEquals(SmallerThan.class, parser.parse("a < (b * c)").getClass());
		assertEquals(SmallerThan.class, parser.parse("(a * b) < c").getClass());
		assertEquals(SmallerOrEquals.class, parser.parse("(a <= b)").getClass());
		assertEquals(GreaterThan.class, parser.parse("a + b > c").getClass());
		assertEquals(GreaterThan.class, parser.parse("a > b + c").getClass());
	}

	@Test
	public void testBools() throws ParseError {
		assertEquals(Not.class, parser.parse("!b").getClass());
		assertEquals(And.class, parser.parse("a && b").getClass());
		assertEquals(And.class, parser.parse("a > b && b > c").getClass());
		assertEquals(And.class, parser.parse("(a > b) && (b > c)").getClass());
		assertEquals(Or.class, parser.parse("a || b").getClass());
		assertEquals(Or.class, parser.parse("(a || b)").getClass());
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(Identifier.class, parser.parse("a").getClass());
		assertEquals(Identifier.class, parser.parse("abc").getClass());
		assertEquals(Identifier.class, parser.parse("ABC").getClass());
		assertEquals(Identifier.class, parser.parse("ABCDEF").getClass());
		assertEquals(Identifier.class, parser.parse("abc2323").getClass());
		assertEquals(Identifier.class, parser.parse("a2bc232").getClass());
		assertEquals(Identifier.class, parser.parse("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(NumericValue.class, parser.parse("0").getClass());
		assertEquals(NumericValue.class, parser.parse("1223").getClass());
		assertEquals(NumericValue.class, parser.parse("234234234").getClass());
	}

	@Test
	public void testGreaterOrEquals() throws ParseError {
		assertEquals(GreaterOrEquals.class, parser.parse("a >= b").getClass());
		assertEquals(GreaterOrEquals.class, parser.parse("(a >= b)").getClass());
		assertEquals(GreaterOrEquals.class, parser.parse("(a) >= (b*3)")
				.getClass());
	}

	@Test
	public void testEquals() throws ParseError {
		assertEquals(Equals.class, parser.parse("a == b").getClass());
		assertEquals(Equals.class, parser.parse("(2 == 2)").getClass());
	}

	@Test
	public void testUnaries() throws ParseError {
		assertEquals(Not.class, parser.parse("!a").getClass());
		assertEquals(Positive.class, parser.parse("++a").getClass());
		assertEquals(Negative.class, parser.parse("--a").getClass());
	}
}
