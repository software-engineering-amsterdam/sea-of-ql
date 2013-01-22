package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class IntType extends NumericType{

	

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}
   
	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToIntType(); 
	}
	
	@Override
	public boolean isCompatibleToIntType() {
		return true;
	} 
	
	
	

}
