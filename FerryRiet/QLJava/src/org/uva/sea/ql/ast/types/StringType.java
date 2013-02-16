package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.operatorresults.StringResult;

public class StringType extends Type {

	public StringType() {
		super("string");
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToString();
	}

	@Override
	public boolean isCompatibleToString() {
		return true;
	}

	@Override
	public Result getTypeContainer() {
		return new StringResult("");
	}
}
