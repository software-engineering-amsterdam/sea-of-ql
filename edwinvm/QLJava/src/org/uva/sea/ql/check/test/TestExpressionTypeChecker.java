package org.uva.sea.ql.check.test;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Add;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Div;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Mul;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Sub;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestExpressionTypeChecker extends ExpressionTypeChecker {
	private IParser _parser;
	
	public TestExpressionTypeChecker() {
		_parser = new ANTLRParserExpressions();
	}
	
	@Test
	public void testAdds() throws ParseError {
		isAValidExpression((Add) _parser.parse("1 + 1"));
		isAValidExpression((Add) _parser.parse("1 + 1"));
		isAValidExpression((Add) _parser.parse("1 + (2 + 3)"));
		isAValidExpression((Add) _parser.parse("1 + (2 + 3.0)"));
		
		isNotAValidExpression((Add) _parser.parse("1 + a"));
		isNotAValidExpression((Add) _parser.parse("1 + true"));
		isNotAValidExpression((Add) _parser.parse("true + true"));
	}
	
	@Test
	public void testMuls() throws ParseError {
		isAValidExpression((Mul) _parser.parse("1 * 1"));
		isAValidExpression((Mul) _parser.parse("1 * (2 * 3)"));
		isAValidExpression((Mul) _parser.parse("1 * (2 * 3.0)"));
		
		isNotAValidExpression((Mul) _parser.parse("1 * a"));
		isNotAValidExpression((Mul) _parser.parse("1 * true"));
		isNotAValidExpression((Mul) _parser.parse("true * true"));
	}
	
	@Test
	public void testDivs() throws ParseError {
		isAValidExpression((Div) _parser.parse("10 / 2"));
		isAValidExpression((Div) _parser.parse("10 / (2 * 1)"));
		isAValidExpression((Div) _parser.parse("10 / (2 * 2.50)"));
		
		isNotAValidExpression((Div) _parser.parse("1 / a"));
		isNotAValidExpression((Div) _parser.parse("1 / true"));
		isNotAValidExpression((Div) _parser.parse("true / true"));
	}
	
	@Test
	public void testSubs() throws ParseError {
		isAValidExpression((Sub) _parser.parse("10 - 10"));
		isAValidExpression((Sub) _parser.parse("10 - (2 * 5)"));
		isAValidExpression((Sub) _parser.parse("10 - (2 * 2.50)"));
		
		isNotAValidExpression((Sub) _parser.parse("1 - a"));
		isNotAValidExpression((Sub) _parser.parse("1 - true"));
		isNotAValidExpression((Sub) _parser.parse("true - true"));
	}
}