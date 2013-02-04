package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;
import org.uva.sea.ql.ast.expr.value.TextString;

public class TextStringType extends Type {

	@Override
	public ValueExpr getMatchingNode(int lineNumber) {
		return new TextString(lineNumber);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToTextString();
	}

	@Override
	public boolean isCompatibleToTextString() {
		return true;
	}

}
