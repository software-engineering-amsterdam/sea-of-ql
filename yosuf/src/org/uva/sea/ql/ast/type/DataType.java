package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Natural;

public abstract class DataType implements Natural, ASTNode {

	protected DataType() {
		super();
	}

	public abstract <T> T accept(final DataTypeVisitor<T> visitor);

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [Nature=" + getNature() + "]";
	}

}
