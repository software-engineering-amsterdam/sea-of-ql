package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Natural;

public abstract class DataType implements Natural, ASTNode {

	protected DataType() {
		super();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [Nature=" + getNature() + "]";
	}

}
