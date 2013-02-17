package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.value.StringVal;
import org.uva.sea.ql.ast.expr.value.Val;

public class StringType extends Type {

	@Override
	public String toString() {
		
		return "text";
	}

	@Override
	public Val createValOfType() {
		// TODO Auto-generated method stub
		return new StringVal();
	}

}
