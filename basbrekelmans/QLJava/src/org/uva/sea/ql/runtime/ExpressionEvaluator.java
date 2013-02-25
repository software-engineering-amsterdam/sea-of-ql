package org.uva.sea.ql.runtime;

import org.uva.sea.ql.ast.expressions.Addition;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.BooleanLiteral;
import org.uva.sea.ql.ast.expressions.Division;
import org.uva.sea.ql.ast.expressions.Equals;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.GreaterThan;
import org.uva.sea.ql.ast.expressions.GreaterThanOrEquals;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.IntegerLiteral;
import org.uva.sea.ql.ast.expressions.LessThan;
import org.uva.sea.ql.ast.expressions.LessThanOrEquals;
import org.uva.sea.ql.ast.expressions.MoneyLiteral;
import org.uva.sea.ql.ast.expressions.Multiplication;
import org.uva.sea.ql.ast.expressions.NotEquals;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.expressions.Subtraction;
import org.uva.sea.ql.ast.expressions.UnaryMinus;
import org.uva.sea.ql.ast.expressions.UnaryNot;
import org.uva.sea.ql.ast.expressions.UnaryPlus;
import org.uva.sea.ql.ast.expressions.Xor;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.runtime.values.BooleanValue;
import org.uva.sea.ql.runtime.values.IntegerValue;
import org.uva.sea.ql.runtime.values.MoneyValue;
import org.uva.sea.ql.runtime.values.StringValue;
import org.uva.sea.ql.runtime.values.Value;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class ExpressionEvaluator implements IExpressionEvaluator,
		IExpressionVisitor<Value> {

	private final Variables variables;

	public ExpressionEvaluator(final Variables variables) {
		this.variables = variables;
	}

	@Override
	public Value getValue(final Expression expr) {
		return expr.accept(this);
	}

	@Override
	public Value visit(final Addition element) {

		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.add(rightValue);
	}

	@Override
	public Value visit(final And element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.and(rightValue);
	}

	@Override
	public Value visit(final BooleanLiteral element) {
		return new BooleanValue(element.getValue());
	}

	@Override
	public Value visit(final Division element) {

		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.divide(rightValue);
	}

	@Override
	public Value visit(final Equals element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.equals(rightValue);
	}

	@Override
	public Value visit(final GreaterThan element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.greaterThan(rightValue);
	}

	@Override
	public Value visit(final GreaterThanOrEquals element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.greaterThanOrEquals(rightValue);
	}

	@Override
	public Value visit(final Identifier element) {
		final Variable variable = this.variables.get(element);
		if (!variable.hasValue()) {
			final Statement statement = this.variables.getStatement(element);
			if (statement.hasExpression()) {
				final Expression expression = statement.getExpression();
				final Value result = expression.accept(this);
				variable.setValue(result);
				return result;
			}
		}
		return variable.getValue();
	}

	@Override
	public Value visit(final IntegerLiteral element) {
		return new IntegerValue(element.getValue());
	}

	@Override
	public Value visit(final LessThan element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.lessThan(rightValue);
	}

	@Override
	public Value visit(final LessThanOrEquals element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.lessThanOrEquals(rightValue);
	}

	@Override
	public Value visit(final MoneyLiteral element) {
		return new MoneyValue(element.getValue());
	}

	@Override
	public Value visit(final Multiplication element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.multiply(rightValue);
	}

	@Override
	public Value visit(final NotEquals element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.notEquals(rightValue);
	}

	@Override
	public Value visit(final Or element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.or(rightValue);
	}

	@Override
	public Value visit(final StringLiteral element) {
		return new StringValue(element.getValue());
	}

	@Override
	public Value visit(final Subtraction element) {

		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.subtract(rightValue);
	}

	@Override
	public Value visit(final UnaryMinus element) {
		final Value operand = element.getOperand().accept(this);
		return operand.negate();
	}

	@Override
	public Value visit(final UnaryNot element) {
		final Value operand = element.getOperand().accept(this);
		return operand.not();
	}

	@Override
	public Value visit(final UnaryPlus element) {
		final Value operand = element.getOperand().accept(this);
		return operand.positive();
	}

	@Override
	public Value visit(final Xor element) {
		final Value leftValue = element.getLeft().accept(this);
		final Value rightValue = element.getRight().accept(this);
		return leftValue.xor(rightValue);
	}

}
