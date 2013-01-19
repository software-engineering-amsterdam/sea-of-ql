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
import org.uva.sea.ql.parser.antlr.ANTLRAddsParser;
import org.uva.sea.ql.parser.antlr.ANTLRExpressionParser;
import org.uva.sea.ql.parser.antlr.ANTLRMulsParser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class TestMuls {


	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
	  List<Object[]> retList = new ArrayList<Object[]>();
	  Object[] oArray = {new ANTLRMulsParser() } ;
	  retList.add(oArray);
	  return retList;
	}

	
	public TestMuls(IParse parser) {
		this.parser = parser;
	}

	

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}
		
}