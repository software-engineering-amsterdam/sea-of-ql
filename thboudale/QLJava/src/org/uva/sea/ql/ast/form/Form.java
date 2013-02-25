package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.statements.BlockOfStatements;
import org.uva.sea.ql.visitor.IFormStmtVisitor;

public class Form extends AForm {
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

	@Override
	public <T> T accept(IFormStmtVisitor<T> visitor) {
		return visitor.visit(this);		
	}
}