package ast;

import ast.type.Visitor;

public abstract class Type implements ASTNode {

	public abstract <T> T accept(Visitor<T> visitor);

	public abstract boolean isCompatibleTo(Type t);
	
	public boolean isError() {
		return false;
	}

	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToStr() {
		return false;
	}

	public boolean isCompatibleToBool() {
		return false;
	}
}
