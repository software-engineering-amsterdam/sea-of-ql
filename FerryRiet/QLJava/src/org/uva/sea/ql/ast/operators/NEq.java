package org.uva.sea.ql.ast.operators;

import java.util.Map;

import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class NEq extends BinExpr {

	public NEq(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public Type typeOf(Map<String, Statement> typeEnv) {
		return new BooleanType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Result eval(Map<String, Result> symbolMap) {
		Result leftHandResult = getExprLeftHand().eval(symbolMap);
		Result rightHandResult = getExprRightHand().eval(symbolMap);
		return leftHandResult.neq(rightHandResult);
	}
}
