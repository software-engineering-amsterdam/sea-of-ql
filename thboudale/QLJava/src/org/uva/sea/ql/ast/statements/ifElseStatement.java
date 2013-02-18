package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.StmtVisitor;

public class ifElseStatement extends ifStatement {
	private final BlockOfStatements elseStms;
	
	public ifElseStatement(Expr condition, BlockOfStatements ifStms, BlockOfStatements elseStms) {
		super(condition, ifStms);
		this.elseStms = elseStms;
	}
	
	public BlockOfStatements getElseStms() {
		return elseStms;
	}
	
	@Override
	public void accept(StmtVisitor visitor) {
		visitor.visit(this);		
	}
}