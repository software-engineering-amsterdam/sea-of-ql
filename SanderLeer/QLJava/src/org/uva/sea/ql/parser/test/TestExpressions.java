package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static com.googlecode.catchexception.CatchException.*;
import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.jacc.*;

public class TestExpressions {

	private Parser parser;

	public TestExpressions() {
		this.parser = new JACCParser();
	}
	
	@Test
	public void testLexerErrors() throws ParseException {
		verifyException(parser, RuntimeException.class).parse("&");
		verifyException(parser, RuntimeException.class).parse("|");
		verifyException(parser, RuntimeException.class).parse("=");
		verifyException(parser, RuntimeException.class).parse("\"aa");
	}

	@Test
	public void testUnary() throws ParseException {		
		assertEquals(Pos.class, parser.parse("+a").getClass());
		assertEquals(Neg.class, parser.parse("-a").getClass());
		assertEquals(Not.class, parser.parse("!a").getClass());
	}

	@Test
	public void testBinary() throws ParseException {
		assertEquals(Add.class, parser.parse("a + b").getClass());
		assertEquals(Div.class, parser.parse("a / b").getClass());
		assertEquals(Mul.class, parser.parse("a * b").getClass());
		assertEquals(Sub.class, parser.parse("a - b").getClass());

		assertEquals(And.class, parser.parse("a && b").getClass());
		assertEquals(Or.class, parser.parse("a || b").getClass());
		
		assertEquals(GT.class, parser.parse("a > b").getClass());
		assertEquals(GEq.class, parser.parse("a >= b").getClass());
		assertEquals(LT.class, parser.parse("a < b").getClass());
		assertEquals(LEq.class, parser.parse("a <= b").getClass());

		assertEquals(Eq.class, parser.parse("a == b").getClass());
		assertEquals(NEq.class, parser.parse("a != b").getClass());
	}

	@Test
	public void testAdds() throws ParseException {
		assertEquals(Pos.class, parser.parse("+a").getClass());
		assertEquals(Add.class, parser.parse("+b + c + (d + e)").getClass());
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
	public void testMuls() throws ParseException {
		assertEquals(Mul.class, parser.parse("a * b").getClass());
		assertEquals(Mul.class, parser.parse("a * b * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b * c)").getClass());
		assertEquals(Mul.class, parser.parse("(a * b) * c").getClass());
		assertEquals(Mul.class, parser.parse("(a * b)").getClass());
		assertEquals(Mul.class, parser.parse("(a + b) * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b + c)").getClass());
	}

	@Test
	public void testRels() throws ParseException {
		assertEquals(LT.class, parser.parse("a < b").getClass());
		assertEquals(LT.class, parser.parse("a < b + c").getClass());
		assertEquals(LT.class, parser.parse("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parse("(a * b) < c").getClass());
		assertEquals(LEq.class, parser.parse("a <= b").getClass());
		assertEquals(LEq.class, parser.parse("a <= b + 4").getClass());
		assertEquals(GT.class, parser.parse("a + b > c").getClass());
		assertEquals(GT.class, parser.parse("a > b + c").getClass());
		assertEquals(GEq.class, parser.parse("a >= b").getClass());
		assertEquals(GEq.class, parser.parse("a >= b + 4").getClass());
		assertEquals(Eq.class, parser.parse("a == b").getClass());
		assertEquals(Eq.class, parser.parse("a == b + 4").getClass());
		assertEquals(NEq.class, parser.parse("a != b").getClass());
		assertEquals(NEq.class, parser.parse("a != b + 4").getClass());
	}
	
	@Test
	public void testIds() throws ParseException {
		assertEquals(Identifier.class, parser.parse("a").getClass());
		assertEquals(Identifier.class, parser.parse("abc").getClass());
		assertEquals(Identifier.class, parser.parse("ABC").getClass());
		assertEquals(Identifier.class, parser.parse("ABCDEF").getClass());
		assertEquals(Identifier.class, parser.parse("abc2323").getClass());
		assertEquals(Identifier.class, parser.parse("a2bc232").getClass());
		assertEquals(Identifier.class, parser.parse("a2bc232aa").getClass());
	}

	@Test
	public void testInts() throws ParseException {
		assertEquals(IntegerValue.class, parser.parse("0").getClass());
		assertEquals(IntegerValue.class, parser.parse("1223").getClass());
		assertEquals(IntegerValue.class, parser.parse("234234234").getClass());
	}
	
	@Test
	public void testBools() throws ParseException {
		assertEquals(Not.class, parser.parse("!b").getClass());
		assertEquals(And.class, parser.parse("a && b").getClass());
		assertEquals(And.class, parser.parse("a > b && b > c").getClass());
		assertEquals(And.class, parser.parse("(a > b) && (b > c)").getClass());
		assertEquals(Or.class, parser.parse("a || b").getClass());
		assertEquals(Or.class, parser.parse("a > b || b > c").getClass());
		assertEquals(Or.class, parser.parse("(a > b) || (b > c)").getClass());
		assertEquals(BooleanValue.class, parser.parse("true").getClass());
		assertEquals(BooleanValue.class, parser.parse("false").getClass());
		assertEquals(And.class, parser.parse("true && false").getClass());
		assertEquals(Or.class, parser.parse("true || false").getClass());
		assertEquals(Not.class, parser.parse("!true").getClass());
		assertEquals(And.class, parser.parse("true && a").getClass());
		assertEquals(And.class, parser.parse("a && true").getClass());
		assertEquals(And.class, parser.parse("false && a").getClass());
		assertEquals(And.class, parser.parse("a && false").getClass());
		assertEquals(Identifier.class, parser.parse("True").getClass());
		assertEquals(Identifier.class, parser.parse("False").getClass());
	}

	@Test
	public void testStrings() throws ParseException {
		assertEquals(StringValue.class, parser.parse("\"a\"").getClass());
		assertEquals(StringValue.class, parser.parse("\"aa\"").getClass());
		assertEquals(StringValue.class, parser.parse("\"abcdefghijklmnop\"").getClass());
		assertEquals(StringValue.class, parser.parse("\" \"").getClass());
		assertEquals(StringValue.class, parser.parse("\"\"").getClass());
		assertEquals(StringValue.class, parser.parse("\"aa\nbbb\"").getClass());
		verifyException(parser, RuntimeException.class).parse("\"aa");
	}
}
