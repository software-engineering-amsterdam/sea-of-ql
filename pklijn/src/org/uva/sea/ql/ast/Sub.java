package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Value;

public class Sub extends Binary {

	public Sub(Expr result, Expr rhs) {
		super(result,rhs);
	}
	
	@Override
	public Value eval() {
		return new Int(
				((Int)getLeft().eval()).getValue() - 
				((Int)getRight().eval()).getValue()
				); 
	}
}
