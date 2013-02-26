package org.uva.sea.ql.ast.types;


public class Bool extends Type {

	@Override
	public String toString(){
		return "boolean";
	}
	
	public <T> T accept(IVisitorType<T> visitor){
		return visitor.visit(this);
	}
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}
	
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
}
