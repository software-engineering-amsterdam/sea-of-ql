package org.uva.sea.ql.parser.antlr.operators;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.parser.antlr.types.DataType;

public class FormQuestion extends FormExpression {
	private String label;
	private String question;
	private DataType expectedType;
	
	public FormQuestion(String label, String question, DataType expectedType) {
		this.label = label;
		this.question = question;
		this.expectedType = expectedType;
	}
}
