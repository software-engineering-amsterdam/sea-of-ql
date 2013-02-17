package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.operatorresults.BooleanResult;
import org.uva.sea.ql.ast.operatorresults.Result;


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
		return new BooleanResult(false);
	}
}
