package org.uva.sea.ql.visitor;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
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
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.lead.Model;

public class ExpressionEvaluator implements ValuableVisitor<Value> {

	private final Model model;

	public ExpressionEvaluator(final Model model) {
		this.model = model;
		state.assertNotNull(this.model, "ExpressionEvaluator.model");
	}

	@Override
	public Value visit(final Add add) {
		IntegerValue left = (IntegerValue) add.getLeft().accept(this);
		IntegerValue right = (IntegerValue) add.getRight().accept(this);

		return new IntegerValue(left.getValue() + right.getValue());
	}

	@Override
	public Value visit(final Divide divide) {
		IntegerValue left = (IntegerValue) divide.getLeft().accept(this);
		IntegerValue right = (IntegerValue) divide.getRight().accept(this);

		return new IntegerValue(left.getValue() / right.getValue());
	}

	@Override
	public Value visit(final Multiply multiply) {
		IntegerValue left = (IntegerValue) multiply.getLeft().accept(this);
		IntegerValue right = (IntegerValue) multiply.getRight().accept(this);

		return new IntegerValue(left.getValue() * right.getValue());
	}

	@Override
	public Value visit(final Substitute substitute) {
		IntegerValue left = (IntegerValue) substitute.getLeft().accept(this);
		IntegerValue right = (IntegerValue) substitute.getRight().accept(this);

		return new IntegerValue(left.getValue() - right.getValue());
	}

	@Override
	public Value visit(final And and) {
		BooleanValue left = (BooleanValue) and.getLeft().accept(this);
		BooleanValue right = (BooleanValue) and.getRight().accept(this);

		return new BooleanValue(left.getValue() && right.getValue());
	}

	@Override
	public Value visit(final Equals equals) {
		IntegerValue left = (IntegerValue) equals.getLeft().accept(this);
		IntegerValue right = (IntegerValue) equals.getRight().accept(this);

		return new BooleanValue(left.getValue() == right.getValue());
	}

	@Override
	public Value visit(final GreaterOrEquals greaterOrEquals) {
		IntegerValue left = (IntegerValue) greaterOrEquals.getLeft().accept(
				this);
		IntegerValue right = (IntegerValue) greaterOrEquals.getRight().accept(
				this);

		return new BooleanValue(left.getValue() >= right.getValue());
	}

	@Override
	public Value visit(final GreaterThan greaterThan) {
		IntegerValue left = (IntegerValue) greaterThan.getLeft().accept(this);
		IntegerValue right = (IntegerValue) greaterThan.getRight().accept(this);
		return new BooleanValue(left.getValue() > right.getValue());
	}

	@Override
	public Value visit(final Identifier identifier) {
		Computed computed = model.getValue(identifier);
		if (computed != null) {
			return computed.getExpression().accept(this);
		} else {
			return null;
		}
	}

	@Override
	public Value visit(final Negative negative) {
		IntegerValue value = (IntegerValue) negative.getOperation()
				.accept(this);
		return new IntegerValue(value.getValue() - 1);
	}

	@Override
	public Value visit(final Not not) {
		BooleanValue value = (BooleanValue) not.getOperation().accept(this);
		return new BooleanValue(!value.getValue());
	}

	@Override
	public Value visit(final NotEquals notEquals) {
		IntegerValue left = (IntegerValue) notEquals.getLeft().accept(this);
		IntegerValue right = (IntegerValue) notEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() != right.getValue());
	}

	@Override
	public Value visit(final Or or) {
		BooleanValue left = (BooleanValue) or.getLeft().accept(this);
		BooleanValue right = (BooleanValue) or.getRight().accept(this);

		return new BooleanValue(left.getValue() || right.getValue());
	}

	@Override
	public Value visit(final Positive positive) {
		IntegerValue value = (IntegerValue) positive.getOperation()
				.accept(this);
		return new IntegerValue(value.getValue() + 1);
	}

	@Override
	public Value visit(final SmallerOrEquals smallerOrEquals) {
		IntegerValue left = (IntegerValue) smallerOrEquals.getLeft().accept(
				this);
		IntegerValue right = (IntegerValue) smallerOrEquals.getRight().accept(
				this);

		return new BooleanValue(left.getValue() <= right.getValue());
	}

	@Override
	public Value visit(final SmallerThan smallerThan) {
		IntegerValue left = (IntegerValue) smallerThan.getLeft().accept(this);
		IntegerValue right = (IntegerValue) smallerThan.getRight().accept(this);

		return new BooleanValue(left.getValue() < right.getValue());
	}

	@Override
	public Value visit(final IntegerValue integerValue) {
		return integerValue;
	}

	@Override
	public Value visit(final BooleanValue booleanValue) {
		return booleanValue;
	}

	@Override
	public Value visit(final StringValue stringValue) {
		return stringValue;
	}
}
