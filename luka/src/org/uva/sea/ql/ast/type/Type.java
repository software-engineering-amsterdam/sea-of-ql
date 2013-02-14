package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;

public abstract class Type {

	public abstract void accept(TypeVisitor visitor);
	public abstract Value getDefaultValue();

	public abstract boolean isCompatibleTo(Type t);

	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToNumeric() {
		return false;
	}

	public boolean isCompatibleToStr() {
		return false;
	}

	public boolean isCompatibleToBool() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}
	
	
}
