package org.uva.sea.ql.visitor;

import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.evaluator.Error;

abstract public class Environment {
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
}
