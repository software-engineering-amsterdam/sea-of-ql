package org.uva.sea.ql.ast.types;


public class IntType extends NumericType{

	

	
   
	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToIntType(); 
	}
	
	@Override
	public boolean isCompatibleToIntType() {
		return true;
	} 
	
	@Override
	public boolean isCompatibleToMoneyType() {
		return false;
	}
	
	

}
