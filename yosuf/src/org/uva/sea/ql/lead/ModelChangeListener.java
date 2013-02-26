package org.uva.sea.ql.lead;

import org.uva.sea.ql.ast.exp.Expression;

/**
 * Interface for listening to {@link Model} changes.
 */
public interface ModelChangeListener {

	/**
	 * This method is invoked when model is changed.
	 * 
	 * @param expression
	 */
	void changed(Expression expression);
}
