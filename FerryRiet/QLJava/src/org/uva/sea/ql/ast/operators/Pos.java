package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;
import java.util.HashMap;

import org.uva.sea.ql.ast.literals.IntegerResult;
import org.uva.sea.ql.ast.literals.MoneyResult;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Pos extends UnExpr {

	public Pos(Expr x) {
		super(x);
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
		// I have problems with the sementic of this operator
		// is it not ABS?
		Result rightHandResult = getExprRightHand().eval(symbolMap);

		if (rightHandResult.isCompatibleToMoney()) {
			return new MoneyResult(rightHandResult.getMoneyValue().multiply(
					new BigDecimal(-1)));
		}
		return new IntegerResult(rightHandResult.getIntegerValue() * -1);
	}
}
