package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Value;

public class IntType extends NumericType {

	// Double dispatch
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}

	@Override
	public Value getDefaultValue() {
		return new Int(0);
	}
}
