package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.DataType;

public class Question extends Element {
	private final Label label;
	private final String question;
	private final Class<? extends DataType> expectedType;
	
	public Question(Label label, String question, Class<? extends DataType> expectedType) {
		this.label = label;
		this.question = question;
		this.expectedType = expectedType;
	}
	
	public Label getLabel() {
		return label;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public Class<? extends DataType> getExpectedType() {
		return expectedType;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
