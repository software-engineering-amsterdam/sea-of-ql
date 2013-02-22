package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;

public abstract class Type implements ASTNode {
	
	public abstract boolean isCompatibleTo(Type t);
	
	public boolean isCompatibleToInt()     { return false; }
	public boolean isCompatibleToNumeric() { return false; }
	public boolean isCompatibleToStr()     { return false; }
	public boolean isCompatibleToBool()    { return false; }
	public boolean isCompatibleToMoney()   { return false; }
	
}