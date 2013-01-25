package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class FormElement implements ASTNode {

	
	public void accept(Visitor visitor) {
		//visitor.visit(this);
	}
}
