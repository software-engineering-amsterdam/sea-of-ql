package org.uva.sea.ql.ast.expression.string;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.Variable;

public class StringType implements Type {

	@Override
	public Variable getVariable(Identifier id) {
		return new StringVariable(id);
	}

	@Override
	public Primitive getPrimitive() {
		return new StringPrimitive();
	}

}
