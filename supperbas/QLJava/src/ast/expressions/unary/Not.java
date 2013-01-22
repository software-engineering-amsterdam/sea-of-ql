package ast.expressions.unary;

import java.util.Map;

import ast.Expression;
import ast.expressions.Unary;
import ast.types.Type;

public class Not extends Unary {
	private final int level = 6;

	public Not(Expression expr) {
		super(expr);
	}

	public int getLevel() {
		return level;
	}
	
	@Override
	public Type typeOf(Map<ast.types.Ident, Type> typeEnv) {
		return new ast.types.Bool();
	}

}
