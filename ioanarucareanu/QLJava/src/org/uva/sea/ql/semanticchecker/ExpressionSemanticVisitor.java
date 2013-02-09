package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Sub;

public interface ExpressionSemanticVisitor {
	
	public void visit(Add node);
	public void visit(Sub node);	
	public void visit(Mul node);	
	public void visit(Div node);
}
