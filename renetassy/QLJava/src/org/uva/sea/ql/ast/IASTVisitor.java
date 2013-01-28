package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.*;

public interface IASTVisitor<T> {
	
	T visit(Add node);
	T visit(And node);
	T visit(Div node);
	T visit(Eq node);
	T visit(GEq node);
	T visit(GT node);
	T visit(Ident node);
	T visit(Int node);
	T visit(LEq node);
	T visit(LT node);
	T visit(Mul node);
	T visit(Neg node);
	T visit(NEq node);
	T visit(Not node);
	T visit(Or node);
	T visit(Pos node);
	T visit(Sub node);
	T visit(BoolLiteral node);
	T visit(StringLiteral node);
}
