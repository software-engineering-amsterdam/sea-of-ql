package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class Form implements ASTNode { 
	private Ident name;
	private Block block ;
	
	public Form(Ident name, Block block){
		this.name=name;
		this.block=block;
	}
	
	public Value getName() {
		return name;
	}
	
	public Block getBlock() {
		return block;
	}
 
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}
}
