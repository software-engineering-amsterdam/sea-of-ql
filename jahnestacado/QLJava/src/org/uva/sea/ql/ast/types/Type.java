package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;


public abstract class Type extends ASTNode {
	
	public abstract boolean isCompatibleToType(Type type);
	
	public boolean isCompatibleToNumericType(){
		return false;
	}
	
	public boolean isCompatibleToIntType(){
		return false;
	}
	
	public boolean isCompatibleToMoneyType(){
		return false;
	}
	
	public boolean isCompatibleToBoolType(){
		return false;
	}
	
	public boolean isCompatibleToStringType(){
		return false;
	}
	
	public boolean isCompatibleToUndefinedType(){
		return false;
	}

}
