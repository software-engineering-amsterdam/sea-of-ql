package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Add extends Binary {

	public Add(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
