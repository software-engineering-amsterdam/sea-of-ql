package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents a label as defined in the QL language.
 * @author J. Dijkstra
 */
public class Label extends Node {
	/**
	 * The identifying text of the label.
	 */
	private final String text;
	
	/**
	 * Constructor.
	 * @param text text to be used as identifier
	 */
	public Label(final String text) {
		this.text = text;
	}
	
	/**
	 * Retrieve the identifying text.
	 * @return identifying text
	 */
	public String getText() {
		return text;
	}

	// Labels with the same identifying text are the same (used for the symbol table and result type table)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null || !Label.class.equals(obj.getClass())) {
			return false;
		}
	
		final Label otherLabel = (Label)obj;
		return text.equals(otherLabel.getText());
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
