package ast;

import ast.visitor.Visitor;

public abstract class Type implements ASTNode {

	public abstract <T> T accept(Visitor<T> visitor);

	public abstract boolean isCompatibleTo(Type t);

	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToNumeric() {
		return false;
	}

	public boolean isCompatibleToStr() {
		return false;
	}

	public boolean isCompatibleToBool() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}
}
