package org.uva.sea.ql.ast;

public class Form implements ASTNode {
	
	private Ident name;
	private Block block;
	
	public Form(Ident name, Block block) {
		this.name = name;
		this.block = block;
	}
}
