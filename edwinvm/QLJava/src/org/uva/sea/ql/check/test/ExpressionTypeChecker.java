package org.uva.sea.ql.check.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.check.CheckExpr;
import org.uva.sea.ql.parser.ErrorMessages;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class ExpressionTypeChecker {
	
	private IParser _parser;
	private final HashMap<Ident, Type> _typeEnv;
	private final ErrorMessages _errorMessages;
	
	public ExpressionTypeChecker() {
		_parser = new ANTLRParserExpressions();
		_errorMessages = new ErrorMessages();
		
		_typeEnv = new HashMap<Ident, Type>();
		
		_typeEnv.put(new Ident("bool"),    new Bool());
		_typeEnv.put(new Ident("int"),     new Int());
		_typeEnv.put(new Ident("money"),   new Money());
		_typeEnv.put(new Ident("numeric"), new Numeric());
		_typeEnv.put(new Ident("str"),     new Str());
	}
	
	public void isAValidExpression(String input) throws ParseError {
		assertTrue(checkExpression(parseExpression(input)));
	}
	
	public void isNotAValidExpression(String input) throws ParseError {
		assertFalse(checkExpression(parseExpression(input)));
	}
	
	private Boolean checkExpression(Expr expr) {
		return CheckExpr.check(expr, _typeEnv, _errorMessages);
	}
	
	private Expr parseExpression(String input) throws ParseError {
		return (Expr) _parser.parse(input);
	}
	
}