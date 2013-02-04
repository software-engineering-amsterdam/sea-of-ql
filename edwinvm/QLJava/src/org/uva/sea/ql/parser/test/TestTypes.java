package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserTypes;

public class TestTypes {

	private IParser _parser;
	
	public TestTypes() {
		_parser = new ANTLRParserTypes();
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(_parser.parse("boolean").getClass(), Bool.class);
	}

	@Test
	public void testInts() throws ParseError {
		assertEquals(_parser.parse("integer").getClass(), Int.class);
	}
	
	@Test
	public void testMoneys() throws ParseError {
		assertEquals(_parser.parse("money").getClass(), Money.class);
	}
	
	@Test
	public void testStrings() throws ParseError {
		assertEquals(_parser.parse("string").getClass(), Str.class);
	}
}