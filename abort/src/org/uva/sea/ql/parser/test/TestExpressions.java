package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.operators.Add;
import org.uva.sea.ql.parser.antlr.operators.GT;
import org.uva.sea.ql.parser.antlr.operators.Int;
import org.uva.sea.ql.parser.antlr.operators.LEq;
import org.uva.sea.ql.parser.antlr.operators.LT;
import org.uva.sea.ql.parser.antlr.operators.Money;
import org.uva.sea.ql.parser.antlr.operators.Mul;
import org.uva.sea.ql.parser.antlr.operators.StringLiteral;

public class TestExpressions extends TestCase {
	private static final IParse parser = new ANTLRParser();

	
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
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("ABC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), Int.class);

		assertEquals(parser.parse("1223").getClass(), Int.class);
		assertEquals(parser.parse("234234234").getClass(), Int.class);
	}
	
	@Test
	public void testMoney() throws ParseError {
		assertEquals(parser.parse("0.000").getClass(), Money.class);

		assertEquals(parser.parse("1.234").getClass(), Money.class);
		assertEquals(parser.parse("1932.123214141").getClass(), Money.class);
	}
	
	@Test
	public void testSinglelineComments() throws ParseError {
		assertNull(parser.parse("// this is a comment\n"));
		assertEquals(Ident.class, parser.parse("// this is a comment\n this is not").getClass());
		assertEquals(Ident.class, parser.parse("// this is a comment\r this is not").getClass());
	}
	
	@Test
	public void testStringLiterals() throws ParseError {
		assertEquals(StringLiteral.class, parser.parse("\"Hello\"").getClass());
		assertEquals("Hello", ((StringLiteral)parser.parse("\"Hello\"")).getValue());
		assertEquals(Ident.class, parser.parse("Hello").getClass());
	}
}
