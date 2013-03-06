package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.visitors.typevisitor.Visitor;

public abstract class Type implements ASTNode {
	
	public abstract boolean isCompatibleTo(Type t);
	
	public boolean isCompatibleToInt()     { return false; }
	public boolean isCompatibleToNumeric() { return false; }
	public boolean isCompatibleToStr()     { return false; }
	public boolean isCompatibleToBool()    { return false; }
	public boolean isCompatibleToMoney()   { return false; }
	
	public abstract <T> T accept(Visitor<T> visitor);
	
}