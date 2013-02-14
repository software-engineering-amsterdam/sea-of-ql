package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Ident extends Expr {
	//private final Value value;
	private String name;
	
	public Ident(String idName) { 
		
		//super(this);
		this.name = idName;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		return ((Ident)obj).getName().equals(this.name);
	}



	@Override
	public String toString() {
		return this.name;
	}

	public String getName(){
		return this.name;
	}

	@Override
	   public Type typeOf(Map<Ident, Type> typeEnv) {
	     if (typeEnv.containsKey(this)) {
	        return typeEnv.get(this);
	     }
	     throw new RuntimeException("EROR, NOT IN ENV!");
	   }
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
