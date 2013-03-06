package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.AExpr;
import org.uva.sea.ql.visitor.IFormStmtVisitor;

public class ifElseStatement extends ifStatement {
	private final BlockOfStatements elseStmts;
	
	public ifElseStatement(AExpr condition, BlockOfStatements ifStms, BlockOfStatements elseStmts) {
		super(condition, ifStms);
		this.elseStmts = elseStmts;
	}
	
	public BlockOfStatements getElseStmts() {
		return elseStmts;
	}
	
	@Override
	public <T> T accept(IFormStmtVisitor<T> visitor) {
		return visitor.visit(this);		
	}
}