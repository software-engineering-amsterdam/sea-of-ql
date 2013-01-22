package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;


public interface ExpressionVisitor<T> {
	
	// Binary
	T visit(Add astNode);
	T visit(And astNode);
	T visit(Div astNode);
	T visit(Eq  astNode);
	T visit(GEq astNode);
	T visit(GT  astNode);
	T visit(LEq astNode);
	T visit(LT  astNode);
	T visit(Mul astNode);
	T visit(NEq astNode);
	T visit(Or  astNode);
	T visit(Sub astNode);
	
	// Unary
	T visit(Neg astNode);
	T visit(Not astNode);
	T visit(Pos astNode);
	
	// Primary
	T visit(Bool  astNode);
	T visit(Ident astNode);
	T visit(Int   astNode);
	T visit(StringLiteral astNode);
}
