package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.FormVisitor;

public abstract class Type implements ASTNode {
	private boolean computated = false;
	private Expr expr;
	
	public void add(Expr expr) {
		this.computated = true;
		this.expr = expr;	
	}

	public boolean isComputated() {
		return computated;
	}

	public void setComputated(boolean computated) {
		this.computated = computated;
	}

	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public void accept(FormVisitor visitor) {
		if (isComputated()) {
			getExpr().accept(visitor);
		}
		visitor.visit(this);	
	}
}
