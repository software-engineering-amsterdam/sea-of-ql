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
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.StringLiteral;


public interface IExpressionVisitor<T> {
	
	// Binary
	T visit(Add ast);
	T visit(And ast);
	T visit(Div ast);
	T visit(Eq  ast);
	T visit(GEq ast);
	T visit(GT  ast);
	T visit(LEq ast);
	T visit(LT  ast);
	T visit(Mul ast);
	T visit(NEq ast);
	T visit(Or  ast);
	T visit(Sub ast);
	
	// Unary
	T visit(Neg ast);
	T visit(Not ast);
	T visit(Pos ast);
	
	// Primary
	T visit(Bool  ast);
	T visit(Ident ast);
	T visit(Int   ast);
	T visit(StringLiteral ast);
}
