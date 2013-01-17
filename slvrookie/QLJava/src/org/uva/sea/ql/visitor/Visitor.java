package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expr.BinaryExpr;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.UnaryExpr;
import org.uva.sea.ql.ast.types.Type;

public interface Visitor {
	void visit(Expr expr);

	void visit(BinaryExpr expr);

	void visit(UnaryExpr expr);

	void visit(Type type);
	
}
