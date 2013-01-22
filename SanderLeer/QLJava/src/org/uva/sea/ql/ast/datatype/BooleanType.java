package org.uva.sea.ql.ast.datatype;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class BooleanType extends Datatype {
	private boolean value;
	
	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.setDefined();
		this.value = value;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
