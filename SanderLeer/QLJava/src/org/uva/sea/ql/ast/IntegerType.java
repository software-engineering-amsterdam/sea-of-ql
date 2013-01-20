package org.uva.sea.ql.ast;

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
