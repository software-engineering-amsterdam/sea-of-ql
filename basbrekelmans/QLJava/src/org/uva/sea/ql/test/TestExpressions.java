package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.Addition;
import org.uva.sea.ql.ast.expressions.GreaterThan;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.IntegerLiteral;
import org.uva.sea.ql.ast.expressions.LessThan;
import org.uva.sea.ql.ast.expressions.LessThanOrEquals;
import org.uva.sea.ql.ast.expressions.MoneyLiteral;
import org.uva.sea.ql.ast.expressions.Multiplication;
import org.uva.sea.ql.ast.expressions.Subtraction;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.JACCParser;

public class TestExpressions {

	private final IParser parser;

	public TestExpressions() {
		this.parser = new JACCParser();
	}

	@Test
	public void testAdds() {
		assertEquals(this.parser.parse("a + b").getClass(), Addition.class);
		assertEquals(this.parser.parse("a + b + c").getClass(), Addition.class);
		assertEquals(this.parser.parse("(a + b + c)").getClass(),
				Addition.class);
		assertEquals(this.parser.parse("a + (b + c)").getClass(),
				Addition.class);
		assertEquals(this.parser.parse("(a + b) + c").getClass(),
				Addition.class);
		assertEquals(this.parser.parse("(a + b)").getClass(), Addition.class);
		assertEquals(this.parser.parse("a + b * c").getClass(), Addition.class);
		assertEquals(this.parser.parse("a * b + c").getClass(), Addition.class);
		assertEquals(this.parser.parse("1+1").getClass(), Addition.class);
	}

	@Test
	public void testIds() {
		assertEquals(this.parser.parse("a").getClass(), Identifier.class);
		assertEquals(this.parser.parse("abc").getClass(), Identifier.class);
		assertEquals(this.parser.parse("ABC").getClass(), Identifier.class);
		assertEquals(this.parser.parse("ABCDEF").getClass(), Identifier.class);
		assertEquals(this.parser.parse("abc2323").getClass(), Identifier.class);
		assertEquals(this.parser.parse("a2bc232").getClass(), Identifier.class);
		assertEquals(this.parser.parse("a2bc232aa").getClass(),
				Identifier.class);
		assertEquals(this.parser.parse("___a2bc232").getClass(),
				Identifier.class);
		assertEquals(this.parser.parse("___a2bc232aa").getClass(),
				Identifier.class);
		assertEquals(this.parser.parse("_a2bc232").getClass(), Identifier.class);
		assertEquals(this.parser.parse("_").getClass(), Identifier.class);
	}

	@Test
	public void testMuls() {
		assertEquals(this.parser.parse("a * b").getClass(),
				Multiplication.class);
		assertEquals(this.parser.parse("a * b * c").getClass(),
				Multiplication.class);
		assertEquals(this.parser.parse("a * (b * c)").getClass(),
				Multiplication.class);
		assertEquals(this.parser.parse("(a * b) * c").getClass(),
				Multiplication.class);
		assertEquals(this.parser.parse("(a * b)").getClass(),
				Multiplication.class);
		assertEquals(this.parser.parse("(a + b) * c").getClass(),
				Multiplication.class);
		assertEquals(this.parser.parse("a * (b + c)").getClass(),
				Multiplication.class);
	}

	@Test
	public void testNumbers() {
		assertEquals(this.parser.parse("3.14E10").getClass(),
				MoneyLiteral.class);
		assertEquals(this.parser.parse("3.44E-10").getClass(),
				MoneyLiteral.class);
		assertEquals(this.parser.parse("5.14E+20").getClass(),
				MoneyLiteral.class);
		assertEquals(
				this.parser
						.parse("3511111111111111111111111111111111111111111111111111112222211111111111111111111111111111111111111111")
						.getClass(), MoneyLiteral.class);
		assertEquals(this.parser.parse("5.0").getClass(), MoneyLiteral.class);
		assertEquals(
				this.parser.parse(new Long(Long.MAX_VALUE).toString() + "1")
						.getClass(), MoneyLiteral.class);
		assertEquals(this.parser.parse("5").getClass(), IntegerLiteral.class);
		assertEquals(this.parser.parse("4123213").getClass(),
				IntegerLiteral.class);
	}

	@Test
	public void testNums() {
		assertEquals(this.parser.parse("0").getClass(), IntegerLiteral.class);
		assertEquals(this.parser.parse("1223").getClass(), IntegerLiteral.class);
		assertEquals(this.parser.parse("234234234").getClass(),
				IntegerLiteral.class);
	}

	@Test
	public void testRels() {
		assertEquals(this.parser.parse("a < b").getClass(), LessThan.class);
		assertEquals(this.parser.parse("a < b + c").getClass(), LessThan.class);
		assertEquals(this.parser.parse("a < (b * c)").getClass(),
				LessThan.class);
		assertEquals(this.parser.parse("(a * b) < c").getClass(),
				LessThan.class);
		assertEquals(this.parser.parse("(a <= b)").getClass(),
				LessThanOrEquals.class);
		assertEquals(this.parser.parse("a + b > c").getClass(),
				GreaterThan.class);
		assertEquals(this.parser.parse("a > b + c").getClass(),
				GreaterThan.class);
	}

	@Test
	public void testSubs() {
		assertEquals(this.parser.parse("a - b").getClass(), Subtraction.class);
		assertEquals(this.parser.parse("a - b - c").getClass(),
				Subtraction.class);
		assertEquals(this.parser.parse("(a - b - c)").getClass(),
				Subtraction.class);
		assertEquals(this.parser.parse("a - (b - c)").getClass(),
				Subtraction.class);
		assertEquals(this.parser.parse("(a - b) - c").getClass(),
				Subtraction.class);
		assertEquals(this.parser.parse("(a - b)").getClass(), Subtraction.class);
		assertEquals(this.parser.parse("a - b * c").getClass(),
				Subtraction.class);
		assertEquals(this.parser.parse("a * b - c").getClass(),
				Subtraction.class);
		assertEquals(this.parser.parse("1-1").getClass(), Subtraction.class);
	}

}
