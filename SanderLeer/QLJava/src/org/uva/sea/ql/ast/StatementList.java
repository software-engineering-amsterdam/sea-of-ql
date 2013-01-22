package org.uva.sea.ql.ast;

import java.util.ArrayList;

public class StatementList implements ASTNode {
	private final ArrayList<Statement> list;
	
	public StatementList() {
		this.list = new ArrayList<>(); 
	}

	public ArrayList<Statement> getList() {
		return list;
	}

	public void addStatement(Statement statement) {
		list.add(statement);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

}
