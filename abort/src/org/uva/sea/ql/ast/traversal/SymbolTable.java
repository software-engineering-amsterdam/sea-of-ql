package org.uva.sea.ql.ast.traversal;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Label;


class SymbolTable extends TypeContainer {
	public boolean isLabelDeclared(final Label label) {
		if (label == null) {
			return false;
		}

		return types.containsKey(label);
	}
	
	public boolean isLabelDeclared(final String labelText) {
		return isLabelDeclared(new Label(labelText));
	}
	
	@Override
	public void addTypeForNode(Node node, Class<? extends Node> type) {
		super.addTypeForNode(node, type);
	}
}
