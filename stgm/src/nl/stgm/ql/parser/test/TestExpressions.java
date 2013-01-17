package nl.stgm.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import nl.stgm.ql.ast.Add;
import nl.stgm.ql.ast.Sub;
import nl.stgm.ql.ast.And;
import nl.stgm.ql.ast.GT;
import nl.stgm.ql.ast.Ident;
import nl.stgm.ql.ast.Int;
import nl.stgm.ql.ast.LEq;
import nl.stgm.ql.ast.LT;
import nl.stgm.ql.ast.Mul;
import nl.stgm.ql.ast.Not;

import nl.stgm.ql.parser.rats.RatsParser;

public class TestExpressions
{
	private IParse parser;

	public TestExpressions()
	{
		this.parser = new RatsParser();
	}

	@Test public void testAdds() throws ParseError
	{
		assertEquals(parser.parse("a + b").getClass(), Add.class);
		assertEquals(parser.parse("a + b + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parse("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parse("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b)").getClass(), Add.class);
		assertEquals(parser.parse("a + b * c").getClass(), Add.class);
		assertEquals(parser.parse("a * b + c").getClass(), Add.class);
	}

	@Test public void testSubs() throws ParseError
	{
		assertEquals(parser.parse("a - b").getClass(), Sub.class);
		assertEquals(parser.parse("a - b - c").getClass(), Sub.class);
		assertEquals(parser.parse("(a - b - c)").getClass(), Sub.class);
		assertEquals(parser.parse("a - (b + c)").getClass(), Sub.class);
		assertEquals(parser.parse("(a + b) - c").getClass(), Sub.class);
		assertEquals(parser.parse("(a - b)").getClass(), Sub.class);
		assertEquals(parser.parse("a - b * c").getClass(), Sub.class);
		assertEquals(parser.parse("a * b - c").getClass(), Sub.class);
	}

	@Test public void testMuls() throws ParseError
	{
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}

	@Test public void testRels() throws ParseError
	{
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
	}

	@Test public void testBools() throws ParseError
	{
		assertEquals(parser.parse("!b").getClass(), Not.class);
		assertEquals(parser.parse("a && b").getClass(), And.class);
		assertEquals(parser.parse("a > b && b > c").getClass(), And.class);
		assertEquals(parser.parse("(a > b) && (b > c)").getClass(), And.class);
	}


	@Test public void testIds() throws ParseError
	{
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("ABC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	@Test public void testNums() throws ParseError
	{
		assertEquals(parser.parse("0").getClass(), Int.class);
		assertEquals(parser.parse("1223").getClass(), Int.class);
		assertEquals(parser.parse("234234234").getClass(), Int.class);
	}	
}
