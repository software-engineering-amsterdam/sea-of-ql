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
	T visit(Add add);
	T visit(And and);
	T visit(Div div);
	T visit(Eq eq);
	T visit(GEq geq);
	T visit(GT gt);
	T visit(LEq leq);
	T visit(LT lt);
	T visit(Mul mul);
	T visit(NEq neq);
	T visit(Or or);
	T visit(Sub sub);
	
	// Unary
	T visit(Neg neg);
	T visit(Not not);
	T visit(Pos pos);
	
	// Primary
	T visit(Bool bool);
	T visit(Ident ident);
	T visit(Int integer);
	T visit(StringLiteral stringLiteral);
}
