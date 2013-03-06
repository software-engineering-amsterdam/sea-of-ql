package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class Form extends Statement {
	private Ident name;
	private Block block;

	public Form(Ident name, Block block) {
		this.name = name;
		this.block = block;
	}

	public Ident getName() {
		return name;
	}

	public Block getBlock() {
		return block;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}
}
