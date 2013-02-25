package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;

public abstract class AType implements ASTNode {

	public abstract boolean isCompatibleTo(AType t);
	
	public boolean isCompatibleToInt() {
		return false;
	}
	
	public boolean isCompatibleToStr() {
		return false;
	}
	
	public boolean isCompatibleToBool() {
		return false;
	}
}