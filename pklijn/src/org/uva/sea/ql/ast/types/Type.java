package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.expressions.ASTNode;

public abstract class Type implements ASTNode {
	
	@Override
	public boolean equals(Object obj) {
		return (obj.getClass() == this.getClass());
	}
}
