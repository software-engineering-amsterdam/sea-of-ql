package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.statements.Block;

public class Form implements ASTNode {
	
	private Ident identifier;
	private Block block;
	
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
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		return visitor.visit(this);
    }
}
