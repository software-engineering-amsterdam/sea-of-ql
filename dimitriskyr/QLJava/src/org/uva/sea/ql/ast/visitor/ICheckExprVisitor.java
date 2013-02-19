package org.uva.sea.ql.ast.visitor;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.values.*;

public interface ICheckExprVisitor <T>{
	
	
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
	T visit(Bool bool);
	T visit(Ident ident);
	T visit(Int integer);
	T visit(String_lit string_lit);
	T visit(Money money);

}
