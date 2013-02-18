package ast.expression.binary;

import java.util.Map;

import ast.Expression;
import ast.Type;
import ast.expression.Binary;
import ast.expression.Ident;
import ast.expression.Visitor;

public class Or extends Binary {

	public Or(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new ast.type.Bool();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String typeStr() {
		return "||";
	}

}
