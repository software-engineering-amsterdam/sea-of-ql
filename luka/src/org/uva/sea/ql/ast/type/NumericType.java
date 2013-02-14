package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Value;

public class NumericType extends Type{

	public boolean isCompatibleTo(Type t) {
	     return t.isCompatibleToNumeric();
	  }
	  public boolean isCompatibleToInt() {
	     return true;
	}
	  public boolean isCompatibleToMoney() {
	     return true;
	}
	  public boolean isCompatibleToNumeric() {
	     return true;
	}
	@Override
	public Value getDefaultValue() {
		return new Int(0);
	}

	
}
