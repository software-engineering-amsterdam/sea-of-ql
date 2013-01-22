package org.uva.sea.ql.ast.nodes;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;

public class Neg extends UnaryExpr{

	public Neg(Expr expr){
		super(expr);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}
}
