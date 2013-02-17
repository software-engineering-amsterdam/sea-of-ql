package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.DataType;

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
	 * The statements the form consists of.
	 */
	private final List<Statement> statements;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            form name
	 * @param statements
	 *            statements that are part of the form
	 * @param syntaxPosition
	 *            the original position of the expression in the input syntax
	 */
	public Form(final String name, final List<Statement> statements, final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);

		this.name = name;
		this.statements = statements;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * Retrieve the statements the form consists of.
	 * 
	 * @return form statements
	 */
	public final List<Statement> getStatements() {
		return statements;
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
