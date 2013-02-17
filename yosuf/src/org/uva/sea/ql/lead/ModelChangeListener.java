package org.uva.sea.ql.lead;

import org.uva.sea.ql.ast.exp.Expression;

public interface ModelChangeListener {

	void changed(Expression<?> expression);
}
