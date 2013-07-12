package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.binaryexpr.*;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.ast.primaryexpr.*;

public interface IExpressionVisitor<T> {
	T visit(Add exp);	
	T visit(Div exp);	
	T visit(Mul exp);	
	T visit(Sub exp);	
	T visit(And exp);	
	T visit(Eq exp);	
	T visit(GEq exp);	
	T visit(GT exp);	
	T visit(LEq exp);	
	T visit(LT exp);	
	T visit(NEq exp);	
	T visit(Or exp);
	
	T visit(Neg exp);
	T visit(Pos exp);
	T visit(Not exp);
	
	T visit(Ident exp);
	T visit(Int exp);
	T visit(Str exp);
	T visit(Bool exp);
}
