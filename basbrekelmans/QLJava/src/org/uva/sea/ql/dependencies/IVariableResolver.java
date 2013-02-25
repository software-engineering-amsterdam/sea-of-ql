package org.uva.sea.ql.dependencies;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.runtime.Variables;

public interface IVariableResolver {
	public Iterable<ParseError> getErrors();

	public Variables getVariables(Form root);

	public boolean hasErrors();
}
