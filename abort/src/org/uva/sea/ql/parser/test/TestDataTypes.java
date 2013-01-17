package org.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StringLiteral;

public class TestDataTypes extends TestBase {
	@Test
	public void testSingleLineComment() throws RecognitionException {
		assertNull(parseDataType("// this is a comment\n"));
		assertNull(parseDataType("// this is a comment\r"));
		assertNotNull(parseDataType("// this is a comment\n1"));
		assertNotNull(parseDataType("// this is a comment\r1"));
	}
	
	@Test
	public void testMultilineComment() throws RecognitionException {
		assertNull(parseDataType("/* blabla\nhahaha\rqweqweq */"));
		assertNotNull(parseDataType("/* blabla\nhahaha\rqweqweq */1"));
	}
	
	@Test
	public void testInt() throws RecognitionException {
		assertEquals(Int.class, parseDataType("0").getClass());
		assertEquals(Int.class, parseDataType("1223").getClass());
		assertEquals(Int.class, parseDataType("234234234").getClass());
	}
	
	@Test
	public void testMoney() throws RecognitionException {
		assertEquals(parseDataType("0.000").getClass(), Money.class);
		assertEquals(parseDataType("1.234").getClass(), Money.class);
		assertEquals(parseDataType("1932.123214141").getClass(), Money.class);
	}

	@Test
	public void testStringLiterals() throws RecognitionException {
		assertEquals(StringLiteral.class, parseDataType("\"Hello\"").getClass());
		assertEquals("Hello", ((StringLiteral)parseDataType("\"Hello\"")).getValue());
		assertEquals("\\\"Hello\\\"", ((StringLiteral)parseDataType("\"\\\"Hello\\\"\"")).getValue());
		assertFalse(StringLiteral.class.equals(parseDataType("Hello").getClass()));
	}
	
	private Node parseDataType(final String source) throws RecognitionException {
		return parse(source).orExpression();
	}
}
