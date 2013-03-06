package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Type;

public abstract class DataType implements ASTNode {

	protected DataType() {
		super();
	}

	public abstract Type getType();

	public abstract <T> T accept(final DataTypeVisitor<T> visitor);

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [Type=" + getType() + "]";
	}

}
