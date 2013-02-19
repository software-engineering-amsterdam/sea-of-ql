package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.statements.BlockOfStatements;

public class Form implements ASTNode {
	private final Ident ident;
	private final BlockOfStatements bStms;
	
	public Form(Ident ident, BlockOfStatements bStms) {
		this.ident = ident;
		this.bStms = bStms;
	}
	
	public Ident getIdent() {
		return ident;
	}
	
	public BlockOfStatements getStms() {
		return bStms;
	}
}