package org.uva.sea.ql.dependencies;

import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.runtime.Variable;

public interface IVariableResolver {
	public Iterable<Variable> getVariables(Statement root);
}
