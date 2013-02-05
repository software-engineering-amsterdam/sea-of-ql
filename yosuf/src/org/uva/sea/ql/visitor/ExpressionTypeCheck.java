package org.uva.sea.ql.visitor;

import static julius.validation.Assertions.checked;

import java.util.ArrayList;
import java.util.List;

import julius.validation.ValidationException;

import org.jpatterns.gof.VisitorPattern.Visitor;
import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Expression.Nature;
import org.uva.sea.ql.ast.exp.GreaterOrEquals;
import org.uva.sea.ql.ast.exp.GreaterThan;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.exp.Multiply;
import org.uva.sea.ql.ast.exp.Negative;
import org.uva.sea.ql.ast.exp.Not;
import org.uva.sea.ql.ast.exp.NotEquals;
import org.uva.sea.ql.ast.exp.Or;
import org.uva.sea.ql.ast.exp.Positive;
import org.uva.sea.ql.ast.exp.SmallerOrEquals;
import org.uva.sea.ql.ast.exp.SmallerThan;
import org.uva.sea.ql.ast.exp.Substitute;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;

@Visitor
public class ExpressionTypeCheck implements ExpressionVisitor<Expression> {

	private final List<ValidationException> validationExceptions;

	public ExpressionTypeCheck() {
		validationExceptions = new ArrayList<ValidationException>();
	}

	public List<ValidationException> getValidationExceptions() {
		return validationExceptions;
	}

	@Override
	public Expression visit(final Add add) {
		assertNumeric(add.getRight().accept(this));
		assertNumeric(add.getLeft().accept(this));

		return add;
	}

	@Override
	public Expression visit(final IntegerValue integerValue) {
		return integerValue;
	}

	@Override
	public Expression visit(final And and) {
		assertBoolean(and.getLeft().accept(this));
		assertBoolean(and.getRight().accept(this));

		return and;
	}

	@Override
	public Expression visit(final Divide divide) {
		assertNumeric(divide.getRight().accept(this));
		assertNumeric(divide.getLeft().accept(this));

		return divide;
	}

	@Override
	public Expression visit(final Equals equals) {
		// Only numeric equals supported right now.
		assertNumeric(equals.getRight().accept(this));
		assertNumeric(equals.getLeft().accept(this));

		return equals;
	}

	@Override
	public Expression visit(final GreaterOrEquals greaterOrEquals) {
		assertNumeric(greaterOrEquals.getRight().accept(this));
		assertNumeric(greaterOrEquals.getLeft().accept(this));

		return greaterOrEquals;
	}

	@Override
	public Expression visit(final BooleanValue booleanValue) {
		return booleanValue;
	}

	@Override
	public Expression visit(final StringValue stringValue) {
		return stringValue;
	}

	@Override
	public Expression visit(final GreaterThan greaterThan) {
		assertNumeric(greaterThan.getRight().accept(this));
		assertNumeric(greaterThan.getLeft().accept(this));

		return greaterThan;
	}

	@Override
	public Expression visit(final Identifier identifier) {
		return identifier;
	}

	@Override
	public Expression visit(final Multiply multiply) {

		assertNumeric(multiply.getRight().accept(this));
		assertNumeric(multiply.getLeft().accept(this));

		return multiply;
	}

	@Override
	public Expression visit(final Negative negative) {
		assertNumeric(negative.getOperation());

		return negative;
	}

	@Override
	public Expression visit(final Not not) {
		assertBoolean(not.getOperation().accept(this));

		return not;
	}

	@Override
	public Expression visit(final NotEquals notEquals) {
		assertNumeric(notEquals.getRight().accept(this));
		assertNumeric(notEquals.getLeft().accept(this));

		return notEquals;
	}

	@Override
	public Expression visit(final Or or) {

		assertBoolean(or.getRight().accept(this));
		assertBoolean(or.getLeft().accept(this));

		return or;
	}

	@Override
	public Expression visit(final Positive positive) {
		assertNumeric(positive.getOperation().accept(this));

		return positive;
	}

	@Override
	public Expression visit(final SmallerOrEquals smallerOrEquals) {
		assertNumeric(smallerOrEquals.getRight().accept(this));
		assertNumeric(smallerOrEquals.getLeft().accept(this));

		return smallerOrEquals;
	}

	@Override
	public Expression visit(final SmallerThan smallerThan) {

		assertNumeric(smallerThan.getRight().accept(this));
		assertNumeric(smallerThan.getLeft().accept(this));

		return smallerThan;
	}

	@Override
	public Expression visit(final Substitute substitute) {

		assertNumeric(substitute.getRight().accept(this));
		assertNumeric(substitute.getLeft().accept(this));

		return substitute;
	}

	private void assertNumeric(final Expression expression) {
		assertNature(expression, Nature.NUMERIC);
	}

	private void assertBoolean(final Expression expression) {
		assertNature(expression, Nature.BOOLEAN);
	}

	private void assertNature(final Expression expression, final Nature nature) {
		try {
			checked.assertTrue(nature == expression.getNature(), "A " + nature
					+ " is incompatible with " + expression);
		} catch (ValidationException e) {
			validationExceptions.add(e);
		}
	}

}