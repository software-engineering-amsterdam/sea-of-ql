package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.common.interfaces.TreeVisitor;

public class UnaryExpr extends Expr implements TreeNode {
	private Expr adjacent;

	public UnaryExpr(Expr ex) {
		this.adjacent = ex;
	}

	public final Expr getAdjacent() {
		return this.adjacent;
	}

    @Override
    public final void accept(TreeVisitor v) {
       v.visit(this);
    }
}
