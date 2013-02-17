package org.uva.sea.ql.core.dom.statements;

import java.util.List;

import org.uva.sea.ql.core.dom.Expression;
import org.uva.sea.ql.core.dom.Statement;
import org.uva.sea.ql.core.dom.StatementVisitor;

public class IfStatement extends Statement {
	
	public Expression expression;
	public List<Statement> statements;

	public IfStatement(Expression expression, List<Statement> statements) {
		this.expression = expression;
		this.statements = statements;
	}
	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

}
