package org.uva.sea.ql.ast;

import org.uva.sea.ql.ASTNodeVisitor;
import org.uva.sea.ql.ast.expr.Ident;

public class Question extends FormElement {

	private final String question;
	private final Ident value;
	private final String type;
	
	public Question(String question, Ident value, String type) {
		this.question = question;
		this.value = value;
		this.type = type;
	}
	
	public String getQuestion() { return question; }
	public Ident getValue() { return value; }
	public String getType() { return type; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
