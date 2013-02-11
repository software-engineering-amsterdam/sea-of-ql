package org.uva.sea.ql.ast.literals;

import java.util.HashMap;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class BooleanLiteral extends Expr {
	private final String value;

	public BooleanLiteral(String string) {
		value = string.toLowerCase();
	}

	public String getValue() {
		return value;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(HashMap<String, Statement> typeEnv) {
		return new BooleanType();
	}

	@Override
	public Result<boolean> eval(HashMap<String, Result> symbolMap) {
		return new BooleanResult(value.equals("true"));
	}
}
