package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;

public class CompoundStatement extends Statement {
	private final List<Statement> statementList = new ArrayList<Statement>();

	public List<Statement> getStatementList() {
		return statementList;
	}

	public CompoundStatement() {
	}

	public void addStatement(Statement st) {
		statementList.add(st);
	}

	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
