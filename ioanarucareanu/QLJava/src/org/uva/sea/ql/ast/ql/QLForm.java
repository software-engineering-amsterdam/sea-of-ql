package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.semanticchecker.QLItemSemanticVisitor;
import org.uva.sea.ql.semanticchecker.VisitableExpression;

public class QLForm implements ASTNode, QLItem {
	private final Ident name;
	private final Block<QLItem> blockOfItems;
	
	public QLForm(Ident name, Block<QLItem> blockItems) {
		this.name = name;
		this.blockOfItems = blockItems;
	}

	public Ident getName() {
		return name;
	}

	public Block<QLItem> getBlockOfItems() {
		return blockOfItems;
	}

	@Override
	public void accept(QLItem visitableElement, QLItemSemanticVisitor visitor) {
		
		visitor.visit((QLForm)visitableElement);
	}
	
}
