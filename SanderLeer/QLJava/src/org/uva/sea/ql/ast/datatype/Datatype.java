package org.uva.sea.ql.ast.datatype;

import org.uva.sea.ql.ast.ASTNode;

public abstract class Datatype implements ASTNode {
	// keep track if a value is ever assigned to this datatype
	private boolean undefined = true;

	public abstract boolean isCompatibleTo(Datatype type);
	
	public boolean isCompatibleToBoolean() {
		return false;
	}
	
	public boolean isCompatibleToInteger() {
		return false;
	}
	
	public boolean isCompatibleToString() {
		return false;
	}

	// call this function when a derived class assigns a value to its datatype
	protected void setDefined() {
		this.undefined = false;
	}

	public boolean isUndefined() {
		return undefined;
	}
}
