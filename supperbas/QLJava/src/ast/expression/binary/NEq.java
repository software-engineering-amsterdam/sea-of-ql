package ast.expression.binary;

import java.util.Map;

import ast.Expression;
import ast.Type;
import ast.expression.Binary;
import ast.visitor.Visitor;

public class NEq extends Binary {
	private final int level = 2;

	public NEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public int getLevel() {
		return level;
	}
	
	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		return new ast.type.Numeric();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}