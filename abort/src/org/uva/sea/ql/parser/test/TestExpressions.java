package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.operators.Add;
import org.uva.sea.ql.parser.antlr.operators.Form;
import org.uva.sea.ql.parser.antlr.operators.GT;
import org.uva.sea.ql.parser.antlr.operators.If;
import org.uva.sea.ql.parser.antlr.operators.IfElse;
import org.uva.sea.ql.parser.antlr.operators.LEq;
import org.uva.sea.ql.parser.antlr.operators.LT;
import org.uva.sea.ql.parser.antlr.operators.Mul;
import org.uva.sea.ql.parser.antlr.types.Int;
import org.uva.sea.ql.parser.antlr.types.Money;
import org.uva.sea.ql.parser.antlr.types.StringLiteral;

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
		assertNull(parser.parse("//this is a comment\n0.11"));
		assertNull(parser.parse("//this is a comment\r0.11"));
		//assertNotNull(parser.parse("// this is a comment\na < b"));
	}
	
	@Test
	public void testMultilineComments() throws ParseError {
		assertNull(parser.parse("/* blabla\nhahaha\rqweqweq */0.011"));
	}
	
	@Test
	public void testStringLiterals() throws ParseError {
		assertEquals(StringLiteral.class, parser.parse("\"Hello\"").getClass());
		
		// TODO: repair these statements
		/*
		assertEquals("Hello", ((StringLiteral)parser.parse("\"Hello\"")).getValue());
		assertEquals("\\\"Hello\\\"", ((StringLiteral)parser.parse("\"\\\"Hello\\\"\"")).getValue());
		*/
		assertEquals(Ident.class, parser.parse("Hello").getClass());
	}
	
	@Test
	public void testIfElseExpression() throws ParseError {
		try {
			Expression result = parser.parse("if (\"Hello\") { \"Hello\" } else { \"Hello\" }");
			assertEquals(IfElse.class, result.getClass());
			
			// Invalid else statement
			assertNotSame(IfElse.class, parser.parse("if (\"Hello\") { \"Hello\" } else \"Hello\"").getClass());
		}
		catch (RuntimeException e) {
			throw new ParseError(e.getMessage());
		}		
	}
	
	@Test
	public void testIfExpression() throws ParseError {
		try {
			assertEquals(If.class, parser.parse("if (\"Hello\") { \"Hello\" }").getClass());			
		}
		catch (RuntimeException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	@Test
	public void testFormExpression() throws ParseError {
			assertEquals(Form.class, ((ANTLRParser)parser).parseForm(
					"form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean hasBoughtHouse: \"Did you buy a house in 2010?\" boolean }").getClass());
	}
}
