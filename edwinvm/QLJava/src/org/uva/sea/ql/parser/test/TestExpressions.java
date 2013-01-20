package org.uva.sea.ql.parser.test;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.Bool;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.ast.expressions.Str;

import org.uva.sea.ql.parser.antlr.ANTLRParser;

import static org.junit.Assert.assertEquals;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(Parameterized.class)
public class TestExpressions {

	private IParser _parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
	    parserList.add(new Object[] {new ANTLRParser()});
	    return parserList;
	}
	
	public TestExpressions(IParser parser) {
		_parser = parser;
	}
	
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
	public void testRels() throws ParseError {
		assertEquals(_parser.parse("a < b").getClass(), LT.class);
		assertEquals(_parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(_parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(_parser.parse("(a * b) < c").getClass(), LT.class);
		
		assertEquals(_parser.parse("(a <= b)").getClass(), LEq.class);
		
		assertEquals(_parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(_parser.parse("a > b + c").getClass(), GT.class);
	}

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