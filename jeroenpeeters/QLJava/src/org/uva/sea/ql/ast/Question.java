package org.uva.sea.ql.ast;


public class Question extends Expr {

	private final ASTNode variable, label, type;
	
	public Question(final ASTNode variable, final ASTNode yysv, final ASTNode yysv2){
		this.variable = variable;
		this.label = yysv;
		this.type = yysv2;
	}

}
