package org.uva.sea.ql.ast;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class CompoundBlock implements ASTNode {
	public List<Statement> statementList = new ArrayList<Statement>();

	public CompoundBlock() {
	}

	public void addStatement(Statement st) {
		statementList.add(st);
	}

	public void eval() {
		System.out.print("{");
		for (Statement statement : statementList)
			statement.eval();
		System.out.println("}");
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
