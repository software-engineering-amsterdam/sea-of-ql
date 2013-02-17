package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitors.interfaces.ITypeVisitor;

public class ErrorType extends Type {

	public boolean isCompatibleTo(Type t) {
		return true;
	}

	public boolean isCompatibleToErrorType() {
		return true;
	}

	@Override
	public <T> T accept(ITypeVisitor<T> Typevisitor) {
		return null;
	}

}
