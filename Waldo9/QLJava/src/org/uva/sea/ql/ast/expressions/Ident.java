package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void accept(ASTNodeVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
    }

}
