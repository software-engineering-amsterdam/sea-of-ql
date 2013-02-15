package org.uva.sea.ql.check.expressions.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.check.expressions.CheckExpr;
import org.uva.sea.ql.parser.ErrorMessages;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.SupportedTypes;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class ExpressionTypeChecker {
	
	private IParser _parser;
	private final SupportedTypes _supportedTypes;
	
	public ExpressionTypeChecker() {
		_parser = new ANTLRParserExpressions();
		_supportedTypes = new SupportedTypes();
		
		_supportedTypes.add("bool",    new Bool());
		_supportedTypes.add("int",     new Int());
		_supportedTypes.add("money",   new Money());
		_supportedTypes.add("numeric", new Numeric());
		_supportedTypes.add("str",     new Str());
	}
	
	public void isAValidExpression(String input) throws ParseError {
		assertTrue(checkExpression(parseExpression(input)));
	}
	
	public void isNotAValidExpression(String input) throws ParseError {
		assertFalse(checkExpression(parseExpression(input)));
	}
	
	private Boolean checkExpression(Expr expr) {
		return CheckExpr.check(expr, _supportedTypes, new ErrorMessages());
	}
	
	private Expr parseExpression(String input) throws ParseError {
		return (Expr) _parser.parse(input);
	}
	
}