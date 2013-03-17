package org.uva.sea.ql.gen;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.TypeVisitor;

public class TypeError extends Type {
	private final String typeErrorMessage;

	public TypeError(String typeErrorMessage) {
		this.typeErrorMessage = typeErrorMessage;
	}

	public String getTypeErrorMessage() {
		return typeErrorMessage;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public String toString() {
		return typeErrorMessage;
	}

	@Override
	public <T> T accept(TypeVisitor<T> typeVisitor) {
		return typeVisitor.visit(this);
	}

}
