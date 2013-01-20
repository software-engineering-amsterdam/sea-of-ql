package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.form.QuestionForm;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.FormVisitor;
import org.uva.sea.ql.visitor.StatementVisitor;
import org.uva.sea.ql.visitor.VisitorResult;

public class PrintFormVisitor implements FormVisitor {

	@Override
	public VisitorResult visit(QuestionForm questionForm) {
		System.out.println("Visiting QuestionForm");

		// Visit items of question form
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		questionForm.getIdent().accept(expressionVisitor);

		StatementVisitor statementVisitor = new PrintStatementVisitor();
		questionForm.getStatements().accept(statementVisitor);

		return null;
	}

}
