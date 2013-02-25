package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.IParametrizedTypeVisitor;
import org.uva.sea.ql.visitor.ITypeVisitor;

public abstract class Type {

	public static final Type BOOLEAN = new BooleanType();

	public static final Type STRING = new StringType();

	public static final Type INTEGER = new IntegerType();

	public static final Type MONEY = new MoneyType();

	public static final Type UNKNOWN = new UnknownType();

	protected Type() {
	}

	public abstract <TParameter, TResult> TResult accept(
			IParametrizedTypeVisitor<TParameter, TResult> visitor,
			TParameter arg);

	public abstract <T> T accept(ITypeVisitor<T> visitor);

	public boolean isBoolean() {
		return false;
	}

	public boolean isNumber() {
		return false;
	}

	public boolean isString() {
		return false;
	}
}
