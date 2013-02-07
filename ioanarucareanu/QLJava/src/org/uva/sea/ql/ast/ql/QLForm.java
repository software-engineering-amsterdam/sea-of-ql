package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.expr.Ident;

public class QLForm implements ASTNode {
	private final Ident name;
	private final Block<QLItem> blockItems;
	
	public QLForm(Ident name, Block<QLItem> blockItems) {
		this.name = name;
		this.blockItems = blockItems;
	}

	public Ident getName() {
		return name;
	}

	public Block<QLItem> getBlockItems() {
		return blockItems;
	}
	
}
