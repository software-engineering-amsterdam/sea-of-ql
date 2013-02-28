package org.uva.sea.ql.ast.type;


public class IntType extends NumericType{

	@Override
	public String toString(){
		return "integer";
	}
	
	public <T> T accept(IVisitorType<T> visitor){
		return visitor.visit(this);
	}
}
