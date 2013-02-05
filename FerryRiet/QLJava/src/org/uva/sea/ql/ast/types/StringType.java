package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.operators.ExpressionResult;
import org.uva.sea.ql.ast.operators.StringResult;

public class StringType extends TypeDescription {

	public StringType() {
		super("string");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return t.isCompatibleToString();
	}

	@Override
	public boolean isCompatibleToString() {
		return true;
	}

	@Override
	public ExpressionResult getTypeContainer() {
		return new StringResult("");
	}
}
