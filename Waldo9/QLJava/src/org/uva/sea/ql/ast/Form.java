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
	
	public void accept(ASTNodeVisitor visitor) {
		identifier.accept(visitor);
        block.accept(visitor);
		visitor.visit(this);
    }
}
