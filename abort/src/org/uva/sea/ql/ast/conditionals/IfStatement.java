package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public abstract class IfStatement extends Element {
	protected final Node conditions;
	protected final List<Element> successElements;
	
	protected IfStatement(final Node condition, final List<Element> successElements) {
		this.conditions = condition;
		this.successElements = successElements;
	}
	
	public final Node getConditions() {
		return conditions;
	}

	public final List<Element> getSuccessElements() {
		return successElements;
	}
	
	@Override
	public void accept(IVisitor visitor) {
		conditions.accept(visitor);
	}
}
