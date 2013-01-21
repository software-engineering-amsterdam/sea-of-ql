package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;

public class Statement implements org.uva.sea.ql.visitor.Statement<Boolean> {

	@Override
	public Boolean visit(Block block) {
		System.out.println("Visiting BlockStatement");

		// Visit items
		for (AbstractStatement statement : block.getStatements()) {
			statement.accept(this);
		}

		System.out.println("Ended visiting BlockStatement");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(ComputedQuestion computedQuestion) {
		System.out.println("Visiting ComputedQuestion Statement");

		// Visit items
		computedQuestion.getQuestion().accept(this);

		Expression expressionVisitor = new Expression();
		computedQuestion.getComputeExpression().accept(expressionVisitor);

		System.out.println("Ended visiting ComputedQuestion Statement");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(If ifStatement) {
		System.out.println("Visiting If Statement");

		// Visit items
		Expression expressionVisitor = new Expression();
		ifStatement.getCondition().accept(expressionVisitor);

		ifStatement.getTruePath().accept(this);

		System.out.println("Ended visiting If Statement");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Question question) {
		System.out.println("Visiting Question Statement");

		// Visit items
		Expression expressionVisitor = new Expression();
		question.getIdent().accept(expressionVisitor);
		question.getQuestion().accept(expressionVisitor);

		Type typeVisitor = new Type();
		question.getType().accept(typeVisitor);

		System.out.println("Ended visiting Question Statement");
		System.out.println();

		return true;
	}

}
