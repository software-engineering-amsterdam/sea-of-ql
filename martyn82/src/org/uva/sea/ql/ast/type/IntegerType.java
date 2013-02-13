package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.TypeVisitor;

public class IntegerType extends NumberType {
	public final static IntegerType INTEGER = new IntegerType();

	private IntegerType() {}

	@Override
	public <T> T accept( TypeVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public String getName() {
		return "Integer";
	}
}
