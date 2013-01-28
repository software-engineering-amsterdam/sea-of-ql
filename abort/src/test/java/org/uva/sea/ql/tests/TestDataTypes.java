package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Ident;
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
		
		assertEquals(0, ((Int)parseDataType("0")).getValue());
		assertEquals(1223, ((Int)parseDataType("1223")).getValue());
		assertEquals(234234234, ((Int)parseDataType("234234234")).getValue());
		
	}
	
	@Test
	public void testMoney() throws RecognitionException {
		assertEquals(Money.class, parseDataType("0.000").getClass());
		assertEquals(Money.class, parseDataType("1.234").getClass());
		assertEquals(Money.class, parseDataType("1932.123214141").getClass());
		
		assertEquals(new BigDecimal("0.000"), ((Money)parseDataType("0.000")).getValue());
		assertEquals(new BigDecimal("1.234"), ((Money)parseDataType("1.234")).getValue());
		assertEquals(new BigDecimal("1932.123214141"), ((Money)parseDataType("1932.123214141")).getValue());
	}
	
	@Test
	public void testBool() throws RecognitionException {
		assertEquals(Bool.class, parseDataType("true").getClass());
		assertEquals(Bool.class, parseDataType("TRUE").getClass());
		assertEquals(Bool.class, parseDataType("false").getClass());
		assertEquals(Bool.class, parseDataType("FALSE").getClass());
		
		assertEquals(true, ((Bool)parseDataType("true")).getValue());
		assertEquals(true, ((Bool)parseDataType("TRUE")).getValue());
		assertEquals(false, ((Bool)parseDataType("false")).getValue());
		assertEquals(false, ((Bool)parseDataType("false")).getValue());
		
		assertFalse(Bool.class.equals(parseDataType("tr00").getClass()));
	}
	
	@Test
	public void testIdent() throws RecognitionException {
		final Expression expression = parseDataType("identlabel");
		assertEquals(Ident.class, expression.getClass());
		assertEquals("identlabel", ((Ident)expression).getName());
		
		assertEquals(Ident.class, parseDataType("a").getClass());
		assertEquals(Ident.class, parseDataType("abc").getClass());
		assertEquals(Ident.class, parseDataType("ABC").getClass());
		assertEquals(Ident.class, parseDataType("ABCDEF").getClass());
		assertEquals(Ident.class, parseDataType("abc2323").getClass());
		assertEquals(Ident.class, parseDataType("a2bc232").getClass());
		assertEquals(Ident.class, parseDataType("a2bc232aa").getClass());
		
	}

	@Test
	public void testStringLiterals() throws RecognitionException {
		assertEquals(StringLiteral.class, parseDataType("\"Hello\"").getClass());
		assertEquals("Hello", ((StringLiteral)parseDataType("\"Hello\"")).getValue());
		assertEquals("\\\"Hello\\\"", ((StringLiteral)parseDataType("\"\\\"Hello\\\"\"")).getValue());
		
		assertEquals(StringLiteral.class, parseDataType("\"H12323ello\"").getClass());
		// Should be recognized as an ident, not a stringliteral
		assertFalse(StringLiteral.class.equals(parseDataType("Hello").getClass()));
	}
	
	private Expression parseDataType(final String source) throws RecognitionException {
		return parse(source).orExpression();
	}
}
