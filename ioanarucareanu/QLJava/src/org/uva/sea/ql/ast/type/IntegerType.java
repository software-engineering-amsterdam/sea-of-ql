package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.value.IntegerValue;
import org.uva.sea.ql.ast.expr.value.Value;

public class IntegerType extends Type {

	@Override
	public Value<?> createValueOfType() {
		
		return new IntegerValue();
	}

	@Override
	public String toString() {
		
		return "integer";
	}
	
	public boolean equals(Object obj){
		if (this == obj) {
			return true;
		}
		return getClass().equals(obj.getClass()); 
	}

}
