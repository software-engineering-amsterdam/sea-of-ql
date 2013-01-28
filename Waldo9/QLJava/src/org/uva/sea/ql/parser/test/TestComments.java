package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.parser.antlr.*;

@RunWith(Parameterized.class)
public class TestComments {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParser() {
	  List<Object[]> parserList = new ArrayList<Object[]>();
	  parserList.add(new Object[] {new ANTLRParser()});
	  return parserList;
	}
	
	public TestComments(IParse parser) {
		this.parser = parser;
	}
	
	@Test
	public void testMultiLineComment() throws ParseError {
		assertEquals(Mul.class, parser.parseExpr("/* a + /n b + */ c * d").getClass());
	}
	
	@Test
	public void testSingleLineComment() throws ParseError {
		assertEquals(Mul.class, parser.parseExpr("// a + \n b * c").getClass());
		assertEquals(Int.class, parser.parseExpr("// a + b * c \n 5").getClass());
	}

}
