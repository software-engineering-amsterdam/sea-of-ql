package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.literals.BoolLiteral;
import org.uva.sea.ql.ast.types.literals.IntLiteral;
import org.uva.sea.ql.ast.types.literals.MoneyLiteral;
import org.uva.sea.ql.ast.types.literals.StringLiteral;

// Test literal types
public class TestTypeLiterals extends TestBase {
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
		assertEquals(IntLiteral.class, parseDataType("0").getClass());
		assertEquals(IntLiteral.class, parseDataType("1223").getClass());
		assertEquals(IntLiteral.class, parseDataType("234234234").getClass());

		assertEquals(0, ((IntLiteral) parseDataType("0")).getValue());
		assertEquals(1223, ((IntLiteral) parseDataType("1223")).getValue());
		assertEquals(234234234,
				((IntLiteral) parseDataType("234234234")).getValue());
	}

	@Test
	public void testMoney() throws RecognitionException {
		assertEquals(MoneyLiteral.class, parseDataType("0.000").getClass());
		assertEquals(MoneyLiteral.class, parseDataType("1.234").getClass());
		assertEquals(MoneyLiteral.class, parseDataType("1932.123214141")
				.getClass());

		assertEquals(new BigDecimal("0.000"),
				((MoneyLiteral) parseDataType("0.000")).getValue());
		assertEquals(new BigDecimal("1.234"),
				((MoneyLiteral) parseDataType("1.234")).getValue());
		assertEquals(new BigDecimal("1932.123214141"),
				((MoneyLiteral) parseDataType("1932.123214141")).getValue());
	}

	@Test
	public void testBool() throws RecognitionException {
		assertEquals(BoolLiteral.class, parseDataType("true").getClass());
		assertEquals(BoolLiteral.class, parseDataType("TRUE").getClass());
		assertEquals(BoolLiteral.class, parseDataType("false").getClass());
		assertEquals(BoolLiteral.class, parseDataType("FALSE").getClass());

		assertEquals(true, ((BoolLiteral) parseDataType("true")).getValue());
		assertEquals(true, ((BoolLiteral) parseDataType("TRUE")).getValue());
		assertEquals(false, ((BoolLiteral) parseDataType("false")).getValue());
		assertEquals(false, ((BoolLiteral) parseDataType("false")).getValue());

		assertFalse(BoolLiteral.class.equals(parseDataType("tr00").getClass()));
	}

	@Test
	public void testIdent() throws RecognitionException {
		final Expression expression = parseDataType("identlabel");
		assertEquals(Ident.class, expression.getClass());
		assertEquals("identlabel", ((Ident) expression).getName());

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
		assertEquals("Hello",
				((StringLiteral) parseDataType("\"Hello\"")).getValue());
		assertEquals("\\\"Hello\\\"",
				((StringLiteral) parseDataType("\"\\\"Hello\\\"\"")).getValue());

		assertEquals(StringLiteral.class, parseDataType("\"H12323ello\"")
				.getClass());
		// Should be recognized as an ident, not a stringliteral
		assertFalse(StringLiteral.class.equals(parseDataType("Hello")
				.getClass()));
	}

	private Expression parseDataType(final String source)
			throws RecognitionException {
		return parse(source).orExpression();
	}
}
