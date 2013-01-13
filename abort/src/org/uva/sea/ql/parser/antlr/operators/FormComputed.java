package org.uva.sea.ql.parser.antlr.operators;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.parser.antlr.types.DataType;

public class FormComputed extends FormExpression {
	private String label;
	private String description;
	private DataType expectedType;
	private Expression calculationOperation;
	
	public FormComputed(String label, String description, DataType expectedType, Expression calculationOperation) {
		this.label = label;
		this.description = description;
		this.expectedType = expectedType;
		this.calculationOperation = calculationOperation;
	}
}
