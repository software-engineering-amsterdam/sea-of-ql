package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestTypes {

	private ANTLRParser parser;

	public TestTypes() {
		parser = new ANTLRParser();

	}

	@Test
	public void testAllTypes() throws ParseError {
		assertEquals(IntType.class, parser.parseType("int").getClass());
		assertEquals(BoolType.class, parser.parseType("boolean").getClass());
		assertEquals(StringType.class, parser.parseType("string").getClass());
		assertEquals(MoneyType.class, parser.parseType("money").getClass());

	}

}