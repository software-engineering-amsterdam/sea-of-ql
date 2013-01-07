package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.Bool;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.Str;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.parser.rats.RatsParser;

@RunWith(Parameterized.class)
public class TestExpressions {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
	  return Arrays.asList(
			new Object[][] {
				//new Object[] {new JACCParser()}, 
			  	//new Object[] {new RatsParser()},
			  	new Object[] {new ANTLRParser()}
			}
		);
	}

	
	public TestExpressions(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parser.parse("a + b").getClass());
		assertEquals(Add.class, parser.parse("a + b + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b + c)").getClass());
		assertEquals(Add.class, parser.parse("a + (b + c)").getClass());
		assertEquals(Add.class, parser.parse("(a + b) + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b)").getClass());
		assertEquals(Add.class, parser.parse("a + b * c").getClass());
		assertEquals(Add.class, parser.parse("a * b + c").getClass());
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class, parser.parse("a * b").getClass());
		assertEquals(Mul.class, parser.parse("a * b * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b * c)").getClass());
		assertEquals(Mul.class, parser.parse("(a * b) * c").getClass());
		assertEquals(Mul.class, parser.parse("(a * b)").getClass());
		assertEquals(Mul.class, parser.parse("(a + b) * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b + c)").getClass());
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class, parser.parse("a < b").getClass());
		assertEquals(LT.class, parser.parse("a < b + c").getClass());
		assertEquals(LT.class, parser.parse("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parse("(a * b) < c").getClass());
		assertEquals(LEq.class, parser.parse("(a <= b)").getClass());
		assertEquals(GT.class, parser.parse("a + b > c").getClass());
		assertEquals(GT.class, parser.parse("a > b + c").getClass());
	}                

	
	@Test
	public void testBooleans() throws ParseError {
		assertEquals(Bool.class, parser.parse("true").getClass());
		assertEquals(Bool.class, parser.parse("false").getClass());
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(Ident.class, parser.parse("a").getClass());
		assertEquals(Ident.class, parser.parse("abc").getClass());
		assertEquals(Ident.class, parser.parse("ABC").getClass());
		assertEquals(Ident.class, parser.parse("ABCDEF").getClass());
		assertEquals(Ident.class, parser.parse("abc2323").getClass());
		assertEquals(Ident.class, parser.parse("a2bc232").getClass());
		assertEquals(Ident.class, parser.parse("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(Int.class, parser.parse("0").getClass());
		assertEquals(Int.class, parser.parse("1223").getClass());
		assertEquals(Int.class, parser.parse("234234234").getClass());
	}
	
	@Test
	public void testStrings() throws ParseError {
		String stringValue = "Henk de Vries!";
		
		ASTNode parsed = parser.parse(String.format("\"%s\"", stringValue));
		assertEquals(Str.class, parsed.getClass());
		assertEquals(stringValue, ((Str) parsed).getValue());
	}
	
}
