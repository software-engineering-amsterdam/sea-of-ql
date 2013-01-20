package org.uva.sea.ql.ast;

import org.uva.sea.ql.parser.ASTVisitor;


public abstract class Expr implements ASTNode {

	public void accept(ASTVisitor v){
		v.visit(this);
	}
	
}
