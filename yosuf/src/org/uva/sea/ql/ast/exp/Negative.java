package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Negative extends Unary {

	public Negative(final Expression operation) {
		super(operation);
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
