package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Visitor;

public class Statement implements ASTNode {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
