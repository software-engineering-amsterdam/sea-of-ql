package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.datatypes.DataType;
import org.uva.sea.ql.ast.types.literals.Ident;

/**
 * Question as defined in the QL language.
 * 
 * @author J. Dijkstra
 */
public class Question extends Element {
	/**
	 * Identity.
	 */
	private final Ident ident;
	/**
	 * Question text.
	 */
	private final String text;
	/**
	 * The data type that the answer to the question should be.
	 */
	private final DataType expectedType;

	/**
	 * Constructor.
	 * 
	 * @param ident
	 *            ident
	 * @param text
	 *            question text
	 * @param expectedType
	 *            data type that the answer should be
	 */
	public Question(final Ident ident, final String text,
			final DataType expectedType) {
		this.ident = ident;
		this.text = text;
		this.expectedType = expectedType;
	}

	/**
	 * Retrieve the ident.
	 * 
	 * @return ident
	 */
	public Ident getIdent() {
		return ident;
	}

	/**
	 * Retrieve the question text.
	 * 
	 * @return question
	 */
	public String getText() {
		return text;
	}

	/**
	 * Retrieve the data type the answer should be.
	 * 
	 * @return data type
	 */
	public DataType getExpectedType() {
		return expectedType;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		// TODO: visit ident
		return visitor.visit(this);
	}
}
