package org.uva.sea.ql.evaluator;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfElseStatement;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.lead.Model;

/**
 * Class representing the visitor to evaluate form and statements. Moreover, it evaluates the
 * expressions expressed in the statements and the form and registers them in the model.
 * 
 * It is recommented to start the evaluation by a form to handle the correct flow of visiting.
 */
public class StatementEvaluator implements StatementVisitor<Block> {

	private final Model model;
	private final ExpressionEvaluator expressionEvaluator;

	public StatementEvaluator(final Model model, final ExpressionEvaluator expressionEvaluator) {
		this.model = model;
		this.expressionEvaluator = expressionEvaluator;

		state.assertNotNull(this.model, "ExpressionEvaluator.model");
		state.assertNotNull(this.expressionEvaluator, "ExpressionEvaluator.expressionEvaluator");
	}

	@Override
	public Block visit(final Form form) {
		form.getBody().accept(this);
		return form;
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
		ifStatement.getIfCompound().accept(this);

		return ifStatement;
	}

	@Override
	public Block visit(final IfElseStatement ifElseStatement) {

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
