package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class IfThenElse extends IfStatement {
	private final List<Element> elseElements;
	
	public IfThenElse(final Node conditions, final List<Element> successElements, final List<Element> elseElements) {
		super(conditions, successElements);		
		this.elseElements = elseElements;
	}

	@Override
	public void accept(final IVisitor visitor) {
		for (final Element nodeToVisit : successElements) {
			nodeToVisit.accept(visitor);
		}
		
		for (final Element nodeToVisit : elseElements) {
			nodeToVisit.accept(visitor);
		}
		
		super.accept(visitor);

		visitor.visit(this);		
	}
	
	public List<Element> getElseElements() {
		return elseElements;
	}
}
