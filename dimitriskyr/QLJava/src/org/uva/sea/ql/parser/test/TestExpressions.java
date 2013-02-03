package org.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.values.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class) 
public class TestExpressions {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> Listtocheck = new ArrayList<Object[]>();
		Listtocheck.add(new Object[] { new ANTLRParser() });
		return Listtocheck;
		}

	
	public TestExpressions(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parseExpression("a + b + c ").getClass(), Add.class);
		assertEquals(parser.parseExpression("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpression("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpression("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parseExpression("(a + b)").getClass(), Add.class);
		assertEquals(parser.parseExpression("a + b * c").getClass(), Add.class);
		assertEquals(parser.parseExpression("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parseExpression("a * b").getClass(), Mul.class);
		assertEquals(parser.parseExpression("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parseExpression("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parseExpression("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpression("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parseExpression("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpression("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parseExpression("a < b").getClass(), LT.class);
		assertEquals(parser.parseExpression("a < b + c").getClass(), LT.class);
		assertEquals(parser.parseExpression("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parseExpression("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parseExpression("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parseExpression("a + b > c").getClass(), GT.class);
		assertEquals(parser.parseExpression("a > b + c").getClass(), GT.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parseValue("a").getClass(), Ident.class);
		assertEquals(parser.parseValue("abc").getClass(), Ident.class);
		assertEquals(parser.parseValue("ABC").getClass(), Ident.class);
		assertEquals(parser.parseValue("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parseValue("abc2323").getClass(), Ident.class);
		assertEquals(parser.parseValue("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parseValue("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parseValue("0").getClass(), Int.class);
		assertEquals(parser.parseValue("1223").getClass(), Int.class);
		assertEquals(parser.parseValue("234234234").getClass(), Int.class);
	}
	
}
