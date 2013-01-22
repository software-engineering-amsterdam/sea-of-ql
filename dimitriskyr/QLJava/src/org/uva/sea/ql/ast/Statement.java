package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.Visitorinterface;

public abstract class Statement implements ASTNode {
 
	@Override
	public void accept(Visitorinterface visitor) {
		visitor.visit(this);
		
	}

}
