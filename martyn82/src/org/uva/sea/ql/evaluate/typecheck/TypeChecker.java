package org.uva.sea.ql.evaluate.typecheck;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluate.ErrorList;

public class TypeChecker {
	private final TypeEnvironment environment;
	private final StatementTypeChecker typeChecker;
	private final ErrorList errors;

	public TypeChecker() {
		this.environment = new TypeEnvironment();
		this.errors = this.environment.getErrorList();
		this.typeChecker = new StatementTypeChecker( this.environment );
	}

	public boolean check( Statement statement ) {
		return statement.accept( this.typeChecker );
	}

	public boolean hasErrors() {
		return this.errors.size() > 0;
	}

	public ErrorList getErrorList() {
		return this.errors;
	}
}
