package org.uva.sea.ql.ast.visitors;

import org.uva.sea.ql.ast.expression.*;

public interface ExpressionVisitor<T> {
	
	T visit(Add ast);
	T visit(And ast);
	T visit (Bool ast);
	T visit(Div ast);
	T visit(Eq ast);
	T visit(GT ast);
	T visit(GEq ast);
	T visit(Ident ast);
	T visit(Int ast);
	T visit(LEq ast);
	T visit(LT ast);
	T visit(Mul ast);
	T visit(Neg ast);
	T visit(NEq ast);
	T visit(Not ast);
	T visit(Or ast);
	T visit(Pos ast);
	T visit(Str ast);
	T visit(Sub ast);
	
}
