package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.operatorresults.IntegerResult;
import org.uva.sea.ql.ast.operatorresults.Result;

public class IntegerType extends Type {

	public IntegerType() {
		super("numeral");
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public Result getTypeContainer() {
		return new IntegerResult(0);
	}
}
