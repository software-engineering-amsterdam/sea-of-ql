package org.uva.sea.ql.ast.base;

import org.uva.sea.ql.ast.traversal.base.IVisitable;

public abstract class Node implements IVisitable {
	@Override
	public String toString() {
		return getClass().toString();
	}
}
