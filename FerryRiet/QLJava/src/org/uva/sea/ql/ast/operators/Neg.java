package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;
import java.util.Map;

import org.uva.sea.ql.ast.operatorresults.IntegerResult;
import org.uva.sea.ql.ast.operatorresults.MoneyResult;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Neg extends UnExpr {

	public Neg(Expr x) {
		super(x);
	}

	@Override
	public Type typeOf(Map<String, Statement> typeEnv) {
		return new IntegerType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Result eval(Map<String, Result> symbolMap) {
		Result rightHandResult = getExprRightHand().eval(symbolMap);

		if (rightHandResult.isCompatibleToMoney()) {
			return new MoneyResult(rightHandResult.getMoneyValue().multiply(new BigDecimal(-1)));
		}
		return new IntegerResult(rightHandResult.getIntegerValue() * -1);
	}
}
