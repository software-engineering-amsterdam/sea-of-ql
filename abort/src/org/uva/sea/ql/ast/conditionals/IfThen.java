package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class IfThen extends IfStatement {
	public IfThen(final Node conditions, final List<Element> successElements) {
		super(conditions, successElements);		
	}

	// TODO: remove duplicate code with IfThenElse
	@Override
	public void accept(final IVisitor visitor) {
		for (final Element nodeToVisit : successElements) {
			nodeToVisit.accept(visitor);
		}
		
		visitor.visit(this);
	}
}
