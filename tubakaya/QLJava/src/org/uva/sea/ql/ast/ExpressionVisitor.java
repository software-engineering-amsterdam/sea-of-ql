package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.conditional.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.types.literals.*;

public interface ExpressionVisitor {
	
	// Primitive types
	void visit(BooleanLiteral booleanLiteral);
	void visit(Identifier identifier);
	void visit(IntLiteral integerLiteral);
	void visit(StringLiteral stringLiteral);

	// Arithmetic operators
	void visit(Add add);
	void visit(Div div);
	void visit(Sub sub);
	void visit(Mul mul);
	
	// Conditional operators
	void visit(And and);
	void visit(Or or);
	
	// Relational operators
	void visit(Eq eq);
	void visit(GEq gEq);
	void visit(GT gT);
	void visit(LEq lEq);
	void visit(LT lT);
	void visit(NEq nEq);
	
	// Unary operators
	void visit(Neg neg);
	void visit(Not not);
	void visit(Pos pos);
}
