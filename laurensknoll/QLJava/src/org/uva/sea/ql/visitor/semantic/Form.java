package org.uva.sea.ql.visitor.semantic;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.IForm;
import org.uva.sea.ql.visitor.IStatement;

public class Form implements IForm<ValidationResult> {

	@Override
	public ValidationResult visit(Question questionForm) {
		// The form identifier is not checked due to
		// the fact that only one form is allowed.
		IStatement<ValidationResult> statementVisitor = new Statement(
				new Environment());
		return questionForm.getStatements().accept(statementVisitor);
	}

}
