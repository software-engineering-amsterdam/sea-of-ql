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
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;
import org.uva.sea.ql.lead.Model;

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
	public IntegerValue visit(final Add add) {
		IntegerValue leftVal = add.getLeft().accept(this);
		IntegerValue rightVal = add.getRight().accept(this);

		return new IntegerValue(leftVal.getValue() + rightVal.getValue());
	}

	@Override
	public BooleanValue visit(final And and) {
		BooleanValue leftVal = and.getLeft().accept(this);
		BooleanValue rightVal = and.getRight().accept(this);

		return new BooleanValue(leftVal.getValue() && rightVal.getValue());
	}

	@Override
	public IntegerValue visit(final Divide divide) {
		IntegerValue left = divide.getLeft().accept(this);
		IntegerValue right = divide.getRight().accept(this);

		return new IntegerValue(left.getValue() / right.getValue());
	}

	@Override
	public IntegerValue visit(final Multiply multiply) {
		IntegerValue left = multiply.getLeft().accept(this);
		IntegerValue right = multiply.getRight().accept(this);

		return new IntegerValue(left.getValue() * right.getValue());
	}

	@Override
	public IntegerValue visit(final Substitute substitute) {
		IntegerValue left = substitute.getLeft().accept(this);
		IntegerValue right = substitute.getRight().accept(this);

		return new IntegerValue(left.getValue() - right.getValue());
	}

	@Override
	public BooleanValue visit(final Equals equals) {
		IntegerValue left = equals.getLeft().accept(this);
		IntegerValue right = equals.getRight().accept(this);

		return new BooleanValue(left.getValue() == right.getValue());
	}

	@Override
	public BooleanValue visit(final GreaterOrEquals greaterOrEquals) {
		IntegerValue left = greaterOrEquals.getLeft().accept(this);
		IntegerValue right = greaterOrEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() >= right.getValue());
	}

	@Override
	public BooleanValue visit(final GreaterThan greaterThan) {
		IntegerValue left = greaterThan.getLeft().accept(this);
		IntegerValue right = greaterThan.getRight().accept(this);
		return new BooleanValue(left.getValue() > right.getValue());
	}

	/**
	 * TODO
	 */
	@Override
	public Expression<?> visit(final Identifier identifier) {
		Computed computed = model.getComputed(identifier);
		if (computed != null) {
			return (Expression<?>) computed.getExpression().accept(this);
		} else {
			return identifier;
		}
	}

	@Override
	public IntegerValue visit(final Negative negative) {
		IntegerValue value = negative.getOperation().accept(this);
		return new IntegerValue(value.getValue() - 1);
	}

	@Override
	public BooleanValue visit(final Not not) {
		BooleanValue value = not.getOperation().accept(this);
		return new BooleanValue(!value.getValue());
	}

	@Override
	public BooleanValue visit(final NotEquals notEquals) {
		IntegerValue left = notEquals.getLeft().accept(this);
		IntegerValue right = notEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() != right.getValue());
	}

	@Override
	public BooleanValue visit(final Or or) {
		BooleanValue left = or.getLeft().accept(this);
		BooleanValue right = or.getRight().accept(this);

		return new BooleanValue(left.getValue() || right.getValue());
	}

	@Override
	public IntegerValue visit(final Positive positive) {
		IntegerValue value = positive.getOperation().accept(this);
		return new IntegerValue(value.getValue() + 1);
	}

	@Override
	public BooleanValue visit(final SmallerOrEquals smallerOrEquals) {
		IntegerValue left = smallerOrEquals.getLeft().accept(this);
		IntegerValue right = smallerOrEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() <= right.getValue());
	}

	@Override
	public BooleanValue visit(final SmallerThan smallerThan) {
		IntegerValue left = smallerThan.getLeft().accept(this);
		IntegerValue right = smallerThan.getRight().accept(this);

		return new BooleanValue(left.getValue() < right.getValue());
	}

	@Override
	public IntegerValue visit(final IntegerValue integerValue) {
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

}
