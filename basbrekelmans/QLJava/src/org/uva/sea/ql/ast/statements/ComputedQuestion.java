package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class ComputedQuestion extends Question {

	private final Expression value;

	public ComputedQuestion(final ICodeLocationInformation info,
			final StringLiteral question, final Identifier identifier,
			final Expression value) {
		super(info, question, identifier);
		this.value = value;
	}

	@Override
	public void accept(final IStatementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Expression getExpression() {
		return this.value;
	}

	@Override
	public boolean hasExpression() {
		return true;
	}
}
