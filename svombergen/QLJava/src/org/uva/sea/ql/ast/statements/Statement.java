package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Visitor;


public abstract class Statement implements ASTNode {
	public void accept(Visitor v){
		;
	}
}
