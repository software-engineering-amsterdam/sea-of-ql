package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.rel.Eq;
import org.uva.sea.ql.ast.expr.rel.GEq;
import org.uva.sea.ql.ast.expr.rel.GT;
import org.uva.sea.ql.ast.expr.rel.LEq;
import org.uva.sea.ql.ast.expr.rel.LT;
import org.uva.sea.ql.ast.expr.rel.NEq;
import org.uva.sea.ql.ast.type.Type;

public interface ExpressionSemanticVisitor {
	
	public Type visit(Ident ident); 
	public Type visit(Add node);
	public Type visit(Sub node);	
	public Type visit(Mul node);	
	public Type visit(Div node);
	public Type visit(Eq node);
	public Type visit(NEq node);
	public Type visit(GEq node);
	public Type visit(LEq node);
	public Type visit(GT node);
	public Type visit(LT node);
}
