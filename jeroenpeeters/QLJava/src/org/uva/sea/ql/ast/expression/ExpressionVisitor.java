package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntLiteral;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;

public interface ExpressionVisitor<T> {
	
	T visit(Identifier identifier);

	// literals
	
	T visit(BooleanLiteral literal);
	
	T visit(IntLiteral literal);
	
	T visit(TextLiteral literal);

	// Binary expressions

	T visit(Add expression);

	T visit(Div expression);

	T visit(Mul expression);

	T visit(Sub expression);

	T visit(And expression);

	T visit(Eq expression);

	T visit(GEq expression);

	T visit(LEq expression);

	T visit(GT expression);
	
	T visit(LT expression);

	T visit(NEq expression);

	T visit(Or expression);

	// Unary

	T visit(Neg expression);

	T visit(Pos expression);

	T visit(Not expression);
	
}
