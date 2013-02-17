package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.value.DecimalVal;
import org.uva.sea.ql.ast.expr.value.Val;

public class MoneyType extends Type {

	@Override
	public String toString() {
		
		return "money";
	}

	@Override
	public Val createValOfType() {
		// TODO Auto-generated method stub
		return new DecimalVal();
	}
	
	

}
