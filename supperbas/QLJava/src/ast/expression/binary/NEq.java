package ast.expression.binary;

import java.util.Map;

import ast.Expression;
import ast.Type;
import ast.expression.Binary;
import ast.expression.Ident;
import ast.expression.Visitor;

public class NEq extends Binary {

	public NEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new ast.type.Int();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String typeStr() {
		return "!=";
	}

}
