package ast.expressions.binary;

import java.util.Map;

import ast.Expression;
import ast.expressions.Binary;
import ast.types.Type;

public class Or extends Binary {
	private final int level = 1;

	public Or(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}

	@Override
	public Type typeOf(Map<ast.types.Ident, Type> typeEnv) {
		return new ast.types.Bool();
	}

}
