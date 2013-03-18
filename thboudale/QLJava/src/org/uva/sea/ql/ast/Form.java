package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.statements.BlockOfStatements;
import org.uva.sea.ql.visitor.IFormVisitor;

public class Form implements ASTNode {
	private final Ident ident;
	private final BlockOfStatements blStmts;
	
	public Form(Ident ident, BlockOfStatements blStmts) {
		this.ident = ident;
		this.blStmts = blStmts;
	}
	
	public Ident getIdent() {
		return ident;
	}
	
	public BlockOfStatements getBlStmts() {
		return blStmts;
	}
	
	public <T> T accept(IFormVisitor<T> visitor) {
		return visitor.visit(this);		
	}
}