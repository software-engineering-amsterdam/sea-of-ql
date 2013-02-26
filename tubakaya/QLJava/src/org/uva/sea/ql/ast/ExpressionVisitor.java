package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.operators.arithmetic.Add;
import org.uva.sea.ql.ast.operators.arithmetic.Div;
import org.uva.sea.ql.ast.operators.arithmetic.Mul;
import org.uva.sea.ql.ast.operators.arithmetic.Sub;
import org.uva.sea.ql.ast.operators.conditional.*;
import org.uva.sea.ql.ast.operators.relational.Eq;
import org.uva.sea.ql.ast.operators.relational.GEq;
import org.uva.sea.ql.ast.operators.relational.GT;
import org.uva.sea.ql.ast.operators.relational.LEq;
import org.uva.sea.ql.ast.operators.relational.LT;
import org.uva.sea.ql.ast.operators.relational.NEq;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;
import org.uva.sea.ql.ast.types.primitive.BooleanLiteral;
import org.uva.sea.ql.ast.types.primitive.IntLiteral;
import org.uva.sea.ql.ast.types.primitive.MoneyLiteral;
import org.uva.sea.ql.ast.types.primitive.StringLiteral;

public interface ExpressionVisitor {
	
	// Primitive types
	void visit(BooleanLiteral booleanLiteral);
	void visit(Identifier identifier);
	void visit(IntLiteral integerLiteral);
	void visit(MoneyLiteral moneyLiteral);
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
