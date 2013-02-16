package ast.expression.binary;

import java.util.Map;

import ast.Expression;
import ast.Type;
import ast.expression.Binary;
import ast.visitor.Visitor;

public class Or extends Binary {

	public Or(Expression lhs, Expression rhs) {
		super(lhs, rhs);
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
