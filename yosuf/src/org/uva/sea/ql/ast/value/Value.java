package org.uva.sea.ql.ast.value;

import org.uva.sea.ql.ast.Valuable;
import org.uva.sea.ql.ast.exp.Expression;

public abstract class Value extends Expression implements Valuable {

	protected Value() {
		super();
	}
}
