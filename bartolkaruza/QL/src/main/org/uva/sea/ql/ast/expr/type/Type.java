package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.ast.expr.value.Value;

public abstract class Type {

	public abstract Value getMatchingNode(int lineNumber);

	/**
	 * Type check double dispatch methods
	 * 
	 * @param type
	 * @return
	 */
	public abstract boolean isCompatibleTo(Type type);

	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToTextString() {
		return false;
	}

	public boolean isCompatibleToBool() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}

	/**
	 * Type coercion
	 * 
	 * @param otherType
	 * @return the "highest" or coerced type
	 */
	public abstract Type leastUpperBound(Type otherType);

	public Type leastUpperBoundFromInt(IntType type) {
		return new ErrorType();
	}

	public Type leastUpperBoundFromBool(BoolType type) {
		return new ErrorType();
	}

	public Type leastUpperBoundFromText(TextType type) {
		return new ErrorType();
	}

	public Type leastUpperBoundFromMoney(MoneyType type) {
		return new ErrorType();
	}
	
	/**
	 * Method to facilitate checking if this type is of the error type
	 */
	public boolean isError() {
		return false;
	}
	
	public boolean isCompatibleWithAdd() {
		return false;
	}
	
	public boolean isCompatibleWithAnd() {
		return false;
	}
	
	public boolean isCompatibleWithDiv() {
		return false;
	}
	
	public boolean isCompatibleWithEq() {
		return false;
	}
	
	public boolean isCompatibleWithGEq() {
		return false;
	}
	
	public boolean isCompatibleWithGT() {
		return false;
	}
	
	public boolean isCompatibleWithLEq() {
		return false;
	}
	
	public boolean isCompatibleWithLT() {
		return false;
	}
	
	public boolean isCompatibleWithMul() {
		return false;
	}
	
	public boolean isCompatibleWithNeg() {
		return false;
	}
	
	public boolean isCompatibleWithNEq() {
		return false;
	}
	
	public boolean isCompatibleWithNot() {
		return false;
	}
	
	public boolean isCompatibleWithOr() {
		return false;
	}
	
	public boolean isCompatibleWithPos() {
		return false;
	}
	
	public boolean isCompatibleWithSub() {
		return false;
	}

}
