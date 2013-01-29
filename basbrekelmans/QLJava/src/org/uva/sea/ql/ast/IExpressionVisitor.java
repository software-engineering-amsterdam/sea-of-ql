package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Addition;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.BooleanLiteral;
import org.uva.sea.ql.ast.expressions.Division;
import org.uva.sea.ql.ast.expressions.Equals;
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

public interface IExpressionVisitor<T> {

	//expressions - binary - arithmetic
	public abstract T visit(Addition element);

	public abstract T visit(Division element);

	public abstract T visit(Multiplication element);

	public abstract T visit(Subtraction element);

	//expressions - binary - comparisons
	public abstract T visit(Equals element);

	public abstract T visit(GreaterThan element);

	public abstract T visit(GreaterThanOrEquals element);

	public abstract T visit(LessThan element);

	public abstract T visit(LessThanOrEquals element);

	public abstract T visit(NotEquals element);

	//expressions - binary - logical
	public abstract T visit(And element);

	public abstract T visit(Or element);

	public abstract T visit(Xor element);

	//expressions - simple
	public abstract T visit(BooleanLiteral element);

	public abstract T visit(IntegerLiteral element);

	public abstract T visit(MoneyLiteral element);

	public abstract T visit(StringLiteral element);
	
	public abstract T visit(Identifier element);

	//expressions - unary
	public abstract T visit(UnaryNot element);

	public abstract T visit(UnaryMinus element);

	public abstract T visit(UnaryPlus element);
	

}