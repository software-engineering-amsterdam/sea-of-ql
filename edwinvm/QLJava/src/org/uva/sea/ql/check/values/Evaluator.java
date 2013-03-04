package org.uva.sea.ql.check.values;

import org.uva.sea.ql.ast.expressions.BinaryExpression;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.UnaryExpression;
import org.uva.sea.ql.ast.expressions.arithmetic.Addition;
import org.uva.sea.ql.ast.expressions.arithmetic.Division;
import org.uva.sea.ql.ast.expressions.arithmetic.Multiplication;
import org.uva.sea.ql.ast.expressions.arithmetic.NegativeExpression;
import org.uva.sea.ql.ast.expressions.arithmetic.PositiveExpression;
import org.uva.sea.ql.ast.expressions.arithmetic.Subtraction;
import org.uva.sea.ql.ast.expressions.logical.LogicallyEquivalentExpression;
import org.uva.sea.ql.ast.expressions.logical.LogicallyEquivalentOrNotExpression;
import org.uva.sea.ql.ast.expressions.logical.NegationalExpression;
import org.uva.sea.ql.ast.expressions.relational.EqualToExpression;
import org.uva.sea.ql.ast.expressions.relational.GreaterThanExpression;
import org.uva.sea.ql.ast.expressions.relational.GreaterThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.relational.LessThanExpression;
import org.uva.sea.ql.ast.expressions.relational.LessThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.relational.NotEqualToExpression;
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
		_valueEnvironment = valueEnvironment;
	}

	public static Value evaluate(Expression expression, ValueEnvironment valueEnvironment) {
		Evaluator evaluator = new Evaluator(valueEnvironment);
		return expression.accept(evaluator);
	}

	@Override
	public Value visit(Addition expression)                           { return getLeftHandSide(expression).add(getRightHandSide(expression)); }
	@Override
	public Value visit(Division expression)                           { return getLeftHandSide(expression).divideBy(getRightHandSide(expression));   }
	@Override
	public Value visit(Subtraction expression)                        { return getLeftHandSide(expression).subtractBy(getRightHandSide(expression)); }
	@Override
	public Value visit(Multiplication expression)                     { return getLeftHandSide(expression).multiplyBy(getRightHandSide(expression)); }
	
	@Override
	public Value visit(LogicallyEquivalentExpression expression)      { return getLeftHandSide(expression).isEquivalentTo(getRightHandSide(expression)); }
	@Override
	public Value visit(LogicallyEquivalentOrNotExpression expression) { return getLeftHandSide(expression).isEquivalentOrNotEquivalentTo(getRightHandSide(expression));  }
	
	@Override
	public Value visit(EqualToExpression expression)                  { return getLeftHandSide(expression).equalsValue(getRightHandSide(expression)); }
	@Override
	public Value visit(GreaterThanOrEqualToExpression expression)     { return getLeftHandSide(expression).isGreaterThanOrEqualTo(getRightHandSide(expression)); }
	@Override
	public Value visit(GreaterThanExpression expression)              { return getLeftHandSide(expression).isGreaterThan(getRightHandSide(expression)); }
	@Override
	public Value visit(LessThanOrEqualToExpression expression)        { return getLeftHandSide(expression).isLessThanOrEqualTo(getRightHandSide(expression)); }
	@Override
	public Value visit(LessThanExpression expression)                 { return getLeftHandSide(expression).isLessThan(getRightHandSide(expression)); }
	@Override
	public Value visit(NotEqualToExpression expression)               { return getLeftHandSide(expression).notEqualsValue(getRightHandSide(expression)); }
	@Override
	public Value visit(NegativeExpression expression)                 { return getValueFor(expression).setToNegative(); }
	@Override
	public Value visit(NegationalExpression expression)               { return getValueFor(expression).applyNegation(); }
	@Override
	public Value visit(PositiveExpression expression)                 { return getValueFor(expression).setToPositive(); }
	
	@Override
	public Value visit(Bool value)                                    { return value; }
	@Override
	public Value visit(Int value)                                     { return value; }
	@Override
	public Value visit(Money value)                                   { return value; }
	@Override
	public Value visit(Str value)                                     { return value; }
	@Override
	public Value visit(NullValue astNode)                             { return new NullValue(); }
	
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