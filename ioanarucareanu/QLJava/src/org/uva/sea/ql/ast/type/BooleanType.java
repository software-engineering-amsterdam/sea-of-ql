package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.value.BooleanVal;
import org.uva.sea.ql.ast.expr.value.Val;

public class BooleanType extends Type {

	public BooleanType() {
		
	}
	
//	@Override
//	public Value createValueOfType() {
//
//		return new BooleanValue(false);
//	}

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

	@Override
	public Val createValOfType() {
		// TODO Auto-generated method stub
		return new BooleanVal();
	}


}
