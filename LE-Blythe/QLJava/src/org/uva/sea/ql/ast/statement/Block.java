package org.uva.sea.ql.ast.statement;

import java.util.List;

import org.uva.sea.ql.ast.IVisitorStatement;
import org.uva.sea.ql.ast.Statement;

public class Block extends Statement{
	
	private List<Statement> statements;
	
	
	public Block(List<Statement> statements){
		this.statements = statements;
	}
	
	
	public List<Statement> getStatements(){
		return statements;
	}
	
	
	@Override
	public <T> T accept(IVisitorStatement<T> visitor) {
		return visitor.visit(this);
	}
}
