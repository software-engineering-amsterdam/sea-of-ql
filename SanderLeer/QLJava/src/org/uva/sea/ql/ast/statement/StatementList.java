package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Visitor;

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
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
