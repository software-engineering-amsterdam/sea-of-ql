package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.expression.*;

public interface ExpressionVisitor<T> {
	/* binary operators */
	T visit(Add ast);
	T visit(Mul ast);
	T visit(Div ast);
	T visit(Sub ast);
	T visit(And ast);
	T visit(Or ast);
	T visit(LT ast);
	T visit(LEq ast);
	T visit(Eq ast);
	T visit(NEq ast);
	T visit(GEq ast);
	T visit(GT ast);
	
	/* unary operators */
	T visit(Pos ast);
	T visit(Neg ast);
	T visit(Not ast);
	
	/* leaf nodes */
	T visit(Ident ast);
	T visit(Int ast);
	T visit(Str ast);
}
