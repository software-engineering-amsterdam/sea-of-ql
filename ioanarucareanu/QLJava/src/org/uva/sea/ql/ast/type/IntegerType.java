package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.value.IntegerVal;
import org.uva.sea.ql.ast.expr.value.Val;

public class IntegerType extends Type {

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

	@Override
	public Val createValOfType() {
		
		return new IntegerVal();
	}

}
