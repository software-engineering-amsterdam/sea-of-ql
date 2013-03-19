package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.visitors.StatementVisitor;

public class Body extends Statement {
	
	private final List<Statement> elemList;

	public Body(List<Statement> elemList) {
		this.elemList = elemList;
	}
	
	public List<Statement> getElems() {
		return new ArrayList<>(elemList);
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}


}
