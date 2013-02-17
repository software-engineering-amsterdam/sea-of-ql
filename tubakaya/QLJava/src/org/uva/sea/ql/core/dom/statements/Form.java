package org.uva.sea.ql.core.dom.statements;

import java.util.List;
import org.uva.sea.ql.core.dom.Statement;
import org.uva.sea.ql.core.dom.StatementVisitor;

public class Form extends Statement{

	public List<Statement> statements;

	public Form(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
}
