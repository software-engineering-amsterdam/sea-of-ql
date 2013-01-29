package ast.expression.unary;

import java.util.Map;

import ast.Expression;
import ast.expression.Unary;
import ast.type.Type;
import ast.visitor.Visitor;

public class Not extends Unary {
	private final int level = 6;

	public Not(Expression expr) {
		super(expr);
	}

	public int getLevel() {
		return level;
	}
	
	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		return new ast.type.Bool();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
