package org.uva.sea.ql.dependencies;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.QLError;
import org.uva.sea.ql.runtime.RuntimeValues;

public interface IVariableResolver {
	public Iterable<QLError> getErrors();

	public RuntimeValues getRuntimeValues(Form root);

	public boolean hasErrors();
}
