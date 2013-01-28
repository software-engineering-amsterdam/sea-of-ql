package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.semantic.Environment;

public abstract class Numeric extends AbstractAtom {

	@Override
	public AbstractType typeOf(Environment environment) {
		return new org.uva.sea.ql.ast.type.Numeric();
	}

}
