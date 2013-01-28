package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Identifier in the QL language.
 * Not instantiated unless a type could not be identified
 * as another type in the grammar.
 * @author J. Dijkstra
 */
public class Ident extends Expression {
	/**
	 * Name tag of the ident.
	 */
	private final String name;

	/**
	 * Constructor.
	 * @param name name tag
	 */
	public Ident(final String name) {
		this.name = name;
	}
	
	/**
	 * Retrieve the name tag of the ident.
	 * @return name tag
	 */
	public String getName() {
		return name;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
