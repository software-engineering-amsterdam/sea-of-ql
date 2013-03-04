package org.uva.sea.ql.ast.expressions.visitor;

import org.uva.sea.ql.ast.nodes.expressions.*;

public interface Visitor <T> {
	T visit(Add add);
	T visit(And and);
	T visit(Div div);
	T visit(Eq eq);
	T visit(GEq geq);
	T visit(GT gt);
	T visit(LEq leq);
	T visit(LT lt);
	T visit(Mul mul);
	T visit(Neg neg);
	T visit(NEq neq);
	T visit(Not not);
	T visit(Or or);
	T visit(Pos pos);
	T visit(Sub sub);
	T visit(Bool boolexpression);
	T visit(Int intexpression);
	T visit(Str strexpression);
	T visit(Money moneyexpression);
	T visit(Ident identexpression);
	T visit(CompBool strexpression);
	T visit(CompMoney moneyexpression);
	T visit(CompInt identexpression);
}