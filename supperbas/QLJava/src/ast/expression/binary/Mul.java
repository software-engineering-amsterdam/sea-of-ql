package ast.expression.binary;

import java.util.Map;

import ast.Expression;
import ast.expression.Binary;
import ast.types.Type;
import ast.visitors.Visitor;

public class Mul extends Binary {
	private final int level = 4;

	public Mul(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}
	
	@Override
	public Type typeOf(Map<ast.types.Ident, Type> typeEnv) {
		return new ast.types.Numeric();
	}	

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}