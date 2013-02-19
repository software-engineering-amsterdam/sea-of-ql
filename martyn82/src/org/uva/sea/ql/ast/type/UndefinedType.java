package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.TypeVisitor;

public class UndefinedType extends Type {
	public static final UndefinedType UNDEFINED = new UndefinedType();

	private UndefinedType() {}

	@Override
	public <T> T accept( TypeVisitor<T> visitor ) {
		return null;
	}

	@Override
	public boolean isCompatibleTo( Type type ) {
		return false;
	}

	@Override
	public String getName() {
		return "Undefined";
	}
}
