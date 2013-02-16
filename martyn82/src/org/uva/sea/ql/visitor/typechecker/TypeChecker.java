package org.uva.sea.ql.visitor.typechecker;

import java.util.List;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.visitor.evaluator.Environment;
import org.uva.sea.ql.visitor.evaluator.Error;

public class TypeChecker {
	private final Environment environment;
	private final StatementTypeChecker typeChecker;

	public TypeChecker() {
		this.environment = new Environment();
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
