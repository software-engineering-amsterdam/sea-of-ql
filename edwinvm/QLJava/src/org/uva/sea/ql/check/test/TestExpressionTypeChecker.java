package org.uva.sea.ql.check.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Add;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Div;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Mul;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Sub;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.check.CheckExpr;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.Message;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestExpressionTypeChecker {
	private IParser _parser;
	private HashMap<Ident, Type> _typeEnv;
	private List<Message> _errorMessages;
	
	public TestExpressionTypeChecker() {
		_parser = new ANTLRParserExpressions();
		_errorMessages = new ArrayList<Message>();
		_typeEnv = new HashMap<Ident, Type>();
		
		_typeEnv.put(new Ident("bool"),    new Bool());
		_typeEnv.put(new Ident("int"),     new Int());
		_typeEnv.put(new Ident("money"),   new Money());
		_typeEnv.put(new Ident("numeric"), new Numeric());
		_typeEnv.put(new Ident("str"),     new Str());
	}
	
	private Boolean isValidExpression(Expr expr) {
		return CheckExpr.check(expr, _typeEnv, _errorMessages);
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(isValidExpression((Add) _parser.parse("1 + 1")), true);
		assertEquals(isValidExpression((Add) _parser.parse("1 + 1")), true);
		assertEquals(isValidExpression((Add) _parser.parse("1 + (2 + 3)")), true);
		assertEquals(isValidExpression((Add) _parser.parse("1 + (2 + 3.0)")), true);
		
		assertEquals(isValidExpression((Add) _parser.parse("1 + a")), false);
		assertEquals(isValidExpression((Add) _parser.parse("1 + true")), false);
		assertEquals(isValidExpression((Add) _parser.parse("true + true")), false);
	}
	
	@Test
	public void testMuls() throws ParseError {
		assertEquals(isValidExpression((Mul) _parser.parse("1 * 1")), true);
		assertEquals(isValidExpression((Mul) _parser.parse("1 * (2 * 3)")), true);
		assertEquals(isValidExpression((Mul) _parser.parse("1 * (2 * 3.0)")), true);
		
		assertEquals(isValidExpression((Mul) _parser.parse("1 * a")), false);
		assertEquals(isValidExpression((Mul) _parser.parse("1 * true")), false);
		assertEquals(isValidExpression((Mul) _parser.parse("true * true")), false);
	}
	
	@Test
	public void testDivs() throws ParseError {
		assertEquals(isValidExpression((Div) _parser.parse("10 / 2")), true);
		assertEquals(isValidExpression((Div) _parser.parse("10 / (2 * 1)")), true);
		assertEquals(isValidExpression((Div) _parser.parse("10 / (2 * 2.50)")), true);
		
		assertEquals(isValidExpression((Div) _parser.parse("1 / a")), false);
		assertEquals(isValidExpression((Div) _parser.parse("1 / true")), false);
		assertEquals(isValidExpression((Div) _parser.parse("true / true")), false);
	}
	
	@Test
	public void testSubs() throws ParseError {
		assertEquals(isValidExpression((Sub) _parser.parse("10 - 10")), true);
		assertEquals(isValidExpression((Sub) _parser.parse("10 - (2 * 5)")), true);
		assertEquals(isValidExpression((Sub) _parser.parse("10 - (2 * 2.50)")), true);
		
		assertEquals(isValidExpression((Sub) _parser.parse("1 - a")), false);
		assertEquals(isValidExpression((Sub) _parser.parse("1 - true")), false);
		assertEquals(isValidExpression((Sub) _parser.parse("true - true")), false);
	}
}