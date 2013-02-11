package org.uva.sea.ql.ast.operators;

import java.util.HashMap;

import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Add extends BinExpr {

	public Add(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public Type typeOf(HashMap<String, Statement> typeEnv) {
		return new IntegerType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Result eval(HashMap<String, Result> symbolMap) {
		Result leftHandResult = getExprLeftHand().eval(symbolMap);
		Result rightHandResult = getExprRightHand().eval(symbolMap);
	    return leftHandResult.add(rightHandResult) ;
	}
}
