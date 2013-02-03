package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;
import org.uva.sea.ql.ast.expr.value.Int;

public class IntType extends NumericType {

	@Override
	public ValueExpr getMatchingNode(int lineNumber) {
		return new Int(lineNumber);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToInt();
	}

}
