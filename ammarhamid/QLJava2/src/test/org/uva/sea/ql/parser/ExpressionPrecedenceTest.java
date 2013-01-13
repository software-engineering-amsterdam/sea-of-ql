package org.uva.sea.ql.parser;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.parser.impl.ANTLRParser;

@RunWith(Parameterized.class)
public class ExpressionPrecedenceTest
{
	private IParser parser;

	@Parameters
	public static List<Object[]> theParsers()
	{
		final List<Object[]> parsers = new ArrayList<Object[]>();
		parsers.add(new Object[] { new ANTLRParser() });
		return parsers;
	}

	public ExpressionPrecedenceTest(IParser parser)
	{
		this.parser = parser;
	}

	@Test
	public void testAdds() throws ParseException
	{
		assertEquals(Add.class, this.parser.parseExpr("a + b").getClass());
		assertEquals(Add.class, this.parser.parseExpr("a + b + c").getClass());
		assertEquals(Add.class, this.parser.parseExpr("(a + b + c)").getClass());
		assertEquals(Add.class, this.parser.parseExpr("a + (b + c)").getClass());
		assertEquals(Add.class, this.parser.parseExpr("(a + b) + c").getClass());
		assertEquals(Add.class, this.parser.parseExpr("(a + b)").getClass());
		assertEquals(Add.class, this.parser.parseExpr("a + b * c").getClass());
		assertEquals(Add.class, this.parser.parseExpr("a * b + c").getClass());
	}

	@Test
	public void testMuls() throws ParseException
	{
		assertEquals(Mul.class, this.parser.parseExpr("a * b").getClass());
		assertEquals(Mul.class, this.parser.parseExpr("a * b * c").getClass());
		assertEquals(Mul.class, this.parser.parseExpr("a * (b * c)").getClass());
		assertEquals(Mul.class, this.parser.parseExpr("(a * b) * c").getClass());
		assertEquals(Mul.class, this.parser.parseExpr("(a * b)").getClass());
		assertEquals(Mul.class, this.parser.parseExpr("(a + b) * c").getClass());
		assertEquals(Mul.class, this.parser.parseExpr("a * (b + c)").getClass());
	}

	@Test
	public void testRels() throws ParseException
	{
		assertEquals(LT.class, this.parser.parseExpr("a < b").getClass());
		assertEquals(LT.class, this.parser.parseExpr("a < b + c").getClass());
		assertEquals(LT.class, this.parser.parseExpr("a < (b * c)").getClass());
		assertEquals(LT.class, this.parser.parseExpr("(a * b) < c").getClass());
		assertEquals(LEq.class, this.parser.parseExpr("(a <= b)").getClass());
		assertEquals(GT.class, this.parser.parseExpr("a + b > c").getClass());
		assertEquals(GT.class, this.parser.parseExpr("a > b + c").getClass());
	}

	@Test
	public void testIds() throws ParseException
	{
		assertEquals(Ident.class, this.parser.parseExpr("a").getClass());
		assertEquals(Ident.class, this.parser.parseExpr("abc").getClass());
		assertEquals(Ident.class, this.parser.parseExpr("ABC").getClass());
		assertEquals(Ident.class, this.parser.parseExpr("ABCDEF").getClass());
		assertEquals(Ident.class, this.parser.parseExpr("abc2323").getClass());
		assertEquals(Ident.class, this.parser.parseExpr("a2bc232").getClass());
		assertEquals(Ident.class, this.parser.parseExpr("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseException
	{
		assertEquals(Int.class, this.parser.parseExpr("0").getClass());
		assertEquals(Int.class, this.parser.parseExpr("1223").getClass());
		assertEquals(Int.class, this.parser.parseExpr("234234234").getClass());
	}

}
