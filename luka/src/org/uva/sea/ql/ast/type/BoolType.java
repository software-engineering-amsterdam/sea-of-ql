package org.uva.sea.ql.ast.type;


public class BoolType extends Type {


	//Double dispatch
	@Override
	  public boolean isCompatibleTo(Type t){
		return t.isCompatibleToBool();
	}

	@Override
	  public boolean isCompatibleToBool() {
	     return true;
	}
	
}
