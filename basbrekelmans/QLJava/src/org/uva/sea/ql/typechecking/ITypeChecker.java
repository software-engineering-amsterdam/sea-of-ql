package org.uva.sea.ql.typechecking;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.statements.Statement;

public interface ITypeChecker {
	void checkTypes(Form root);

	void checkTypes(Statement statement);

	TypeContext getContext();

	ITypeResolver getResolver();

}
