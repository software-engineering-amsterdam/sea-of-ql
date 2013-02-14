package org.uva.sea.ql.check.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.check.CheckExpr;
import org.uva.sea.ql.parser.Message;

public class ExpressionTypeChecker {
	
	private final HashMap<Ident, Type> _typeEnv;
	private final List<Message> _errorMessages;
	
	public ExpressionTypeChecker() {
		_errorMessages = new ArrayList<Message>();
		
		_typeEnv = new HashMap<Ident, Type>();
		
		_typeEnv.put(new Ident("bool"),    new Bool());
		_typeEnv.put(new Ident("int"),     new Int());
		_typeEnv.put(new Ident("money"),   new Money());
		_typeEnv.put(new Ident("numeric"), new Numeric());
		_typeEnv.put(new Ident("str"),     new Str());
	}
	
	public void isAValidExpression(Expr expr) {
		assertTrue(checkExpression(expr));
	}
	
	public void isNotAValidExpression(Expr expr) {
		assertFalse(checkExpression(expr));
	}
	
	private Boolean checkExpression(Expr expr) {
		return CheckExpr.check(expr, _typeEnv, _errorMessages);
	}
	
}