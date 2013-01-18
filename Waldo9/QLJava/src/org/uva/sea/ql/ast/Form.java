package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.statements.Block;

public class Form implements ASTNode {
	
	private Ident name;
	private Block block;
	
	public Form(Ident name, Block block) {
		this.name = name;
		this.block = block;
	}
}
