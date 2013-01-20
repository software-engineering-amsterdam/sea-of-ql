package nl.stgm.ql.parser.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.RatsParser;
import nl.stgm.ql.ast.expr.*;

public class TestExpressions
{
	private IParse parser;

	public TestExpressions()
	{
		this.parser = new RatsParser();
	}

	@Test public void testAdds() throws ParseError
	{
		assertEquals(parser.parseExpr("a + b").getClass(), Add.class);
		assertEquals(parser.parseExpr("a + b + c").getClass(), Add.class);
		assertEquals(parser.parseExpr("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpr("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpr("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parseExpr("(a + b)").getClass(), Add.class);
		assertEquals(parser.parseExpr("a + b * c").getClass(), Add.class);
		assertEquals(parser.parseExpr("a * b + c").getClass(), Add.class);
	}

	@Test public void testSubs() throws ParseError
	{
		assertEquals(parser.parseExpr("a - b").getClass(), Sub.class);
		assertEquals(parser.parseExpr("a - b - c").getClass(), Sub.class);
		assertEquals(parser.parseExpr("(a - b - c)").getClass(), Sub.class);
		assertEquals(parser.parseExpr("a - (b + c)").getClass(), Sub.class);
		assertEquals(parser.parseExpr("(a + b) - c").getClass(), Sub.class);
		assertEquals(parser.parseExpr("(a - b)").getClass(), Sub.class);
		assertEquals(parser.parseExpr("a - b * c").getClass(), Sub.class);
		assertEquals(parser.parseExpr("a * b - c").getClass(), Sub.class);
	}

	@Test public void testMuls() throws ParseError
	{
		assertEquals(parser.parseExpr("a * b").getClass(), Mul.class);
		assertEquals(parser.parseExpr("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parseExpr("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parseExpr("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpr("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parseExpr("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpr("a * (b + c)").getClass(), Mul.class);
	}

	@Test public void testRels() throws ParseError
	{
		assertEquals(parser.parseExpr("a < b").getClass(), LT.class);
		assertEquals(parser.parseExpr("a < b + c").getClass(), LT.class);
		assertEquals(parser.parseExpr("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parseExpr("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parseExpr("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parseExpr("a + b > c").getClass(), GT.class);
		assertEquals(parser.parseExpr("a > b + c").getClass(), GT.class);
	}

	@Test public void testBools() throws ParseError
	{
		assertEquals(parser.parseExpr("!b").getClass(), Not.class);
		assertEquals(parser.parseExpr("a && b").getClass(), And.class);
		assertEquals(parser.parseExpr("a > b && b > c").getClass(), And.class);
		assertEquals(parser.parseExpr("(a > b) && (b > c)").getClass(), And.class);
	}


	@Test public void testIds() throws ParseError
	{
		assertEquals(parser.parseExpr("a").getClass(), Ident.class);
		assertEquals(parser.parseExpr("abc").getClass(), Ident.class);
		assertEquals(parser.parseExpr("ABC").getClass(), Ident.class);
		assertEquals(parser.parseExpr("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parseExpr("abc2323").getClass(), Ident.class);
		assertEquals(parser.parseExpr("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parseExpr("a2bc232aa").getClass(), Ident.class);
	}

	@Test public void testNums() throws ParseError
	{
		assertEquals(parser.parseExpr("0").getClass(), Int.class);
		assertEquals(parser.parseExpr("1223").getClass(), Int.class);
		assertEquals(parser.parseExpr("234234234").getClass(), Int.class);
	}	
}
