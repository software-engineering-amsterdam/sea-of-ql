package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents an If Then statement in QL.
 * @author J. Dijkstra
 */
public class IfThen extends IfStatement {
	/**
	 * Constructor.
	 * @param conditions conditions
	 * @param successElements form elements to display on success
	 */
	public IfThen(final Node conditions, final List<Element> successElements) {
		super(conditions, successElements);		
	}

	@Override
	public void accept(final IVisitor visitor) {		
		for (final Element nodeToVisit : getSuccessElements()) {
			nodeToVisit.accept(visitor);
		}
		
		super.accept(visitor);
		
		visitor.visit(this);
	}
}
