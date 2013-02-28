package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.typevisitor.Visitor;


public class Numeric extends Type {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}
	
	@Override
	public boolean isCompatibleToInt()     { return true; }
	@Override
	public boolean isCompatibleToMoney()   { return true; }
	@Override
	public boolean isCompatibleToNumeric() { return true; }
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
}