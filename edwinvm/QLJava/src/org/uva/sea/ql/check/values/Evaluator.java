package org.uva.sea.ql.check.values;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.binary.BinaryExpression;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Addition;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Division;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Multiplication;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Subtraction;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyEquivalentExpression;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyNotEquivalentExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.EqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.NotEqualToExpression;
import org.uva.sea.ql.ast.expressions.unary.NegationalExpression;
import org.uva.sea.ql.ast.expressions.unary.NegativeExpression;
import org.uva.sea.ql.ast.expressions.unary.PositiveExpression;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpression;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.values.NullValue;
import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.check.ValueEnvironment;

public class Evaluator implements Visitor<Value> {
	
	private final ValueEnvironment _valueEnvironment;
	
	public Evaluator(ValueEnvironment valueEnvironment) {
		//_valueEnvironment = (ValueEnvironment) Collections.unmodifiableMap(valueEnvironment.getEnvironment());
		_valueEnvironment = valueEnvironment;
	}

	public static Value evaluate(Expression expression, ValueEnvironment valueEnvironment) {
		Evaluator evaluator = new Evaluator(valueEnvironment);
		return expression.accept(evaluator);
	}

	@Override
	public Value visit(Addition expression)                         { return getLeftHandSide(expression).add(getRightHandSide(expression)); }
	@Override
	public Value visit(Division expression)                         { return getLeftHandSide(expression).div(getRightHandSide(expression)); }
	@Override
	public Value visit(Subtraction expression)                      { return getLeftHandSide(expression).sub(getRightHandSide(expression)); }
	@Override
	public Value visit(Multiplication expression)                   { return getLeftHandSide(expression).mul(getRightHandSide(expression)); }
	
	@Override
	public Value visit(LogicallyEquivalentExpression expression)    { return getLeftHandSide(expression).and(getRightHandSide(expression)); }
	@Override
	public Value visit(LogicallyNotEquivalentExpression expression) { return getLeftHandSide(expression).or(getRightHandSide(expression));  }
	
	@Override
	public Value visit(EqualToExpression expression)                { return getLeftHandSide(expression).equalsValue(getRightHandSide(expression)); }
	@Override
	public Value visit(GreaterThanOrEqualToExpression expression)   { return getLeftHandSide(expression).greaterThanOrEqualTo(getRightHandSide(expression)); }
	@Override
	public Value visit(GreaterThanExpression expression)            { return getLeftHandSide(expression).greaterThan(getRightHandSide(expression)); }
	@Override
	public Value visit(LessThanOrEqualToExpression expression)      { return getLeftHandSide(expression).lessThanOrEqualTo(getRightHandSide(expression)); }
	@Override
	public Value visit(LessThanExpression expression)               { return getLeftHandSide(expression).lessThan(getRightHandSide(expression)); }
	@Override
	public Value visit(NotEqualToExpression expression)             { return getLeftHandSide(expression).notEqualsValue(getRightHandSide(expression)); }
	@Override
	public Value visit(NegativeExpression expression)               { return getValueFor(expression).setToNegative(); }
	@Override
	public Value visit(NegationalExpression expression)             { return getValueFor(expression).applyNegation(); }
	@Override
	public Value visit(PositiveExpression expression)               { return getValueFor(expression).setToPositive(); }
	
	@Override
	public Value visit(Bool value)                                  { return value; }
	@Override
	public Value visit(Int value)                                   { return value; }
	@Override
	public Value visit(Money value)                                 { return value; }
	@Override
	public Value visit(Str value)                                   { return value; }
	@Override
	public Value visit(NullValue astNode)                           { return new NullValue(); }
	
	@Override
	public Value visit(Identifier indentifier) {
		if (_valueEnvironment.contains(indentifier)) {
			return _valueEnvironment.get(indentifier);
		}
		return new NullValue();
	}
	
	private Value getLeftHandSide(BinaryExpression expression)  { return expression.getLeftHandSide().accept(this);  }
	private Value getRightHandSide(BinaryExpression expression) { return expression.getRightHandSide().accept(this); }
	private Value getValueFor(UnaryExpression expression)       { return expression.getExpression().accept(this);    }
	
}