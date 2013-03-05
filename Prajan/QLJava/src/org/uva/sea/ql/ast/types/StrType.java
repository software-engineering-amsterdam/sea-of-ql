package org.uva.sea.ql.ast.types;

public class StrType extends Type{
	
	@Override
	public boolean isCompatibleTo(Type t){
		return t.isCompatibleToStr();
	}

	@Override
	public boolean isCompatibleToStr(){
		return true;
	}
}
