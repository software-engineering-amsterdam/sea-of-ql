package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.ast.expressions.*;
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
/**
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
	public void testBools() throws ParseError {
		assertEquals(parser.parse("!b").getClass(), Not.class);
		assertEquals(parser.parse("a && b").getClass(), And.class);
		assertEquals(parser.parse("a > b && b > c").getClass(), And.class);
		assertEquals(parser.parse("(a > b) && (b > c)").getClass(), And.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("aABC").getClass(), Ident.class);
		assertEquals(parser.parse("aABCDEF").getClass(), Ident.class);
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
	public void testBooleanTypes() throws ParseError {
		assertEquals(Bool.class, parser.parse("true").getClass());
		assertEquals(Bool.class, parser.parse("false").getClass());
		assertEquals(Bool.class, parser.parse("boolean").getClass());
	}
	
	@Test
	public void testMoneyTypes() throws ParseError {
		assertEquals(Money.class, parser.parse("money").getClass());
	}
	**/
}
