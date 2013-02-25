package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expressions.Bool;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.Str;
import org.uva.sea.ql.ast.expressions.binaryExpr.Add;
import org.uva.sea.ql.ast.expressions.binaryExpr.And;
import org.uva.sea.ql.ast.expressions.binaryExpr.Div;
import org.uva.sea.ql.ast.expressions.binaryExpr.Eq;
import org.uva.sea.ql.ast.expressions.binaryExpr.GEq;
import org.uva.sea.ql.ast.expressions.binaryExpr.GT;
import org.uva.sea.ql.ast.expressions.binaryExpr.LEq;
import org.uva.sea.ql.ast.expressions.binaryExpr.LT;
import org.uva.sea.ql.ast.expressions.binaryExpr.Mul;
import org.uva.sea.ql.ast.expressions.binaryExpr.NEq;
import org.uva.sea.ql.ast.expressions.binaryExpr.Or;
import org.uva.sea.ql.ast.expressions.binaryExpr.Sub;
import org.uva.sea.ql.ast.expressions.unaryExpr.Neg;
import org.uva.sea.ql.ast.expressions.unaryExpr.Not;
import org.uva.sea.ql.ast.expressions.unaryExpr.Pos;

public interface ExprVisitor<T> {
	
	T visit(Bool ast);
	T visit(Ident ast);
	T visit(Int ast);
	T visit(Str ast);
	
	T visit(Add ast);
	T visit(And ast);
	T visit(Div ast);
	T visit(Eq ast);
	T visit(GEq ast);
	T visit(GT ast);
	T visit(LEq ast);
	T visit(LT ast);
	T visit(Mul ast);
	T visit(NEq ast);
	T visit(Or ast);
	T visit(Sub ast);
	
	T visit(Neg ast);
	T visit(Not ast);
	T visit(Pos ast);
}