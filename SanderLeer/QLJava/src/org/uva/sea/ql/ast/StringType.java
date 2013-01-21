package org.uva.sea.ql.ast;

public class StringType extends Datatype {
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.setDefined();
		this.value = value;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

}
