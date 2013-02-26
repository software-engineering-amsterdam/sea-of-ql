package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.util.Environment;

public class Ident extends Expr implements Comparable<Ident>{

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	
	@Override
	public boolean equals(Object other){
		return name.equals(((Ident)other).getName());
	}
	
	
	@Override
	public int compareTo(Ident other){
		return name.compareTo(other.getName());
	}
	
	
	@Override
	public Type typeOf(Environment env){
		
		if(env.containsValue(this)){
			return env.getValue(this).typeOf(env);
		}
		
		return new org.uva.sea.ql.ast.types.Undefined(); //undefined type
	}
	
	
	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
	
}
