package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class MoneyType extends NumericType {

	

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method 
	}
	
	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToMoneyType(); 
	}
	
	@Override
	public boolean isCompatibleToMoneyType() {
		return true;
	}

}
