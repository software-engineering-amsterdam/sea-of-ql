package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.ITypeVisitor;

public abstract class AType implements ASTNode {

	public abstract boolean isCompatibleTo(AType t);
	public abstract <T> T accept(ITypeVisitor<T> visitor);
	
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