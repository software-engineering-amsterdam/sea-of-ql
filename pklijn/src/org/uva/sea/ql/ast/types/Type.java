package org.uva.sea.ql.ast.types;

import java.awt.Component;

import org.uva.sea.ql.ast.expressions.ASTNode;

public abstract class Type implements ASTNode {
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return (obj.getClass().equals(this.getClass()));
	}
	
	public boolean isDefined() {
		return true;
	}
	
	public abstract Component getAnswerField(boolean enabled);
}
