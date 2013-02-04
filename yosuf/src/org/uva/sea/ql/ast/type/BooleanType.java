package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class BooleanType extends DataType {
	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
