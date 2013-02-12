package org.uva.sea.ql.ast.literals;

import java.util.Map;

import org.uva.sea.ql.ast.operatorresults.BooleanResult;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.statements.Statement;
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
	public Type typeOf(Map<String, Statement> typeEnv) {
		return new BooleanType();
	}

	@Override
	public Result eval(Map<String, Result> symbolMap) {
		return new BooleanResult(value.equals("true"));
	}
}
