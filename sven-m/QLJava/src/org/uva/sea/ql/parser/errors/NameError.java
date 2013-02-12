package org.uva.sea.ql.parser.errors;

import org.uva.sea.ql.ast.form.FormElement;

public abstract class NameError extends SemanticError {

	public NameError(String message, FormElement formElement) {
		super(message, formElement);
	}
	
}
