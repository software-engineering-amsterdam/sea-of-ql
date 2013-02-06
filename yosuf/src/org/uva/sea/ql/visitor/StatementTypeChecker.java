package org.uva.sea.ql.visitor;

import static julius.validation.Assertions.checked;
import static julius.validation.Assertions.state;

import java.util.ArrayList;
import java.util.List;

import julius.validation.ValidationException;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.stm.CompoundStatement;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.ast.stm.IfElseStatement;
import org.uva.sea.ql.ast.stm.IfStatement;
import org.uva.sea.ql.ast.stm.Question;
import org.uva.sea.ql.ast.stm.Statement;
import org.uva.sea.ql.ast.type.BooleanType;

public class StatementTypeChecker implements StatementVisitor<Statement> {

	private final List<ValidationException> typeErrors = new ArrayList<ValidationException>();
	private final ExpressionTypeChecker expressionTypeChecker;

	public StatementTypeChecker(
			final ExpressionTypeChecker expressionTypeChecker) {
		this.expressionTypeChecker = expressionTypeChecker;
		state.assertNotNull(this.expressionTypeChecker, "expressionTypeChecker");
	}

	@Override
	public Statement visit(final Form form) {
		form.getBody().accept(this);
		assertIdentifier(form.getIdentifier(), form.toString());

		return form;
	}

	@Override
	public Statement visit(final CompoundStatement compoundStatement) {

		for (Statement statement : compoundStatement.getStatements()) {
			statement.accept(this);
		}

		return compoundStatement;
	}

	@Override
	public Statement visit(final Computed computed) {

		assertIdentifier(computed.getIdentifier(), computed.toString());
		visitExpression(computed.getExpression());
		assertSameNature(computed.getDataType(), computed.getExpression(),
				computed.toString());

		return computed;
	}

	@Override
	public Statement visit(final IfStatement ifStatement) {
		visitExpression(ifStatement.getExpression());
		assertSameNature(new BooleanType(), ifStatement.getExpression(),
				ifStatement.toString());
		ifStatement.getIfCompound().accept(this);

		return ifStatement;
	}

	@Override
	public Statement visit(final IfElseStatement ifElseStatement) {
		visitExpression(ifElseStatement.getExpression());
		assertSameNature(new BooleanType(), ifElseStatement.getExpression(),
				ifElseStatement.toString());
		ifElseStatement.getIfCompound().accept(this);
		ifElseStatement.getElseCompound().accept(this);

		return ifElseStatement;
	}

	@Override
	public Statement visit(final Question question) {
		assertIdentifier(question.getIdentifier(), question.toString());
		return question;
	}

	private void assertSameNature(final Expression expression1,
			final Expression expression2, final String reference) {

		try {
			checked.assertTrue(
					expression1.getNature() == expression2.getNature(),
					expression1 + " does not match " + expression2 + " for "
							+ reference);

		} catch (ValidationException e) {
			typeErrors.add(e);
		}
	}

	private void visitExpression(final Expression expression) {
		expression.accept(expressionTypeChecker);
	}

	private void assertIdentifier(final Identifier identifier,
			final String reference) {
		identifier.accept(expressionTypeChecker);

		try {
			checked.assertTrue(!identifier.getName().isEmpty(), reference
					+ " identifier cannot be empty");
		} catch (ValidationException e) {
			typeErrors.add(e);
		}
	}

	/**
	 * 
	 * @return a copy. Does not include expression type errors
	 */
	public List<ValidationException> getTypeErrors() {
		return new ArrayList<ValidationException>(typeErrors);
	}

	/**
	 * 
	 * @return all error types including expression type errors
	 */
	public List<ValidationException> getAllTypeErrors() {
		List<ValidationException> allErrors = new ArrayList<ValidationException>(
				typeErrors);
		allErrors.addAll(expressionTypeChecker.getTypeErrors());

		return allErrors;
	}

	/**
	 * Should be used after visiting is done to avoid false positive.
	 * 
	 * @return
	 */
	public boolean isValid() {
		return getAllTypeErrors().isEmpty();
	}

	public ExpressionTypeChecker getExpressionTypeChecker() {
		return expressionTypeChecker;
	}
}
