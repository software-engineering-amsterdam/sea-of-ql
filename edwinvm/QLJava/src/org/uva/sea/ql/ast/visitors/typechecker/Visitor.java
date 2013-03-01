package org.uva.sea.ql.ast.visitors.typechecker;

import org.uva.sea.ql.ast.expressions.Identifier;
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

public interface Visitor<T> {
	
	// Binary arithmetic expressions
	T visit(Addition                         astNode);
	T visit(Division                         astNode);
	T visit(Subtraction                      astNode);
	T visit(Multiplication                   astNode);
	
	// Binary logical expressions
	T visit(LogicallyEquivalentExpression    astNode);
	T visit(LogicallyEquivalentOrNotExpression astNode);
	
	// Binary relational expressions
	T visit(EqualToExpression                astNode);
	T visit(GreaterThanOrEqualToExpression   astNode);
	T visit(GreaterThanExpression            astNode);
	T visit(LessThanOrEqualToExpression      astNode);
	T visit(LessThanExpression               astNode);
	T visit(NotEqualToExpression             astNode);
	
	// Unary expressions
	T visit(NegativeExpression               astNode);
	T visit(NegationalExpression             astNode);
	T visit(PositiveExpression               astNode);
	
	// Literal expressions
	T visit(Bool                             astNode);
	T visit(Identifier                       astNode);
	T visit(Int                              astNode);
	T visit(Money                            astNode);
	T visit(Str                              astNode);
	T visit(NullValue 						 astNode);
	
}