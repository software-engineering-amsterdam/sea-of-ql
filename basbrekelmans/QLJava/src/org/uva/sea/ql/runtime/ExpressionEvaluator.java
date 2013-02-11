package org.uva.sea.ql.runtime;

import org.uva.sea.ql.ast.IExpressionVisitor;
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

public class ExpressionEvaluator implements IExpressionEvaluator, IExpressionVisitor<Value> {

	private final RuntimeContext context;

	public ExpressionEvaluator(RuntimeContext context) {
		this.context = context;
	}
	
	@Override
	public Value getValue(Expression expr) {
		return expr.accept(this);
	}

	@Override
	public Value visit(Addition element) {

		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.add(rightValue);
	}

	@Override
	public Value visit(Division element) {

		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.divide(rightValue);
	}

	@Override
	public Value visit(Multiplication element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.multiply(rightValue);
	}

	@Override
	public Value visit(Subtraction element) {

		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.subtract(rightValue);
	}

	@Override
	public Value visit(Equals element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.equals(rightValue);
	}

	@Override
	public Value visit(GreaterThan element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.greaterThan(rightValue);
	}

	@Override
	public Value visit(GreaterThanOrEquals element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.greaterThanOrEquals(rightValue);
	}

	@Override
	public Value visit(LessThan element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.lessThan(rightValue);
	}

	@Override
	public Value visit(LessThanOrEquals element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.lessThanOrEquals(rightValue);
	}

	@Override
	public Value visit(NotEquals element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.notEquals(rightValue);
	}

	@Override
	public Value visit(And element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.and(rightValue);
	}

	@Override
	public Value visit(Or element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.or(rightValue);
	}

	@Override
	public Value visit(Xor element) {
		Value leftValue = element.getLeft().accept(this);
		Value rightValue = element.getRight().accept(this);
		return leftValue.xor(rightValue);
	}

	@Override
	public Value visit(BooleanLiteral element) {
		return new BooleanValue(element.getValue());
	}

	@Override
	public Value visit(IntegerLiteral element) {
		return new IntegerValue(element.getValue());
	}

	@Override
	public Value visit(MoneyLiteral element) {
		return new MoneyValue(element.getValue());
	}

	@Override
	public Value visit(StringLiteral element) {
		return new StringValue(element.getValue());
	}

	@Override
	public Value visit(Identifier element) {
		return context.getValue(element);
	}

	@Override
	public Value visit(UnaryNot element) {
		Value operand = element.getOperand().accept(this);
		return operand.not();
	}

	@Override
	public Value visit(UnaryMinus element) {
		Value operand = element.getOperand().accept(this);
		return operand.negate();
	}

	@Override
	public Value visit(UnaryPlus element) {
		Value operand = element.getOperand().accept(this);
		return operand.positive();
	}

}
