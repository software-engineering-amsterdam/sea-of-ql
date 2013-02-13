package org.uva.sea.ql.ast.operators;

import java.util.Map;

import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Div extends BinExpr {

	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Result eval(Map<String, Result> symbolMap) {
		Result leftHandResult = getExprLeftHand().eval(symbolMap);
		Result rightHandResult = getExprRightHand().eval(symbolMap);
		return leftHandResult.div(rightHandResult);
	}
}
