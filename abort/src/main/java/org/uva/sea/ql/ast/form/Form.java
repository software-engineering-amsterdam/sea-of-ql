package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents a form (as defined in the QL language).
 * 
 * @author J. Dijkstra
 * 
 */
public class Form extends Node {
	/**
	 * Form name.
	 */
	private final String name;
	/**
	 * The elements the form consists of.
	 */
	private final List<Element> elements;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            form name
	 * @param elements
	 *            elements that are part of the form
	 */
	public Form(final String name, final List<Element> elements) {
		this.name = name;
		this.elements = elements;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		// TODO: visit parent and elements
		return visitor.visit(this);
	}

	/**
	 * Retrieve the elements the form consists of.
	 * 
	 * @return form elements
	 */
	public final List<Element> getElements() {
		return elements;
	}

	/**
	 * Retrieve the form name.
	 * 
	 * @return form name
	 */
	public String getName() {
		return name;
	}
}
