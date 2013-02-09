package org.uva.sea.ql.ast.operators;

import java.util.HashMap;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.literals.BooleanResult;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Not extends UnExpr {

	public Not(Expr x) {
		super(x);
	}

	@Override
	public Type typeOf(HashMap<String, Statement> typeEnv) {
		return new BooleanType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Result eval(HashMap<String, Result> symbolMap) {
		Result rightHandResult = getExprRightHand().eval(symbolMap);

		return new BooleanResult(!rightHandResult.getBooleanValue());
	}
}
