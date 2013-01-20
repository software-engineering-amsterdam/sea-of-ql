package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.parser.ASTVisitor;


public class Literal extends Expression {

	public void accept(ASTVisitor v){
		v.visit(this);
	}

}
