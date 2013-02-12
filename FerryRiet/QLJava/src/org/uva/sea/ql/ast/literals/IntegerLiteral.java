package org.uva.sea.ql.ast.literals;

import java.util.HashMap;

import org.uva.sea.ql.ast.operatorresults.IntegerResult;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class IntegerLiteral extends Expr {

	private final int value;

	public IntegerLiteral(String str) {
		this.value = new Integer(str);
	}

	public int getValue() {
		return value;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(HashMap<String, Statement> typeEnv) {
		return new IntegerType();
	}

	@Override
	public Result eval(HashMap<String, Result> symbolMap) {
		return new IntegerResult(value);
	}
}
