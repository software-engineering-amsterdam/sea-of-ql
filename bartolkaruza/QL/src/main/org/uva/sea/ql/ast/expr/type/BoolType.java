package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Value;

public class BoolType extends Type {
	
	@Override
	public Value getMatchingNode(int lineNumber) {
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

	@Override
	public Type leastUpperBound(Type otherType) {
		return otherType.leastUpperBoundFromBool(this);
	}
	
	@Override
	public Type leastUpperBoundFromBool(BoolType type) {
		return this;
	}
	
	@Override
	public Type leastUpperBoundFromText(TextType type) {
		return type;
	}
	
	@Override
	public boolean isCompatibleWithAnd() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithEq() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithNEq() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithNot() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithOr() {
		return true;
	}
}
