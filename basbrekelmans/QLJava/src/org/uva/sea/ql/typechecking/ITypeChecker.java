package org.uva.sea.ql.typechecking;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.QLError;

public interface ITypeChecker {
	void checkTypes(Form root);

	void checkTypes(Statement statement);

	List<QLError> getErrors();

	Map<Identifier, Type> getSymbolTable();

	boolean hasErrors();
}
