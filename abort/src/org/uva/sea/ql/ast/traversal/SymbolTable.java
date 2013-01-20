package org.uva.sea.ql.ast.traversal;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Label;

/**
 * Stores labels from the grammar with their result types, so references to their value could be used (e.g. in a computation)
 */
class SymbolTable extends TypeTable {
	// Only usable in the current package
	protected SymbolTable() { }
	
	// Check if the label is declared in the table
	public boolean isLabelDeclared(final Label label) {
		return types.containsKey(label);
	}
	
	public boolean isLabelDeclared(final String labelText) {
		return isLabelDeclared(new Label(labelText));
	}
	
	@Override
	public void addTypeForNode(final Node node, final Class<? extends Node> type) {
		super.addTypeForNode(node, type);
	}
}
