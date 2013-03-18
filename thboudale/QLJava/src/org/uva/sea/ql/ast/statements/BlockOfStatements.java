package org.uva.sea.ql.ast.statements;

import java.util.List;
import org.uva.sea.ql.visitor.IFormVisitor;

public class BlockOfStatements extends AStatement {
	private final List<AStatement> blStmts; 
	
	public BlockOfStatements(List<AStatement> stmts) {
		this.blStmts = stmts;
	}
	
	public List<AStatement> getBlStmts() {
		return blStmts;
	}
	
	@Override
	public <T> T accept(IFormVisitor<T> visitor) {
		return visitor.visit(this);		
	}
}