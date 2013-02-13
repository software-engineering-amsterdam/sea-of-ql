package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Ident extends Expr {
	//private final Value value;
	private String name;
	
	public Ident(String idName) { 
		
		//super(this);
		this.name = idName;
	}
	
	@Override
	public String toString() {
		return "Ident:"+this.name;
	}
	public Ident(){
		
	}
	public String getName(){
		return this.name;
	}

	@Override
	   public Type typeOf(Map<Ident, Type> typeEnv) {
	     if (typeEnv.containsKey(this)) {
	        return typeEnv.get(this);
	     }
	     return null;//TODO new Error();
	   }
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
