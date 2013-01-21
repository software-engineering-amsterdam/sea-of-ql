package org.uva.sea.ql.ast.values;


import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Decimal extends Value {
    private final float value;
    
	public Decimal(float value) {
		this.value=value;
	}
	
	public float getValue(){
		return value;
	}
	

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub

	}

}
