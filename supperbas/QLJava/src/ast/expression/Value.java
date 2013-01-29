package ast.expression;

import ast.Expression;

public abstract class Value extends Expression {
	private final int level = 7;

	public Value() {
	}

	public int getLevel() {
		return level;
	}

}
