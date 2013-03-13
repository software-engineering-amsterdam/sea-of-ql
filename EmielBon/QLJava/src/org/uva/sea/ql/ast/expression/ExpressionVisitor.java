package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.operators.logical.*;
import org.uva.sea.ql.ast.expression.operators.numeric.*;
import org.uva.sea.ql.ast.expression.operators.relational.*;

/**
 * Interface to enable double-dispatch visiting of expressions using the visitor pattern
 * @param <T> The return type of the visit method
 */
public interface ExpressionVisitor<T> {

	// Numeric operators
	T visit(Add expr);
	T visit(Div expr);
	T visit(Mul expr);
	T visit(Neg expr);
	T visit(Pos expr);
	T visit(Sub expr);
	
	// Logical operators
	T visit(And expr);
	T visit(Not expr);
	T visit(Or expr);
	
	// Relational operators
	T visit(Eq expr);
	T visit(GEq expr);
	T visit(GT expr);
	T visit(LEq expr);
	T visit(LT expr);
	T visit(NEq expr);
	
	// Identifier
	T visit(Identifier expr);
	
	// Literals
	T visit(BooleanLiteral expr);
	T visit(IntegerLiteral expr);
	T visit(StringLiteral expr);
	T visit(MoneyLiteral moneyLiteral);
	
}
