package ast.expressions;

import ast.Expression;


public abstract class Value extends Expression {
	private final int level = 7;
	public Value() {
		// TODO Auto-generated constructor stub
	}
	public int getLevel() {
		return level;
	}

}
