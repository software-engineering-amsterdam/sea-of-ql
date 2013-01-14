package org.uva.sea.ql.parser.test;

import java.util.List;
import java.util.Arrays;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.parser.rats.RatsParser;
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
		return Arrays.asList(
			new Object[] {new JACCParser()}, 
			new Object[] {new RatsParser()},
			new Object[] {new ANTLRParser()}
		);
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
		assertEquals(_parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(_parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(_parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(_parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(_parser.parse("0").getClass(), Int.class);
		assertEquals(_parser.parse("1223").getClass(), Int.class);
		assertEquals(_parser.parse("234234234").getClass(), Int.class);
	}
}