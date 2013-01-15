package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class TestExpressions {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
	  return Arrays.asList( new Object[] {new ANTLRParser()},
			  new Object[] {new ANTLRParser()}
			 );
	}

	
	public TestExpressions(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parse("a + b").getClass(), Add.class);
		assertEquals(parser.parse("a + b + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parse("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parse("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b)").getClass(), Add.class);
		assertEquals(parser.parse("a + b * c").getClass(), Add.class);
		assertEquals(parser.parse("a * b + c").getClass(), Add.class);
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
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("ABC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), Int.class);
		assertEquals(parser.parse("1223").getClass(), Int.class);
		assertEquals(parser.parse("234234234").getClass(), Int.class);
	}
	
	@Test
	public void testSingleComment() throws ParseError {
		assertEquals(parser.parse("0123 // This is a single line comment." + "\n").getClass(), Int.class);
	}
	
	@Test 
	public void testStringLiteral() throws ParseError {
		assertEquals(parser.parse(" \" This is a String liteal indeed... \" ").getClass(), String_Literal.class);
	}
	
	@Test 
	public void testBoolean_Type() throws ParseError {
		assertEquals(parser.parse("bool").getClass(), Boolean_Type.class);
	}
	
	@Test 
	public void testInteger_Type() throws ParseError {
		assertEquals(parser.parse("int").getClass(), Integer_Type.class);
	}
	
	@Test 
	public void testString_Type() throws ParseError {
		assertEquals(parser.parse("string").getClass(), String_Type.class);
	}
	
	@Test 
	public void testTrue_RW() throws ParseError {
		assertEquals(parser.parse("true").getClass(), True_RW.class);
	}
	
	@Test 
	public void testFalse_RW() throws ParseError {
		assertEquals(parser.parse("false").getClass(), False_RW.class);
	}
	
	@Test 
	public void testIf_RW() throws ParseError {
		assertEquals(parser.parse("if").getClass(), If_RW.class);
	}
	
	@Test 
	public void testThen_RW() throws ParseError {
		assertEquals(parser.parse("then").getClass(), Then_RW.class);
	}
	
	@Test 
	public void testElse_RW() throws ParseError {
		assertEquals(parser.parse("else").getClass(), Else_RW.class);
	}
	
	@Test
	public void testQuestion() throws ParseError {
		assertEquals(parser.parse("hasSoldHouse : \"Did you sell a house in 2012?\" bool").getClass(), Question.class);
	}
	
	
	
}
