package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.types.QLType;
import org.uva.sea.ql.ast.types.TypeDeclaration;

public class Question extends Statement {

	private final Expression defaultValue;
	private final String question;
	private final Identifier identifier;
	
	public Question(ICodeLocationInformation info, StringLiteral question, Identifier identifier, Expression defaultValue) {
		super(info);
		this.defaultValue = defaultValue;
		this.question = question.getValue();
		this.identifier = identifier;
	}
	
	public Question(ICodeLocationInformation info, StringLiteral question, Identifier identifier, TypeDeclaration type) {
		super(info);
		this.defaultValue = null;
		this.identifier = identifier;
		identifier.setType(type.getType());
		this.question = question.getValue();
	}

	public Expression getValue() {
		return defaultValue;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}
}
