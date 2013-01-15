package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.DataType;

public class Question extends Element {
	private String label;
	private String question;
	private DataType expectedType;
	
	public Question(String label, String question, DataType expectedType) {
		this.label = label;
		this.question = question;
		this.expectedType = expectedType;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
