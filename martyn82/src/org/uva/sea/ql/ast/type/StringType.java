package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.TypeVisitor;

public class StringType extends Type {
	public final static StringType STRING = new StringType();

	private StringType() {}

	@Override
	public <T> T accept( TypeVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public boolean isCompatibleToStr() {
		return true;
	}

	@Override
	public boolean isCompatibleTo( Type type ) {
		return type.isCompatibleToStr();
	}

	@Override
	public String getName() {
		return "String";
	}
}
