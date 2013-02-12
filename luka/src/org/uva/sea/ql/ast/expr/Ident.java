package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Ident extends Expr {

	//private final Value value;
	private final String name;
	public Ident(String idName) { 
		//super(e);
	//	this.value = v;
		this.name = idName;
	}

	@Override
	   public Type typeOf(Map<Ident, Type> typeEnv) {
	     if (typeEnv.containsKey(this)) {
	        return typeEnv.get(this);
	     }
	     return null;//TODO new Error();
	   }
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
