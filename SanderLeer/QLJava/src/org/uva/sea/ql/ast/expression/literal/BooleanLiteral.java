package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class BooleanLiteral extends Literals {
	private final boolean value;
	
	public BooleanLiteral(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
