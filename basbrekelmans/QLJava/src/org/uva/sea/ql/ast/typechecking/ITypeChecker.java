package org.uva.sea.ql.ast.typechecking;

import org.uva.sea.ql.ast.statements.Statement;

public interface ITypeChecker {
	TypeContext getContext();
	void checkTypes(Statement root);
}
