package org.uva.sea.ql.tests.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class TestTypes {

	final private IParse parser = new ANTLRParser();

	@Test
	public void testBoolType() throws ParseError {
		assertEquals(BoolType.class, parser.parseType("boolean").getClass());
	}

	@Test
	public void testMoneyType() throws ParseError {
		assertEquals(MoneyType.class, parser.parseType("money").getClass());
	}

	@Test
	public void testIntType() throws ParseError {
		assertEquals(IntType.class, parser.parseType("int").getClass());
	}

	@Test
	public void testStringType() throws ParseError {
		assertEquals(StringType.class, parser.parseType("string").getClass());
	}

}
