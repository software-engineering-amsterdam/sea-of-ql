package org.uva.sea.ql.parser.typechecker.error;

import org.uva.sea.ql.ast.form.Computed;

public class FormTypeMismatchError extends SemanticError {
	private final static String U_FORMAT =
			"Form type mismatch: computed question %s is of type %s, " +
			"expression of type %s found";
	
	public FormTypeMismatchError(String questionName, String questionType,
			String expressionType, Computed question)
	{	
		super(String.format(U_FORMAT, questionName, questionType,
				expressionType), question);
	}
		
}
