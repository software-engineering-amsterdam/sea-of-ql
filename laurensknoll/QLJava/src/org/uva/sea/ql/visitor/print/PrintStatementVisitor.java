package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.visitor.AnswerTypeVisitor;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.StatementVisitor;

public class PrintStatementVisitor implements StatementVisitor<Boolean> {

	@Override
	public Boolean visit(Block block) {
		System.out.println("Visiting BlockStatement");

		// Visit items
		for (AbstractStatement statement : block.getStatements()) {
			statement.accept(this);
		}

		return true;
	}

	@Override
	public Boolean visit(ComputedQuestion computedQuestion) {
		System.out.println("Visiting ComputedQuestion Statement");

		// Visit items
		computedQuestion.getQuestion().accept(this);

		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		computedQuestion.getComputeExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(IfStatement ifStatement) {
		System.out.println("Visiting If Statement");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		ifStatement.getCondition().accept(expressionVisitor);

		ifStatement.getTruePath().accept(this);

		return true;
	}

	@Override
	public Boolean visit(Question question) {
		System.out.println("Visiting Question Statement");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		question.getIdent().accept(expressionVisitor);
		question.getQuestion().accept(expressionVisitor);

		AnswerTypeVisitor<Boolean> answerTypeVisitor = new PrintAnswerTypeVisitor();
		question.getType().accept(answerTypeVisitor);

		return true;
	}

}
