package org.uva.sea.ql.parser.test.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.*;

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
