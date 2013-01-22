package org.uva.sea.ql.ast.type;

public class StringType extends Type{

	public StringType(){
		
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}
	
	@Override
	public boolean isCompatibleToStr(){
		return true;
	}
}
