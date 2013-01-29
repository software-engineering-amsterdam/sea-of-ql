package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Expression;
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
	public IfThen(final Expression conditions, final List<Element> successElements) {
		super(conditions, successElements);		
	}
	
	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		// TODO: visit parent and elements
		return visitor.visit(this);
	}
}
