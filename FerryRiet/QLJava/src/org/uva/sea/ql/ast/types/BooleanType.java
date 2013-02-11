package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.literals.BooleanResult;
import org.uva.sea.ql.ast.literals.Result;


public class BooleanType extends Type {

	public BooleanType() {
		super("boolean");
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public Result getTypeContainer() {
		// TODO Auto-generated method stub
		return new BooleanResult(false);
	}
}
