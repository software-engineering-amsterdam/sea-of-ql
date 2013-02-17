package org.uva.sea.ql.visitor.semantic;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.IForm;

public class Form implements IForm<Boolean> {

	private final List<String> errors;

	public Form() {
		this.errors = new ArrayList<String>();
	}

	@Override
	public Boolean visit(Question questionForm) {
		// The form identifier is not checked due to
		// the fact that only one form is allowed.
		Statement statementVisitor = new Statement(new Environment());
		Boolean isBlockStatementValid = questionForm.getStatements().accept(
				statementVisitor);
		if (!isBlockStatementValid) {
			this.errors.addAll(statementVisitor.getErrors());
		}

		return isBlockStatementValid;
	}

	public List<String> getErrors() {
		return this.errors;
	}

}
