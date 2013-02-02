package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.bool.And;
import org.uva.sea.ql.ast.expressions.binary.bool.Eq;
import org.uva.sea.ql.ast.expressions.binary.bool.GEq;
import org.uva.sea.ql.ast.expressions.binary.bool.GT;
import org.uva.sea.ql.ast.expressions.binary.bool.LEq;
import org.uva.sea.ql.ast.expressions.binary.bool.LT;
import org.uva.sea.ql.ast.expressions.binary.bool.NEq;
import org.uva.sea.ql.ast.expressions.binary.bool.Or;
import org.uva.sea.ql.ast.expressions.binary.numeric.Add;
import org.uva.sea.ql.ast.expressions.binary.numeric.Div;
import org.uva.sea.ql.ast.expressions.binary.numeric.Mul;
import org.uva.sea.ql.ast.expressions.binary.numeric.Sub;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestExpressions {

	private IParser _parser;
	
	public TestExpressions() {
		_parser = new ANTLRParserExpressions();
	}
	
	// Test methods for binary numeric expressions
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(_parser.parse("a + b").getClass(), Add.class);
		assertEquals(_parser.parse("a + b + c").getClass(), Add.class);
		assertEquals(_parser.parse("(a + b + c)").getClass(), Add.class);
		assertEquals(_parser.parse("a + (b + c)").getClass(), Add.class);
		assertEquals(_parser.parse("(a + b) + c").getClass(), Add.class);
		assertEquals(_parser.parse("(a + b)").getClass(), Add.class);
		assertEquals(_parser.parse("a + b * c").getClass(), Add.class);
		assertEquals(_parser.parse("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(_parser.parse("a * b").getClass(), Mul.class);
		assertEquals(_parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(_parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(_parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(_parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(_parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(_parser.parse("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testDivs() throws ParseError {
		assertEquals(_parser.parse("a / b").getClass(), Div.class);
		assertEquals(_parser.parse("a / (b * c)").getClass(), Div.class);
	}
	
	@Test
	public void testSubs() throws ParseError {
		assertEquals(_parser.parse("a - b").getClass(), Sub.class);
		assertEquals(_parser.parse("a - (b * c)").getClass(), Sub.class);
	}
	
	// Test methods for binary boolean expressions
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(_parser.parse("a < b").getClass(), LT.class);
		assertEquals(_parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(_parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(_parser.parse("(a * b) < c").getClass(), LT.class);
		
		assertEquals(_parser.parse("(a == b)").getClass(), Eq.class);
		assertEquals(_parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(_parser.parse("(a >= b)").getClass(), GEq.class);
		assertEquals(_parser.parse("(a != b)").getClass(), NEq.class);
		
		assertEquals(_parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(_parser.parse("a > b + c").getClass(), GT.class);
	}
	
	@Test
	public void testAnds() throws ParseError {
		assertEquals(_parser.parse("a && b").getClass(), And.class);
		assertEquals(_parser.parse("a && b <= c").getClass(), And.class);
	}
	
	@Test
	public void testOrs() throws ParseError {
		assertEquals(_parser.parse("a || b").getClass(), Or.class);
		assertEquals(_parser.parse("a || b <= c").getClass(), Or.class);
	}

	// Test methods for literal expressions
	
	@Test
	public void testIds() throws ParseError {
		assertEquals(_parser.parse("a").getClass(), Ident.class);
		assertEquals(_parser.parse("abc").getClass(), Ident.class);
		assertEquals(_parser.parse("ABC").getClass(), Ident.class);
		assertEquals(_parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(_parser.parse("a2bc232aBaC").getClass(), Ident.class);
	}
	
	@Test
	public void testNums() throws ParseError {
		assertEquals(_parser.parse("0").getClass(), Int.class);
		assertEquals(_parser.parse("1223").getClass(), Int.class);
	}
	
	@Test
	public void testMoneys() throws ParseError {
		assertEquals(_parser.parse("125.50").getClass(), Money.class);
		assertEquals(_parser.parse("125,00").getClass(), Money.class);
	}
	
	@Test
	public void testBooleans() throws ParseError {
		assertEquals(_parser.parse("true").getClass(), Bool.class);
		assertEquals(_parser.parse("false").getClass(), Bool.class);
	}
	
	@Test
	public void testStrings() throws ParseError {
		assertEquals(_parser.parse("\"a\"").getClass(), Str.class);
		assertEquals(_parser.parse("\"abc\"").getClass(), Str.class);
		assertEquals(_parser.parse("\"ABC\"").getClass(), Str.class);
		assertEquals(_parser.parse("\"abc2323\"").getClass(), Str.class);
		assertEquals(_parser.parse("\"a2bc232ABC\"").getClass(), Str.class);
	}
}