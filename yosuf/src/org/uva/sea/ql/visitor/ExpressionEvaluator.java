package org.uva.sea.ql.visitor;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.Expression;
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
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.NumericValue;
import org.uva.sea.ql.ast.value.StringValue;
import org.uva.sea.ql.lead.Model;

/**
 * Visitor representing the expression evaluator.
 * 
 */
public class ExpressionEvaluator implements ExpressionVisitor {

	private final Model model;

	/**
	 * 
	 * @param model
	 *            (not null)
	 */
	public ExpressionEvaluator(final Model model) {
		this.model = model;
		state.assertNotNull(this.model, "ExpressionEvaluator.model");
	}

	@Override
	public NumericValue visit(final Add add) {
		NumericValue leftVal = add.getLeft().accept(this);
		NumericValue rightVal = add.getRight().accept(this);

		return new NumericValue(leftVal.getValue() + rightVal.getValue());
	}

	@Override
	public BooleanValue visit(final And and) {
		BooleanValue leftVal = and.getLeft().accept(this);
		BooleanValue rightVal = and.getRight().accept(this);

		return new BooleanValue(leftVal.getValue() && rightVal.getValue());
	}

	@Override
	public NumericValue visit(final Divide divide) {
		NumericValue left = divide.getLeft().accept(this);
		NumericValue right = divide.getRight().accept(this);

		return new NumericValue(left.getValue() / right.getValue());
	}

	@Override
	public NumericValue visit(final Multiply multiply) {
		NumericValue left = multiply.getLeft().accept(this);
		NumericValue right = multiply.getRight().accept(this);

		return new NumericValue(left.getValue() * right.getValue());
	}

	@Override
	public NumericValue visit(final Substitute substitute) {
		NumericValue left = substitute.getLeft().accept(this);
		NumericValue right = substitute.getRight().accept(this);

		return new NumericValue(left.getValue() - right.getValue());
	}

	@Override
	public BooleanValue visit(final Equals equals) {
		NumericValue left = equals.getLeft().accept(this);
		NumericValue right = equals.getRight().accept(this);

		return new BooleanValue(left.getValue() == right.getValue());
	}

	@Override
	public BooleanValue visit(final GreaterOrEquals greaterOrEquals) {
		NumericValue left = greaterOrEquals.getLeft().accept(this);
		NumericValue right = greaterOrEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() >= right.getValue());
	}

	@Override
	public BooleanValue visit(final GreaterThan greaterThan) {
		NumericValue left = greaterThan.getLeft().accept(this);
		NumericValue right = greaterThan.getRight().accept(this);
		return new BooleanValue(left.getValue() > right.getValue());
	}

	/**
	 * 
	 * @param identifier
	 * @return (maybe null if the expression referenced by identifier is not present)
	 */
	@Override
	public Expression<?> visit(final Identifier identifier) {
		Computed computed = model.getComputed(identifier);
		if (computed != null) {
			return (Expression<?>) computed.getExpression().accept(this);
		} else {
			throw new UnmodifiedException("The value for " + identifier
					+ " not present");
		}
	}

	@Override
	public NumericValue visit(final Negative negative) {
		NumericValue value = negative.getOperation().accept(this);
		return new NumericValue(value.getValue() - 1);
	}

	@Override
	public BooleanValue visit(final Not not) {
		BooleanValue value = not.getOperation().accept(this);
		return new BooleanValue(!value.getValue());
	}

	@Override
	public BooleanValue visit(final NotEquals notEquals) {
		NumericValue left = notEquals.getLeft().accept(this);
		NumericValue right = notEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() != right.getValue());
	}

	@Override
	public BooleanValue visit(final Or or) {
		BooleanValue left = or.getLeft().accept(this);
		BooleanValue right = or.getRight().accept(this);

		return new BooleanValue(left.getValue() || right.getValue());
	}

	@Override
	public NumericValue visit(final Positive positive) {
		NumericValue value = positive.getOperation().accept(this);
		return new NumericValue(value.getValue() + 1);
	}

	@Override
	public BooleanValue visit(final SmallerOrEquals smallerOrEquals) {
		NumericValue left = smallerOrEquals.getLeft().accept(this);
		NumericValue right = smallerOrEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() <= right.getValue());
	}

	@Override
	public BooleanValue visit(final SmallerThan smallerThan) {
		NumericValue left = smallerThan.getLeft().accept(this);
		NumericValue right = smallerThan.getRight().accept(this);

		return new BooleanValue(left.getValue() < right.getValue());
	}

	@Override
	public NumericValue visit(final NumericValue integerValue) {
		return integerValue;
	}

	@Override
	public BooleanValue visit(final BooleanValue booleanValue) {
		return booleanValue;
	}

	@Override
	public StringValue visit(final StringValue stringValue) {
		return stringValue;
	}

	public static class UnmodifiedException extends RuntimeException {

		private static final long serialVersionUID = -7226851035650176522L;
		private final String message;

		public UnmodifiedException(final String message) {
			super(message);
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;
		}
	}
}
