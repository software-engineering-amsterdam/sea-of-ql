package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.ANTLRExpressionParser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.ANTLRTypeParser;

public class TestTypes {

	private IParse parser;

	
	public TestTypes() {
		this.parser = new ANTLRTypeParser();
	}

		@Test 
	public void testBooleanType() throws ParseError {
		assertEquals(parser.parse("bool").getClass(), BooleanType.class);
	}
	
	@Test 
	public void testIntegerType() throws ParseError {
		assertEquals(parser.parse("int").getClass(), IntegerType.class);
	}
	
	@Test 
	public void testStringType() throws ParseError {
		assertEquals(parser.parse("string").getClass(), StringType.class);
	}
	
	
}
