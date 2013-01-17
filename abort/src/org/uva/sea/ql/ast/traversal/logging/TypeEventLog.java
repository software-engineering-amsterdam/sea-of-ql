package org.uva.sea.ql.ast.traversal.logging;

import org.uva.sea.ql.ast.base.Node;

public class TypeEventLog extends Log {
	public void addCorrectSemantics(final Node node) {
		add(new Line(node, "Correct semantics and types identified"));
	}
}
