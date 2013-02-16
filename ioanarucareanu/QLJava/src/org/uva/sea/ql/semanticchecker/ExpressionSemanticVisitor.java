package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.rel.Eq;
import org.uva.sea.ql.ast.expr.rel.GEq;
import org.uva.sea.ql.ast.expr.rel.GT;
import org.uva.sea.ql.ast.expr.rel.LEq;
import org.uva.sea.ql.ast.expr.rel.LT;
import org.uva.sea.ql.ast.expr.rel.NEq;

public interface ExpressionSemanticVisitor {
	
	public ReturnType visit(Ident ident); 
	public ReturnType visit(Add node);
	public ReturnType visit(Sub node);	
	public ReturnType visit(Mul node);	
	public ReturnType visit(Div node);
	public ReturnType visit(Eq node);
	public ReturnType visit(NEq node);
	public ReturnType visit(GEq node);
	public ReturnType visit(LEq node);
	public ReturnType visit(GT node);
	public ReturnType visit(LT node);
	public ReturnType visit(And node);
	public ReturnType visit(Or node);
}
