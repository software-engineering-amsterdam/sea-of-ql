package org.uva.sea.ql.visitor;

import static julius.validation.Assertions.checked;
import static julius.validation.Assertions.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private final List<TypeCheckException> typeErrors = new ArrayList<TypeCheckException>();
	private final ExpressionTypeChecker expressionTypeChecker;

	private final Map<Expression, Expression> environment = new HashMap<Expression, Expression>();

	public StatementTypeChecker(
			final ExpressionTypeChecker expressionTypeChecker) {
		this.expressionTypeChecker = expressionTypeChecker;
		state.assertNotNull(this.expressionTypeChecker, "expressionTypeChecker");
	}

	@Override
	public Statement visit(final Form form) {
		form.getBody().accept(this);
		assertIdentifierAndAddToEnvironment(form.getIdentifier(),
				form.getIdentifier());

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

		assertIdentifierAndAddToEnvironment(computed.getIdentifier(),
				computed.getExpression());
		visitExpression(computed.getExpression());
		assertSameNature(computed.getDataType(), computed.getExpression(),
				computed.toString());

		return computed;
	}

	@Override
	public Statement visit(final IfStatement ifStatement) {
		visitExpression(ifStatement.getExpression());

		assertIfStatementExpression(ifStatement.getExpression(),
				ifStatement.toString());

		ifStatement.getIfCompound().accept(this);

		return ifStatement;
	}

	/**
	 * Checks whethere the given expression is of the boolean nature or refers
	 * to any expression with such nature.
	 * 
	 * @param expression
	 */
	private void assertIfStatementExpression(final Expression expression,
			final String reference) {
		if (environment.get(expression) != null) {
			assertSameNature(new BooleanType(), environment.get(expression),
					reference);
		} else {
			assertSameNature(new BooleanType(), expression, reference);
		}
	}

	@Override
	public Statement visit(final IfElseStatement ifElseStatement) {
		visitExpression(ifElseStatement.getExpression());

		assertIfStatementExpression(ifElseStatement.getExpression(),
				ifElseStatement.toString());

		ifElseStatement.getIfCompound().accept(this);
		ifElseStatement.getElseCompound().accept(this);

		return ifElseStatement;
	}

	@Override
	public Statement visit(final Question question) {
		assertIdentifierAndAddToEnvironment(question.getIdentifier(),
				question.getDataType());
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
			typeErrors.add(new TypeCheckException(e.getMessage(), e));
		}
	}

	private void visitExpression(final Expression expression) {
		expression.accept(expressionTypeChecker);
	}

	private void assertIdentifierAndAddToEnvironment(
			final Identifier identifier, final Expression expression) {
		identifier.accept(expressionTypeChecker);

		try {
			checked.assertTrue(!identifier.getName().isEmpty(), expression
					+ " identifier cannot be empty");

			checked.assertTrue(environment.get(identifier) == null,
					identifier.getName() + " already exists");

			environment.put(identifier, expression);
		} catch (ValidationException e) {
			typeErrors.add(new TypeCheckException(e.getMessage(), e));
		}
	}

	/**
	 * 
	 * @return a copy. Does not include expression type errors
	 */
	public List<TypeCheckException> getTypeErrors() {
		return new ArrayList<TypeCheckException>(typeErrors);
	}

	/**
	 * 
	 * @return all error types including expression type errors
	 */
	public List<TypeCheckException> getAllTypeErrors() {
		List<TypeCheckException> allErrors = new ArrayList<TypeCheckException>(
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
