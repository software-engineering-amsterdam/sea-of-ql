package org.uva.sea.ql.ast.traversal;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Label;

/**
 * Stores labels from the grammar with their result types.
 * References to these labels their value could be used (e.g. in a computation)
 * @author J. Dijkstra
 */
class SymbolTable extends TypeTable {
	/**
	 * Constructor that limits scope to the current package.
	 */
	protected SymbolTable() { }
	
	/**
	 * Check if the label is declared in the symbol table.
	 * @param label label
	 * @return whether the label is declared in the symbol table or not
	 */
	public boolean isLabelDeclared(final Label label) {
		return types.containsKey(label);
	}
	
	/**
	 * Check if the label is declared in the symbol table.
	 * @param labelText label text
	 * @return whether the label is declared in the symbol table or not
	 */
	public boolean isLabelDeclared(final String labelText) {
		return isLabelDeclared(new Label(labelText));
	}
	
	@Override
	public void addTypeForNode(final Node node, final Class<? extends Node> type) {
		super.addTypeForNode(node, type);
	}
}
