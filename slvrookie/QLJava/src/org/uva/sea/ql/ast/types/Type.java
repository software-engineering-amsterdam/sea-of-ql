package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitors.interfaces.ITypeVisitor;

public abstract class Type {

	public abstract <T> T accept(ITypeVisitor<T> Typevisitor);
	public abstract boolean isCompatibleTo(Type t);

	public boolean isCompatibleToIntType() {
		return false;
	}

	public boolean isCompatibleToNumeric() {
		return false;
	}

	public boolean isCompatibleToStringType() {
		return false;
	}

	public boolean isCompatibleToBoolType() {
		return false;
	}

	public boolean isCompatibleToMoneyType() {
		return false;
	}

	public boolean isCompatibleToErrorType() {
		return false;
	}

}
