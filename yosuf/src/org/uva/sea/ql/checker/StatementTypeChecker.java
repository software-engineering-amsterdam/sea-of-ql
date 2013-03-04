package org.uva.sea.ql.checker;

import static julius.validation.Assertions.checked;
import static julius.validation.Assertions.state;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import julius.validation.ValidationException;

import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfElseStatement;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Natural;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.type.BooleanType;

/**
 * This class checks the statements semantically. To collect report whether the checker has
 * succeeded or not, {@link #isValid()}, {@link #getAllTypeErrors()} and {@link #getTypeErrors()}
 * could be used after the checking life cycle.
 */
public class StatementTypeChecker implements StatementVisitor<Block> {

	private final List<TypeCheckError> typeErrors = new ArrayList<TypeCheckError>();
	private final ExpressionTypeChecker expressionTypeChecker;

	private final Map<Identifier, Natural> environment = new HashMap<Identifier, Natural>();

	public StatementTypeChecker() {
		expressionTypeChecker = new ExpressionTypeChecker(environment);
		state.assertNotNull(expressionTypeChecker, "expressionTypeChecker");
	}

	@Override
	public Block visit(final Form form) {
		form.getBody().accept(this);
		assertIdentifierAndAddToEnvironment(form.getIdentifier(), form.getIdentifier());

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
	public Block visit(final Computed computed) {

		assertIdentifierAndAddToEnvironment(computed.getIdentifier(), computed.getExpression());
		visitExpression(computed.getExpression());
		checkNature(computed.getDataType(), computed.getExpression(), computed.toString());

		return computed;
	}

	@Override
	public Block visit(final IfStatement ifStatement) {
		visitExpression(ifStatement.getExpression());

		assertIfStatementExpression(ifStatement.getExpression(), ifStatement.toString());

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
	private void assertIfStatementExpression(final Natural naturalExpression, final String reference) {
		if (environment.get(naturalExpression) != null) {
			checkNature(new BooleanType(), environment.get(naturalExpression), reference);
		} else {
			checkNature(new BooleanType(), naturalExpression, reference);
		}
	}

	@Override
	public Block visit(final IfElseStatement ifElseStatement) {
		visitExpression(ifElseStatement.getExpression());

		assertIfStatementExpression(ifElseStatement.getExpression(), ifElseStatement.toString());

		ifElseStatement.getIfCompound().accept(this);
		ifElseStatement.getElseCompound().accept(this);

		return ifElseStatement;
	}

	@Override
	public Block visit(final Question question) {
		assertIdentifierAndAddToEnvironment(question.getIdentifier(), question.getDataType());
		return question;
	}

	private void checkNature(final Natural natural, final Natural natural2, final String reference) {

		if (!natural.getNature().equals(natural2.getNature())) {
			typeErrors.add(new TypeCheckError(natural + " does not match " + natural2 + " for "
					+ reference));
		}
	}

	private void visitExpression(final Expression expression) {
		expression.accept(expressionTypeChecker);
	}

	/**
	 * This method asserts the identifier is not empty an non existing in the environment
	 * 
	 * @param identifier
	 * @param natural
	 *            is the expression to which the identifier refers
	 */
	private void assertIdentifierAndAddToEnvironment(final Identifier identifier,
			final Natural natural) {

		try {
			checked.assertTrue(!identifier.getName().isEmpty(), natural
					+ " identifier cannot be empty");

			checked.assertTrue(environment.get(identifier) == null, identifier.getName()
					+ " already exists");

			environment.put(identifier, natural);

		} catch (ValidationException e) {
			typeErrors.add(new TypeCheckError(identifier.getName() + " already exists"));
		}
	}

	/**
	 * 
	 * @return a copy. Does not include expression type errors
	 */
	public Collection<TypeCheckError> getTypeErrors() {
		return new ArrayList<TypeCheckError>(typeErrors);
	}

	/**
	 * 
	 * @return all error types including expression type errors
	 */
	public Collection<TypeCheckError> getAllTypeErrors() {
		List<TypeCheckError> allErrors = new ArrayList<TypeCheckError>(typeErrors);
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
