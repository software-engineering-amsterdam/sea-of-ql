package org.uva.sea.ql.evaluator.environment;

import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.ast.expression.IdentifierExpression;

abstract public class Environment<T> {
	private final List<Error> errors;

	public Environment() {
		this.errors = new LinkedList<Error>();
	}

	public List<Error> getErrors() {
		return this.errors;
	}

	public void addError( Error error ) {
		this.errors.add( error );
	}

	abstract public boolean isDeclared( IdentifierExpression identifier );
	abstract public void declare( IdentifierExpression identifier, T definition );
	abstract public T lookup( IdentifierExpression identifier );
}
