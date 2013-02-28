package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.typevisitor.Visitor;


public class Error extends Type {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
}