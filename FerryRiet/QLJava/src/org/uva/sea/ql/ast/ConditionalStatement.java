package org.uva.sea.ql.ast;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class ConditionalStatement extends Statement {
	
	public Expr expression ;
	public CompoundBlock compound ;

	public ConditionalStatement(Expr ex, CompoundBlock c) {
		expression = ex ;
		compound = c ;
	}
	public void eval() {
		System.out.print("if (");
		expression.eval() ;
		System.out.print(") ");
		compound.eval();
	}
	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this) ;
	}
}
