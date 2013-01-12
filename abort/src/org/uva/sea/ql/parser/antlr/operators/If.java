package org.uva.sea.ql.parser.antlr.operators;

import org.uva.sea.ql.ast.Expression;

public class If extends Expression {
	private Expression statement = null;
	private Expression successStatement = null;
	
	public If(Expression statement, Expression successStatement) {
	}
	
	@Override
	public Object getValue() {
		return statement;
	}

}
