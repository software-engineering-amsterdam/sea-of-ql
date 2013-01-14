package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.values.Int;


public class Add extends Binary {

	public Add(Expr result, Expr rhs) {
		super(result,rhs);
	}
	
	@Override
	public Value eval() {
		return new Int(
				((Int)getLeft().eval()).getValue() + 
				((Int)getRight().eval()).getValue()
				); 
	}
}
