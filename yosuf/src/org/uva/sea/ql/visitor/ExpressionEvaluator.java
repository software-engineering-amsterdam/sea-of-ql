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
import org.uva.sea.ql.ast.value.NumericValue;
import org.uva.sea.ql.ast.value.StringValue;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.lead.Model;

/**
 * Visitor representing the expression evaluator. Expression which does not have a known value will
 * throw {@link UnmodifiedException}.
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
		NumericValue leftVal = (NumericValue) add.getLeft().accept(this);
		NumericValue rightVal = (NumericValue) add.getRight().accept(this);

		return new NumericValue(leftVal.getValue() + rightVal.getValue());
	}

	@Override
	public BooleanValue visit(final And and) {
		BooleanValue leftVal = (BooleanValue) and.getLeft().accept(this);
		BooleanValue rightVal = (BooleanValue) and.getRight().accept(this);

		return new BooleanValue(leftVal.getValue() && rightVal.getValue());
	}

	@Override
	public NumericValue visit(final Divide divide) {
		NumericValue left = (NumericValue) divide.getLeft().accept(this);
		NumericValue right = (NumericValue) divide.getRight().accept(this);

		return new NumericValue(left.getValue() / right.getValue());
	}

	@Override
	public NumericValue visit(final Multiply multiply) {
		NumericValue left = (NumericValue) multiply.getLeft().accept(this);
		NumericValue right = (NumericValue) multiply.getRight().accept(this);

		return new NumericValue(left.getValue() * right.getValue());
	}

	@Override
	public NumericValue visit(final Substitute substitute) {
		NumericValue left = (NumericValue) substitute.getLeft().accept(this);
		NumericValue right = (NumericValue) substitute.getRight().accept(this);

		return new NumericValue(left.getValue() - right.getValue());
	}

	@Override
	public BooleanValue visit(final Equals equals) {
		NumericValue left = (NumericValue) equals.getLeft().accept(this);
		NumericValue right = (NumericValue) equals.getRight().accept(this);

		return new BooleanValue(left.getValue() == right.getValue());
	}

	@Override
	public BooleanValue visit(final GreaterOrEquals greaterOrEquals) {
		NumericValue left = (NumericValue) greaterOrEquals.getLeft().accept(this);
		NumericValue right = (NumericValue) greaterOrEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() >= right.getValue());
	}

	@Override
	public BooleanValue visit(final GreaterThan greaterThan) {
		NumericValue left = (NumericValue) greaterThan.getLeft().accept(this);
		NumericValue right = (NumericValue) greaterThan.getRight().accept(this);
		return new BooleanValue(left.getValue() > right.getValue());
	}

	@Override
	public Value visit(final Identifier identifier) {
		Computed computed = model.getComputed(identifier);
		if (computed != null) {
			return computed.getExpression().accept(this);
		} else {
			throw new UnmodifiedException("The value for " + identifier + " not present");
		}
	}

	@Override
	public NumericValue visit(final Negative negative) {
		NumericValue value = (NumericValue) negative.getOperation().accept(this);
		return new NumericValue(value.getValue() - 1);
	}

	@Override
	public BooleanValue visit(final Not not) {
		BooleanValue value = (BooleanValue) not.getOperation().accept(this);
		return new BooleanValue(!value.getValue());
	}

	@Override
	public BooleanValue visit(final NotEquals notEquals) {
		NumericValue left = (NumericValue) notEquals.getLeft().accept(this);
		NumericValue right = (NumericValue) notEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() != right.getValue());
	}

	@Override
	public BooleanValue visit(final Or or) {
		BooleanValue left = (BooleanValue) or.getLeft().accept(this);
		BooleanValue right = (BooleanValue) or.getRight().accept(this);

		return new BooleanValue(left.getValue() || right.getValue());
	}

	@Override
	public NumericValue visit(final Positive positive) {
		NumericValue value = (NumericValue) positive.getOperation().accept(this);
		return new NumericValue(value.getValue() + 1);
	}

	@Override
	public BooleanValue visit(final SmallerOrEquals smallerOrEquals) {
		NumericValue left = (NumericValue) smallerOrEquals.getLeft().accept(this);
		NumericValue right = (NumericValue) smallerOrEquals.getRight().accept(this);

		return new BooleanValue(left.getValue() <= right.getValue());
	}

	@Override
	public BooleanValue visit(final SmallerThan smallerThan) {
		NumericValue left = (NumericValue) smallerThan.getLeft().accept(this);
		NumericValue right = (NumericValue) smallerThan.getRight().accept(this);

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
}
