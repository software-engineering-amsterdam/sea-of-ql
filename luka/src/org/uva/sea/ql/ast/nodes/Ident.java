package org.uva.sea.ql.ast.nodes;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;

public class Ident extends Expr {


	public Ident(String n) { 
		
	}

	@Override
	   public Type typeOf(Map<Ident, Type> typeEnv) {
	     if (typeEnv.containsKey(this)) {
	        return typeEnv.get(this);
	     }
	     return null;//new Error();
	   }

}
