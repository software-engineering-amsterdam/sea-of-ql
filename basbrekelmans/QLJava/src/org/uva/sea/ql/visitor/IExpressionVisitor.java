package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expressions.*;

public interface IExpressionVisitor<T> {

	// expressions - binary - arithmetic
	public abstract T visit(Addition element);

	public abstract T visit(Division element);

	public abstract T visit(Multiplication element);

	public abstract T visit(Subtraction element);

	// expressions - binary - comparisons
	public abstract T visit(Equals element);

	public abstract T visit(GreaterThan element);

	public abstract T visit(GreaterThanOrEquals element);

	public abstract T visit(LessThan element);

	public abstract T visit(LessThanOrEquals element);

	public abstract T visit(NotEquals element);

	// expressions - binary - logical
	public abstract T visit(And element);

	public abstract T visit(Or element);

	public abstract T visit(Xor element);

	// expressions - simple
	public abstract T visit(BooleanLiteral element);

	public abstract T visit(IntegerLiteral element);

	public abstract T visit(MoneyLiteral element);

	public abstract T visit(StringLiteral element);

	public abstract T visit(Identifier element);

	// expressions - unary
	public abstract T visit(UnaryNot element);

	public abstract T visit(UnaryMinus element);

	public abstract T visit(UnaryPlus element);

}