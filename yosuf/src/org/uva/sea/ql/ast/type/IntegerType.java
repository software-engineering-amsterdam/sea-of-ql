package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.exp.Numeric;

public class IntegerType extends DataType {

	@Override
	public <T> T accept(final DataTypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type getType() {
		return new Numeric();
	}

}
