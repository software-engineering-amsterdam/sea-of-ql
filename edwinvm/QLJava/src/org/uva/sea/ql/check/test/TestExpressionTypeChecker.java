package org.uva.sea.ql.check.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	
	private void isAValidExpression(Expr expr) {
		assertTrue(CheckExpr.check(expr, _typeEnv, _errorMessages));
	}
	
	private void isNotAValidExpression(Expr expr) {
		assertFalse(CheckExpr.check(expr, _typeEnv, _errorMessages));
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