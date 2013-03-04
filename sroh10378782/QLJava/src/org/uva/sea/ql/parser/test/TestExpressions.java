package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.ast.nodes.expressions.*;
// import org.uva.sea.ql.ast.nodes.types.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExpressions {

	private static IParse parser;
	
	@BeforeClass
	public static void init(){
		parser = new ANTLRParser();
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parser.parse("(a + b)").getClass());
		assertEquals(Add.class, parser.parse("((a + b) + c)").getClass());
		assertEquals(Add.class, parser.parse("(a + b + c)").getClass());
		assertEquals(Add.class, parser.parse("(a + (b + c))").getClass());
		assertEquals(Add.class, parser.parse("((a + b) + c)").getClass());
		assertEquals(Add.class, parser.parse("(a + b)").getClass());
		assertEquals(Mul.class, parser.parse("((a + b) * c)").getClass());
		assertEquals(Add.class, parser.parse("((a * b) + c)").getClass());
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class,parser.parse("(a * b)").getClass());
		assertEquals(Mul.class,parser.parse("((a * b) * c)").getClass());
		assertEquals(Mul.class,parser.parse("(a * (b * c))").getClass());
		assertEquals(Mul.class,parser.parse("((a * b) * c)").getClass());
		assertEquals(Mul.class,parser.parse("(a * b)").getClass());
		assertEquals(Mul.class,parser.parse("((a + b) * c)").getClass());
		assertEquals(Mul.class,parser.parse("(a * (b + c))").getClass());
	}
	
	@Test
	public void testDivs() throws ParseError {
		// assertEquals(Mul.class,parser.parse("(a / b)").getClass());
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class,parser.parse("(a < b)").getClass());
		assertEquals(LT.class,parser.parse("(a < (b + c))").getClass());
		assertEquals(LT.class,parser.parse("(a < (b * c))").getClass());
		assertEquals(LT.class,parser.parse("((a * b) < c)").getClass());
		assertEquals(LEq.class,parser.parse("(a <= b)").getClass());
		assertEquals(GT.class,parser.parse("((a + b) > c)").getClass());
		assertEquals(GT.class,parser.parse("(a > (b + c))").getClass());
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(Not.class,parser.parse("!b").getClass());
		assertEquals(And.class,parser.parse("(a && b)").getClass());
		assertEquals(And.class,parser.parse("(a > b && b > c)").getClass());
		assertEquals(And.class,parser.parse("((a > b) && (b > c))").getClass());
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(Ident.class,parser.parse("a").getClass());
		assertEquals(Ident.class,parser.parse("abc").getClass());
		assertEquals(Ident.class,parser.parse("aABC").getClass());
		assertEquals(Ident.class,parser.parse("aABCDEF").getClass());
		assertEquals(Ident.class,parser.parse("abc2323").getClass());
		assertEquals(Ident.class,parser.parse("a2bc232").getClass());
		assertEquals(Ident.class,parser.parse("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(Int.class,parser.parse("0").getClass());
		assertEquals(Int.class,parser.parse("1223").getClass());
		assertEquals(Int.class,parser.parse("234234234").getClass());
	}
	
	@Test
	public void testBooleanTypes() throws ParseError {
		assertEquals(Bool.class, parser.parse("true").getClass());
		assertEquals(Bool.class, parser.parse("false").getClass());
		assertEquals(Bool.class, parser.parse("boolean").getClass());
	}
	
	@Test
	public void testMoneyTypes() throws ParseError {
		assertEquals(Money.class, parser.parse("money").getClass());
	}
}
