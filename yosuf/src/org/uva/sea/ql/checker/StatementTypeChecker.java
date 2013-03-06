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
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.exp.Bools;
import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Identifier;

/**
 * This class checks the statements semantically. To collect report whether the checker has
 * succeeded or not, {@link #isValid()}, {@link #getAllTypeErrors()} and {@link #getTypeErrors()}
 * could be used after the checking life cycle.
 */
public class StatementTypeChecker implements StatementVisitor<Block> {

	private final List<TypeCheckError> typeErrors = new ArrayList<TypeCheckError>();
	private final ExpressionTypeChecker expressionTypeChecker;

	private final Map<Identifier, Type> environment = new HashMap<Identifier, Type>();

	public StatementTypeChecker() {
		expressionTypeChecker = new ExpressionTypeChecker(environment);
		state.assertNotNull(expressionTypeChecker, "expressionTypeChecker");
	}

	@Override
	public Block visit(final Form form) {
		form.getBody().accept(this);
		assertIdentifierAndAddToEnvironment(form.getIdentifier(), form.getIdentifier().getType());

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

		assertIdentifierAndAddToEnvironment(computed.getIdentifier(), computed.getExpression()
				.getType());
		visitExpression(computed.getExpression());
		checkType(computed.getDataType().getType(), computed.getExpression().getType(),
				computed.toString());

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
	 * Checks whethere the given expression is of the boolean type or refers to any expression with
	 * the same type.
	 * 
	 * @param expression
	 * @param reference
	 */
	private void assertIfStatementExpression(final Expression expression, final String reference) {
		if (environment.get(expression) != null) {
			checkType(new Bools(), environment.get(expression), reference);
		} else {
			checkType(new Bools(), expression.getType(), reference);
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
		assertIdentifierAndAddToEnvironment(question.getIdentifier(), question.getDataType()
				.getType());
		return question;
	}

	private void checkType(final Type type1, final Type type2, final String reference) {

		if (!type1.equals(type2)) {
			typeErrors.add(new TypeCheckError(type1 + " does not match " + type2 + " for "
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
	 * @param type
	 *            is the expression to which the identifier refers
	 */
	private void assertIdentifierAndAddToEnvironment(final Identifier identifier, final Type type) {

		try {
			checked.assertTrue(!identifier.getName().isEmpty(), type
					+ " identifier cannot be empty");

			checked.assertTrue(environment.get(identifier) == null, identifier.getName()
					+ " already exists");

			environment.put(identifier, type);

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
