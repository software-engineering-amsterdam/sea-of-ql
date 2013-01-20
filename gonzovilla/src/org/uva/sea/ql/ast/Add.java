package org.uva.sea.ql.ast;

public class Add extends Binary {

	public Add(Expr lhs, Expr rhs) {
		super(lhs,rhs);
	}

	@Override
	public Value eval() {
		return new Int(((Int)getLeft().eval()).getValue() + 
					   ((Int)getRight().eval()).getValue()); 
	}
	
}
