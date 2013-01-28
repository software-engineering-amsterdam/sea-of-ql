package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IStatementVisitor;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.StringLiteral;

public class ComputedQuestion extends Question {

	private final Expression value;
	
	public ComputedQuestion(ICodeLocationInformation info,
			StringLiteral question, Identifier identifier, Expression value) {
		super(info, question, identifier);
		this.value = value;
	}
	
	public Expression getValue() {
		return value;
	}
	@Override
	public void accept(IStatementVisitor visitor)  {
		visitor.visit(this);
	}
}
