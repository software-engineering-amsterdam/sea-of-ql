package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.TypeVisitor;

public class BooleanType extends Type {
	public final static BooleanType BOOLEAN = new BooleanType();

	private BooleanType() {}

	@Override
	public <T> T accept( TypeVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public boolean isCompatibleTo( Type type ) {
		return type.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public String getName() {
		return "Boolean";
	}
}
