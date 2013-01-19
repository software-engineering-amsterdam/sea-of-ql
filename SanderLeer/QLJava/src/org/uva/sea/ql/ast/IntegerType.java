package org.uva.sea.ql.ast;

public class IntegerType extends Datatype {
	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
