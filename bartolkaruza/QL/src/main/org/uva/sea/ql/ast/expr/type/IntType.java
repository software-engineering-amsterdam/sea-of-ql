package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Value;

public class IntType extends Type {

	@Override
	public Value getMatchingNode(int lineNumber) {
		return new Int(lineNumber);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToInt();
	}
	
	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public Type leastUpperBound(Type otherType) {
		return otherType.leastUpperBoundFromInt(this);
	}
	
	@Override
	public Type leastUpperBoundFromMoney(MoneyType type) {
		return type;
	}
	
	@Override
	public Type leastUpperBoundFromInt(IntType type) {
		return this;
	}
	
	@Override
	public Type leastUpperBoundFromText(TextType type) {
		return type;
	}
	
	@Override
	public boolean isCompatibleWithAdd() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithDiv() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithEq() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithGEq() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithGT() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithLT() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithMul() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithNeg() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithLEq() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithNEq() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithPos() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithSub() {
		return true;
	}

}
