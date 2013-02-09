package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.visitor.Visitor;

public class CompoundStatement extends Statement {
	private final List<Statement> statementList = new ArrayList<Statement>();

	public final List<Statement> getStatementList() {
		return statementList;
	}

	public final void addStatement(final Statement st) {
		statementList.add(st);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
