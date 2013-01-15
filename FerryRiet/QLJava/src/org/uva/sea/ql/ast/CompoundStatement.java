package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class CompoundStatement extends Statement {
	private List<Statement> statementList = new ArrayList<Statement>();

	public List<Statement> getStatementList() {
		return statementList;
	}

	public CompoundStatement() {
	}

	public void addStatement(Statement st) {
		statementList.add(st);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
