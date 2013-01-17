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
import org.uva.sea.ql.parser.antlr.ANTLRReservedWordParser;
import org.uva.sea.ql.parser.antlr.ANTLRTypeParser;

@RunWith(Parameterized.class)
public class TestReservedWords {


	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
	  List<Object[]> retList = new ArrayList<Object[]>();
	  Object[] oArray = {new ANTLRReservedWordParser() } ;
	  retList.add(oArray);
	  return retList;
	}

	
	public TestReservedWords(IParse parser) {
		this.parser = parser;
	}

	@Test 
	public void testTrueRW() throws ParseError {
		assertEquals(parser.parse("true").getClass(), TrueRW.class);
	}
	
	@Test 
	public void testFalseRW() throws ParseError {
		assertEquals(parser.parse("false").getClass(), FalseRW.class);
	}
	
	@Test 
	public void testIfRW() throws ParseError {
		assertEquals(parser.parse("if").getClass(), IfRW.class);
	}
	
	@Test 
	public void testThenRW() throws ParseError {
		assertEquals(parser.parse("then").getClass(), ThenRW.class);
	}
	
	@Test 
	public void testElseRW() throws ParseError {
		assertEquals(parser.parse("else").getClass(), ElseRW.class);
	}
	
	
}
