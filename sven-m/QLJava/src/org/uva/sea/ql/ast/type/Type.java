package org.uva.sea.ql.ast.type;

public abstract class Type {
	
	public boolean equals(Type type) {
		return this.getClass() == type.getClass();
	}
	
}
