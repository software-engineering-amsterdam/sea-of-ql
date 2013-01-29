package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;
import org.uva.sea.ql.ast.expr.value.Bool;

public class BoolType extends Type {
	
	@Override
	public ValueExpr getMatchingNode(int lineNumber) {
		return new Bool(lineNumber);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToBool();
	}
	
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

}
