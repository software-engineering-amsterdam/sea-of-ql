package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Ident extends Expr {

	private final String name;

	public Ident(Ident ident) {
		this.name = ident.getName();
	}

	public Ident(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
