package org.uva.sea.ql.ast.nodes;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;


public class LT extends BinaryExpr{

	//less then
	public LT(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
