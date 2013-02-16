package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.semanticchecker.StatementSemanticVisitor;
import org.uva.sea.ql.semanticchecker.VisitableStatement;

public class QLForm implements ASTNode, VisitableStatement {
	private final Ident name;
	private final Block blockOfItems;
	
	public QLForm(Ident name, Block blockItems) {
		this.name = name;
		this.blockOfItems = blockItems;
	}

	public Ident getName() {
		return name;
	}

	public Block getBlockOfItems() {
		return blockOfItems;
	}

	@Override
	public void accept(StatementSemanticVisitor visitor) {		
		visitor.visit(this);
	}
	
}
