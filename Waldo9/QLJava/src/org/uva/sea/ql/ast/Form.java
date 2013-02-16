package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.statements.Block;

public class Form implements ASTNode {
	
	private final Ident identifier;
	private final Block block;
	
	public Form(Ident identifier, Block block) {
		this.identifier = identifier;
		this.block = block;
	}
	
	public Ident getIdentifier() {
		return identifier;
	}
	
	public Block getBlock() {
		return block;
	}
	
}
