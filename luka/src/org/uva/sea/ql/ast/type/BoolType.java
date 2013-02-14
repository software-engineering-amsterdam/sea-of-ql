package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.Bool;
import org.uva.sea.ql.ast.nodes.values.Value;


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
	
	@Override
	public String toString() {
		return "BoolType";
	}

	@Override
	public Value getDefaultValue() {
		return new Bool(false);
	}
}
