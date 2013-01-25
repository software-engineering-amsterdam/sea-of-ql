package ast.exprs;

import ast.Expr;


public abstract class Value extends Expr {
	private final int level = 7;
	public Value() {
		// TODO Auto-generated constructor stub
	}
	public int getLevel() {
		return level;
	}

}
