package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class NotEquals extends Binary {

	public NotEquals(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
