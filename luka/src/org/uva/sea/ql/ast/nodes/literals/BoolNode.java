package org.uva.sea.ql.ast.nodes.literals;

import java.util.Map;

import org.uva.sea.ql.ast.nodes.Expr;
import org.uva.sea.ql.ast.nodes.Ident;
import org.uva.sea.ql.ast.type.Type;

public class BoolNode extends Expr{

	private final String value;
	
	public BoolNode(String val){
		this.value = val;
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

}
