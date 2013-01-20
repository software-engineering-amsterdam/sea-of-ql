package org.uva.sea.ql.ast;

public class BooleanType extends Datatype {
	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
