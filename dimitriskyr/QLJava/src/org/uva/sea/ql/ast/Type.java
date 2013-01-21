package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.Visitorinterface;

public abstract class Type implements ASTNode {
	
	@Override
	public void accept(Visitorinterface visitor) {
		visitor.visit(this);
	}
}
