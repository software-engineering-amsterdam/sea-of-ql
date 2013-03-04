package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.conditional.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.ast.operators.unary.*;

public interface ExpressionVisitor<T> {
	
	// Primitive types
	T visit(BooleanLiteral booleanLiteral);
	T visit(Identifier identifier);
	T visit(IntLiteral integerLiteral);
	T visit(StringLiteral stringLiteral);

	// Arithmetic operators
	T visit(Add add);
	T visit(Div div);
	T visit(Sub sub);
	T visit(Mul mul);
	
	// Conditional operators
	T visit(And and);
	T visit(Or or);
	
	// Relational operators
	T visit(Eq eq);
	T visit(GEq gEq);
	T visit(GT gT);
	T visit(LEq lEq);
	T visit(LT lT);
	T visit(NEq nEq);
	
	// Unary operators
	T visit(Neg neg);
	T visit(Not not);
	T visit(Pos pos);
}
