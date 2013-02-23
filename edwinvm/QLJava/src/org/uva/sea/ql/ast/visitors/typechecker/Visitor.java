package org.uva.sea.ql.ast.visitors.typechecker;

import org.uva.sea.ql.ast.expressions.binary.arithmetic.Addition;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Division;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Multiplication;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Subtraction;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyEquivalentExpression;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyNotEquivalentExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.EqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.NotEqualToExpression;
import org.uva.sea.ql.ast.expressions.literal.Bool;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Int;
import org.uva.sea.ql.ast.expressions.literal.Money;
import org.uva.sea.ql.ast.expressions.literal.Str;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;

public interface Visitor<T> {
	
	// Binary arithmetic expressions
	T visit(Addition ast);
	T visit(Division ast);
	T visit(Subtraction ast);
	T visit(Multiplication ast);
	
	// Binary logical expressions
	T visit(LogicallyEquivalentExpression ast);
	T visit(LogicallyNotEquivalentExpression ast);
	
	// Binary relational expressions
	T visit(EqualToExpression ast);
	T visit(GreaterThanOrEqualToExpression ast);
	T visit(GreaterThanExpression ast);
	T visit(LessThanOrEqualToExpression ast);
	T visit(LessThanExpression ast);
	T visit(NotEqualToExpression ast);
	
	// Unary expressions
	T visit(Neg ast);
	T visit(Not ast);
	T visit(Pos ast);
	
	// Literal expressions
	T visit(Bool ast);
	T visit(Ident ast);
	T visit(Int ast);
	T visit(Money money);
	T visit(Str str);
	
}