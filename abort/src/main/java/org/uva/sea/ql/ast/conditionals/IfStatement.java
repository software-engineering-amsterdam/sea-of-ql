package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents a base type of If statement in QL.
 * @author J. Dijkstra
 */
public abstract class IfStatement extends Element {
	/**
	 * Condition for the if statement.
	 */
	private final Node condition;
	/**
	 * Form elements displayed on a successful condition.
	 */
	private final List<Element> successElements;
	
	/**
	 * Constructor.
	 * @param condition condition for the if statement
	 * @param successElements form elements displayed on a successful condition
	 */
	protected IfStatement(final Node condition, final List<Element> successElements) {
		this.condition = condition;
		this.successElements = successElements;
	}

	/**
	 * Retrieve condition.
	 * @return condition
	 */
	public final Node getConditions() {
		return condition;
	}

	/**
	 * Retrieves form elements displayed on a successful condition.
	 * @return form elements
	 */
	public final List<Element> getSuccessElements() {
		return successElements;
	}

	@Override
	public void accept(final IVisitor visitor) {
		condition.accept(visitor);
	}
}
