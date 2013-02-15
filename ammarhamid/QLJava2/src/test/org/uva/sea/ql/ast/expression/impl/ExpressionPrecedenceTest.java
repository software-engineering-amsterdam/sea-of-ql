package org.uva.sea.ql.ast.expression.impl;

import org.junit.Test;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.impl.ANTLRParser;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class ExpressionPrecedenceTest
{
	private final IParser parser;

	public ExpressionPrecedenceTest()
	{
		this.parser = new ANTLRParser();
	}

	@Test
	public void testAdds() throws ParseException
	{
		assertEquals(AddNode.class, this.parser.parseExpr("a + b").getClass());
		assertEquals(AddNode.class, this.parser.parseExpr("a + b + c").getClass());
		assertEquals(AddNode.class, this.parser.parseExpr("(a + b + c)").getClass());
		assertEquals(AddNode.class, this.parser.parseExpr("a + (b + c)").getClass());
		assertEquals(AddNode.class, this.parser.parseExpr("(a + b) + c").getClass());
		assertEquals(AddNode.class, this.parser.parseExpr("(a + b)").getClass());
		assertEquals(AddNode.class, this.parser.parseExpr("a + b * c").getClass());
		assertEquals(AddNode.class, this.parser.parseExpr("a * b + c").getClass());
	}

	@Test
	public void testMuls() throws ParseException
	{
		assertEquals(MultiplyNode.class, this.parser.parseExpr("a * b").getClass());
		assertEquals(MultiplyNode.class, this.parser.parseExpr("a * b * c").getClass());
		assertEquals(MultiplyNode.class, this.parser.parseExpr("a * (b * c)").getClass());
		assertEquals(MultiplyNode.class, this.parser.parseExpr("(a * b) * c").getClass());
		assertEquals(MultiplyNode.class, this.parser.parseExpr("(a * b)").getClass());
		assertEquals(MultiplyNode.class, this.parser.parseExpr("(a + b) * c").getClass());
		assertEquals(MultiplyNode.class, this.parser.parseExpr("a * (b + c)").getClass());
	}

	@Test
	public void testRels() throws ParseException
	{
		assertEquals(LessThanNode.class, this.parser.parseExpr("a < b").getClass());
		assertEquals(LessThanNode.class, this.parser.parseExpr("a < b + c").getClass());
		assertEquals(LessThanNode.class, this.parser.parseExpr("a < (b * c)").getClass());
		assertEquals(LessThanNode.class, this.parser.parseExpr("(a * b) < c").getClass());
		assertEquals(LessEqualNode.class, this.parser.parseExpr("(a <= b)").getClass());
		assertEquals(GreaterThanNode.class, this.parser.parseExpr("a + b > c").getClass());
		assertEquals(GreaterThanNode.class, this.parser.parseExpr("a > b + c").getClass());
	}

	@Test
	public void testIds() throws ParseException
	{
		assertEquals(IdentifierNode.class, this.parser.parseExpr("a").getClass());
		assertEquals(IdentifierNode.class, this.parser.parseExpr("abc").getClass());
		assertEquals(IdentifierNode.class, this.parser.parseExpr("ABC").getClass());
		assertEquals(IdentifierNode.class, this.parser.parseExpr("ABCDEF").getClass());
		assertEquals(IdentifierNode.class, this.parser.parseExpr("abc2323").getClass());
		assertEquals(IdentifierNode.class, this.parser.parseExpr("a2bc232").getClass());
		assertEquals(IdentifierNode.class, this.parser.parseExpr("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseException
	{
//		assertEquals(IntegerValue.class, this.parser.parseExpr("0").getClass());
//		assertEquals(IntegerValue.class, this.parser.parseExpr("1223").getClass());
//		assertEquals(IntegerValue.class, this.parser.parseExpr("234234234").getClass());
	}

}
