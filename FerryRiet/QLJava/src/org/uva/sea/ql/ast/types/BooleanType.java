package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.operators.BooleanResult;
import org.uva.sea.ql.ast.operators.ExpressionResult;


public class BooleanType extends TypeDescription {

	public BooleanType() {
		super("boolean");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public ExpressionResult getTypeContainer() {
		// TODO Auto-generated method stub
		return new BooleanResult(false);
	}
}
