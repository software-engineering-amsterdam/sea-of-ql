package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.visitor.IStatementVisitor;

public abstract class Statement extends Node {

	Statement(final ICodeLocationInformation info) {
		super(info);
	}

	public abstract void accept(IStatementVisitor visitor);

	public Expression getExpression() {
		return null;
	}

	public boolean hasExpression() {
		return false;
	}
}
