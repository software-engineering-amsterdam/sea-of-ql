package org.uva.sea.ql.ast.statements;

import java.util.List;

import org.uva.sea.ql.semanticCheck.FormStmtVisitor;

public class BlockOfStatements extends AStatement {
	private final List<AStatement> blStmts; 
	
	public BlockOfStatements(List<AStatement> stmts) {
		this.blStmts = stmts;
	}
	
	public List<AStatement> getBlStmt() {
		return blStmts;
	}
	
	@Override
	public <T> T accept(FormStmtVisitor<T> visitor) {
		return visitor.visit(this);		
	}
}