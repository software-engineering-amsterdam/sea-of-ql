package org.uva.sea.ql.ast;

public class StringType extends Datatype {
	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

}
