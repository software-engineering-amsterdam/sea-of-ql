package org.uva.sea.ql.ast.datatype;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class IntegerType extends Datatype {
	private int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.setDefined();
		this.value = value;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
