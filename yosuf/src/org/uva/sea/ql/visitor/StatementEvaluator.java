package org.uva.sea.ql.visitor;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.stm.Block;
import org.uva.sea.ql.ast.stm.CompoundStatement;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.ast.stm.IfElseStatement;
import org.uva.sea.ql.ast.stm.IfStatement;
import org.uva.sea.ql.ast.stm.Question;
import org.uva.sea.ql.lead.Model;

public class StatementEvaluator implements StatementVisitor<Block> {

	private final Model model;
	private final ExpressionEvaluator expressionEvaluator;

	public StatementEvaluator(final Model model,
			final ExpressionEvaluator expressionEvaluator) {
		this.model = model;
		this.expressionEvaluator = expressionEvaluator;

		state.assertNotNull(this.model, "ExpressionEvaluator.model");
		state.assertNotNull(this.expressionEvaluator,
				"ExpressionEvaluator.expressionEvaluator");
	}

	@Override
	public Block visit(final Form form) {
		form.getIdentifier().accept(expressionEvaluator);
		form.getBody().accept(this);
		return null;
	}

	@Override
	public Block visit(final CompoundStatement compoundStatement) {
		for (Block statement : compoundStatement.getStatements()) {
			statement.accept(this);
		}
		return compoundStatement;
	}

	@Override
	public Block visit(final IfStatement ifStatement) {
		ifStatement.getExpression().accept(expressionEvaluator);
		ifStatement.getIfCompound().accept(this);

		return ifStatement;
	}

	@Override
	public Block visit(final IfElseStatement ifElseStatement) {
		ifElseStatement.getExpression().accept(expressionEvaluator);
		ifElseStatement.getIfCompound().accept(this);
		ifElseStatement.getElseCompound().accept(this);

		return ifElseStatement;
	}

	@Override
	public Block visit(final Question question) {
		model.registerQuestion(question);
		return question;
	}

	@Override
	public Block visit(final Computed computed) {
		model.registerComputed(computed);
		return computed;
	}
}
