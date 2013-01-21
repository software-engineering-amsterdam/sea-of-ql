package org.uva.sea.ql.ast.nodes;

import org.uva.sea.ql.ast.Expr;

public interface IUnaryNode {
	public String getValue();
	public Expr getExpr();
	public boolean hasExpr();
}