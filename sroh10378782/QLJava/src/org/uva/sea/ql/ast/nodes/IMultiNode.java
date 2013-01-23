package org.uva.sea.ql.ast.nodes;

import org.uva.sea.ql.ast.Expr;

public interface IMultiNode {
	public void addValues(Expr statement);
	public int getValuesCount();
	public Expr getValue(int key);
}
