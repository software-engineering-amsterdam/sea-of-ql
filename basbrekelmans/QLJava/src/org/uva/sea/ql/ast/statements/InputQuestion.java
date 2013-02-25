package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class InputQuestion extends Question {

	private Type type;

	public InputQuestion(ICodeLocationInformation info, StringLiteral question,
			Identifier identifier, Type type) {
		super(info, question, identifier);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}
}
