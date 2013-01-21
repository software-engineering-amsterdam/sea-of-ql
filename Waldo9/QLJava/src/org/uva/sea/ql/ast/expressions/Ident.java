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
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		super.accept(visitor);
		return visitor.visit(this);
    }

}
