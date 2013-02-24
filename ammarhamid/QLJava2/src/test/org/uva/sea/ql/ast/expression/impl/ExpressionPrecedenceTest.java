package org.uva.sea.ql.ast.expression.impl;

import org.junit.Test;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.impl.ANTLRParser;
import org.uva.sea.ql.type.impl.IntegerType;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		assertTrue(IdentifierNode.class.isAssignableFrom(this.parser.parseExpr("a").getClass()));
        assertTrue(IdentifierNode.class.isAssignableFrom(this.parser.parseExpr("abc").getClass()));
        assertTrue(IdentifierNode.class.isAssignableFrom(this.parser.parseExpr("ABC").getClass()));
        assertTrue(IdentifierNode.class.isAssignableFrom(this.parser.parseExpr("ABCDEF").getClass()));
        assertTrue(IdentifierNode.class.isAssignableFrom(this.parser.parseExpr("abc2323").getClass()));
        assertTrue(IdentifierNode.class.isAssignableFrom(this.parser.parseExpr("a2bc232").getClass()));
        assertTrue(IdentifierNode.class.isAssignableFrom(this.parser.parseExpr("a2bc232aa").getClass()));
	}

	@Test
	public void testNums() throws ParseException
	{
		assertEquals(IntegerType.class, this.parser.parseExpr("0").getType().getClass());
		assertEquals(IntegerType.class, this.parser.parseExpr("1223").getType().getClass());
		assertEquals(IntegerType.class, this.parser.parseExpr("234234234").getType().getClass());
	}

}
