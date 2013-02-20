package org.uva.sea.ql.evaluator.typechecker;

import java.util.List;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.environment.Error;
import org.uva.sea.ql.evaluator.environment.TypeEnvironment;

public class TypeChecker {
	private final TypeEnvironment environment;
	private final StatementTypeChecker typeChecker;

	public TypeChecker() {
		this.environment = new TypeEnvironment();
		this.typeChecker = new StatementTypeChecker( this.environment );
	}

	public boolean check( Statement statement ) {
		return statement.accept( this.typeChecker );
	}

	public boolean hasErrors() {
		return this.environment.getErrors().size() > 0;
	}

	public List<Error> getErrors() {
		return this.environment.getErrors();
	}
}
