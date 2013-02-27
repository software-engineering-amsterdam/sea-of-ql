package org.uva.sea.ql.evaluate;

import org.uva.sea.ql.ast.expression.IdentifierExpression;

abstract public class Environment<T> {
	private final ErrorList errors;

	public Environment() {
		this.errors = new ErrorList();
	}

	public ErrorList getErrorList() {
		return this.errors;
	}

	public void addError( Error error ) {
		this.errors.addError( error );
	}

	public void clearErrors() {
		this.errors.clear();
	}

	abstract public boolean isDeclared( IdentifierExpression identifier );
	abstract public void declare( IdentifierExpression identifier, T definition );
	abstract public T lookup( IdentifierExpression identifier );
}
