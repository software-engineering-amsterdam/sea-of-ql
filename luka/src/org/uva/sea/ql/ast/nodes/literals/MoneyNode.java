package org.uva.sea.ql.ast.nodes.literals;

import java.util.Map;

import org.uva.sea.ql.ast.nodes.Expr;
import org.uva.sea.ql.ast.nodes.Ident;
import org.uva.sea.ql.ast.type.Type;

public class MoneyNode extends Expr{

	private final int value;
	
	public MoneyNode(int val){
		this.value = val;
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

}
