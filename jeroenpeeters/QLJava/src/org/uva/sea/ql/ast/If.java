package org.uva.sea.ql.ast;

import org.uva.sea.ql.parser.ASTVisitor;

public class If extends Expr {

	private final Expr expr;
	private final CompoundStatement compoundStatement;
	
	public If(Expr expr, CompoundStatement compoundStatement) {
		this.expr = expr;
		this.compoundStatement = compoundStatement;
	}
	
	@Override
	public void accept(ASTVisitor v){
		super.accept(v);
		
		compoundStatement.accept(v);
	}
	
}
