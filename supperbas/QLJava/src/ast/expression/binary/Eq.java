package ast.expression.binary;

import java.util.Map;

import ast.Expression;
import ast.Type;
import ast.expression.Binary;
import ast.visitor.Visitor;

public class Eq extends Binary {

	public Eq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		return new ast.type.Int();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
