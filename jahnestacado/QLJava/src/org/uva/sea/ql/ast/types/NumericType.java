package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public  class NumericType extends Type{

	

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToNumericType();
	}
	
	@Override
	public boolean isCompatibleToNumericType() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToIntType() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToMoneyType() {
		return true;
	}
	
	

}
