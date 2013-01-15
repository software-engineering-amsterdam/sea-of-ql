package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.types.DataType;

public class Computation extends Element {
	private String label;
	private String description;
	private DataType expectedType;
	private Expression calculationOperation;
	
	public Computation(String label, String description, DataType expectedType, Expression calculationOperation) {
		this.label = label;
		this.description = description;
		this.expectedType = expectedType;
		this.calculationOperation = calculationOperation;
	}
}
