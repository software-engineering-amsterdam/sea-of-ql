package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;

public abstract class Type {
	
	public abstract ValueExpr getMatchingNode(int lineNumber);
	
	public abstract boolean isCompatibleTo(Type type);
	
	public boolean isCompatibleToInt() { return false; }
	public boolean isCompatibleToNumeric() { return false; }
	public boolean isCompatibleToTextString() { return false; }
	public boolean isCompatibleToBool() { return false; }
	public boolean isCompatibleToMoney() { return false; }

}
