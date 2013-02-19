package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.TypeVisitor;

public class NullType extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
	@Override
	public <T> T accept(TypeVisitor<T> visitor){
		return visitor.visit(this);
	}
}
