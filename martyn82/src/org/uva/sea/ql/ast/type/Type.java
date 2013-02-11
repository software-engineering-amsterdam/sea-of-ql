package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.TypeVisitor;

abstract public class Type extends Node {

	abstract public String getName();

	abstract public <T> T accept( TypeVisitor<T> visitor );

	abstract public boolean isCompatibleTo( Type type );

	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToBool() {
		return false;
	}

	public boolean isCompatibleToNumber() {
		return false;
	}

	public boolean isCompatibleToStr() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}
}
