package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.form.Question;

public class Form implements org.uva.sea.ql.visitor.Form<Boolean> {

	@Override
	public Boolean visit(Question questionForm) {
		System.out.println("Visiting QuestionForm");

		// Visit items of question form
		Expression expressionVisitor = new Expression();
		questionForm.getIdent().accept(expressionVisitor);

		Statement statementVisitor = new Statement();
		questionForm.getStatements().accept(statementVisitor);

		System.out.println("Ended visiting QuestionForm");

		return true;
	}

}
