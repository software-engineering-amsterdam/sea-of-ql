package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class Block extends Statement{
	private final List<Statement> block = new ArrayList<Statement>();

	public void addBody(Statement formElement) {
		block.add(formElement);
	}

	public List<Statement> getBody() {
		return block;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}
}

