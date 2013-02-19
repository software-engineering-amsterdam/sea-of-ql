package org.uva.sea.ql.ast.expression.bool;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.Variable;

public class BooleanType implements Type {

	@Override
	public Variable getVariable(Identifier id) {
		return new BooleanVariable(id);
	}

}
