package ast.expression.unary;

import java.util.Map;

import ast.Expression;
import ast.Type;
import ast.expression.Ident;
import ast.expression.Visitor;
import ast.expression.Unary;

public class Neg extends Unary {

	public Neg(Expression expr) {
		super(expr);
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
		return "(-)";
	}

}
