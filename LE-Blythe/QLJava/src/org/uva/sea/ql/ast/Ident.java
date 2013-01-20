package org.uva.sea.ql.ast;

import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Stack;

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
	
	
	public int compareTo(Ident other){
		return name.compareTo(other.getName());
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
