package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class Type implements ASTNode {
	private String typeName;

	public Type(String typeName) {
		this.typeName = typeName;
	}
 
	public abstract Result getTypeContainer() ;
	
	public String getTypeName() {
		return typeName;
	}

	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public abstract boolean isCompatibleTo(Type t);

	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToString() {
		return false;
	}

	public boolean isCompatibleToBool() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}
}
