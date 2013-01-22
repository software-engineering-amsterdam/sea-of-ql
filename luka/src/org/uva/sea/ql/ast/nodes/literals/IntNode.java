package org.uva.sea.ql.ast.nodes.literals;

import java.util.Map;

import org.uva.sea.ql.ast.nodes.Expr;
import org.uva.sea.ql.ast.nodes.Ident;
import org.uva.sea.ql.ast.type.Type;

public class IntNode extends Expr{

	public IntNode(Integer val){
		
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

}
