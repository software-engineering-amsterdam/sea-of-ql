package org.uva.sea.ql.visitor;

import static julius.validation.Assertions.checked;
import static julius.validation.Assertions.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import julius.validation.ValidationException;

import org.uva.sea.ql.ast.Natural;
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

	private final Map<Natural, Natural> environment = new HashMap<Natural, Natural>();

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
	 * Checks whethere the given expression is of the boolean nature or refers to any expression
	 * with such nature.
	 * 
	 * @param naturalExpression
	 * @param reference
	 */
	private void assertIfStatementExpression(final Natural naturalExpression,
			final String reference) {
		if (environment.get(naturalExpression) != null) {
			assertSameNature(new BooleanType(), environment.get(naturalExpression),
					reference);
		} else {
			assertSameNature(new BooleanType(), naturalExpression, reference);
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

	private void assertSameNature(final Natural natural,
			final Natural natural2, final String reference) {

		try {
			checked.assertTrue(natural.getNature() == natural2.getNature(),
					natural + " does not match " + natural2 + " for "
							+ reference);

		} catch (ValidationException e) {
			typeErrors.add(new TypeCheckException(e.getMessage(), e));
		}
	}

	private void visitExpression(final Natural expression) {
		expression.accept(expressionTypeChecker);
	}

	/**
	 * This method asserts the identifier is not empty an non existing in the environment
	 * 
	 * @param identifier
	 * @param natural
	 *            is the expression to which the identifier refers
	 */
	private void assertIdentifierAndAddToEnvironment(
			final Identifier identifier, final Natural natural) {
		identifier.accept(expressionTypeChecker);

		try {
			checked.assertTrue(!identifier.getName().isEmpty(), natural
					+ " identifier cannot be empty");

			checked.assertTrue(environment.get(identifier) == null,
					identifier.getName() + " already exists");

			environment.put(identifier, natural);
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
