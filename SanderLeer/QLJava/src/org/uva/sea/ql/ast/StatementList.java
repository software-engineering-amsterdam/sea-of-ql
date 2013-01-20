package org.uva.sea.ql.ast;

import java.util.ArrayList;

public class StatementList implements ASTNode {
	private final ArrayList<ASTNode> list;
	
	public StatementList() {
		this.list = new ArrayList<>(); 
	}

	public ArrayList<ASTNode> getList() {
		return list;
	}

	public void addStatement(ASTNode statement) {
		list.add(statement);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

}
