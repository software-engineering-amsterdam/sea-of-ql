package org.uva.sea.ql.ast.operators;

import java.util.HashMap;

import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Mul extends BinExpr {

	public Mul(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Result eval(HashMap<String, Result> symbolMap) {
		Result leftHandResult = getExprLeftHand().eval(symbolMap);
		Result rightHandResult = getExprRightHand().eval(symbolMap);
		return leftHandResult.mul(rightHandResult);
	}
}
