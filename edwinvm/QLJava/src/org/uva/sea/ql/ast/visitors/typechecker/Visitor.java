package org.uva.sea.ql.ast.visitors.typechecker;

import org.uva.sea.ql.ast.expressions.Identifier;
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
	T visit(LogicallyNotEquivalentExpression astNode);
	
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