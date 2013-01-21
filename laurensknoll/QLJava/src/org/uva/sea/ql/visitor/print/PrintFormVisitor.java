package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.FormVisitor;
import org.uva.sea.ql.visitor.StatementVisitor;

public class PrintFormVisitor implements FormVisitor<Boolean> {

	@Override
	public Boolean visit(Question questionForm) {
		System.out.println("Visiting QuestionForm");

		// Visit items of question form
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		questionForm.getIdent().accept(expressionVisitor);

		StatementVisitor<Boolean> statementVisitor = new PrintStatementVisitor();
		questionForm.getStatements().accept(statementVisitor);

		System.out.println("Ended visiting QuestionForm");

		return true;
	}

}
