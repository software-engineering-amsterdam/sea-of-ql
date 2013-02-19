package org.uva.sea.ql.ast.operators;

import java.util.Map;

import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class And extends BinExpr {

	public And(Expr result, Expr rhs) {
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
		Result leftHandresult = getExprLeftHand().eval(symbolMap);
		Result rightHandResult = getExprRightHand().eval(symbolMap);
		return leftHandresult.and(rightHandResult);
	}
}
