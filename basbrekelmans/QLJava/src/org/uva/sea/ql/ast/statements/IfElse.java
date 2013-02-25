package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class IfElse extends If {

	private final Statement elseBody;

	public IfElse(ICodeLocationInformation info, Expression expression,
			Statement ifBody, Statement elseBody) {
		super(info, expression, ifBody);
		this.elseBody = elseBody;
	}

	public Statement getElseBody() {
		return elseBody;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}

}
