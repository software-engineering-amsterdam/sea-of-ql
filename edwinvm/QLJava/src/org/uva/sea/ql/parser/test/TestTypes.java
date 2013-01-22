package org.uva.sea.ql.parser.test;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Str;

import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParserTypes;

import static org.junit.Assert.assertEquals;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(Parameterized.class)
public class TestTypes {

	private IParser _parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
	    parserList.add(new Object[] {new ANTLRParserTypes()});
	    return parserList;
	}
	
	public TestTypes(IParser parser) {
		_parser = parser;
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
	public void testStrings() throws ParseError {
		assertEquals(_parser.parse("string").getClass(), Str.class);
	}
}