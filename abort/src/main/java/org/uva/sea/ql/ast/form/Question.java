package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.DataType;

/**
 * Question as defined in the QL language.
 * @author J. Dijkstra
 */
public class Question extends Element {
	/**
	 * Label.
	 */
	private final Label label;
	/**
	 * Question text.
	 */
	private final String text;
	/**
	 * The data type that the answer to the question should be.
	 */
	private final Class<? extends DataType> expectedType;
	
	/**
	 * Constructor.
	 * @param label label
	 * @param text question text
	 * @param expectedType data type that the answer should be
	 */
	public Question(final Label label, final String text, final Class<? extends DataType> expectedType) {
		this.label = label;
		this.text = text;
		this.expectedType = expectedType;
	}
	
	/**
	 * Retrieve the label.
	 * @return label
	 */
	public Label getLabel() {
		return label;
	}
	
	/**
	 * Retrieve the question text.
	 * @return question
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Retrieve the data type the answer should be.
	 * @return data type
	 */
	public Class<? extends DataType> getExpectedType() {
		return expectedType;
	}

	@Override
	public void accept(final IVisitor visitor) {
		label.accept(visitor);
		visitor.visit(this);
	}
}
