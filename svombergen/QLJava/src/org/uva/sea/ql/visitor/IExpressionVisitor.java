package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.binaryexpr.*;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.ast.primaryexpr.*;

public interface IExpressionVisitor {
	public void visit(Add exp);	
	public void visit(Div exp);	
	public void visit(Mul exp);	
	public void visit(Sub exp);	
	public void visit(And exp);	
	public void visit(Eq exp);	
	public void visit(GEq exp);	
	public void visit(GT exp);	
	public void visit(LEq exp);	
	public void visit(LT exp);	
	public void visit(NEq exp);	
	public void visit(Or exp);
	
	public void visit(Neg exp);
	public void visit(Pos exp);
	public void visit(Not exp);
	
	public void visit(Ident exp);
	public void visit(Int exp);
	public void visit(Str exp);
	public void visit(Bool exp);
}
