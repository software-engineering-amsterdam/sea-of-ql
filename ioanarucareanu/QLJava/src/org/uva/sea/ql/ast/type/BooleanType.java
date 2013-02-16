package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.value.BooleanValue;
import org.uva.sea.ql.ast.expr.value.Value;

public class BooleanType extends Type {

	public BooleanType() {
		
	}
	
	@Override
	public Value<?> createValueOfType() {

		return new BooleanValue();
	}

	@Override
	public String toString() {
		
		return "boolean";
	}
	
	public boolean equals(Object obj){
		if (this == obj) {
			return true;
		}
		return getClass().equals(obj.getClass()); 
	}

}
