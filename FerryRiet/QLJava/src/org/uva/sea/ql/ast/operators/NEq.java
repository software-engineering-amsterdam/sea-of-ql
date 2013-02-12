package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;
import java.util.HashMap;

import org.uva.sea.ql.ast.operatorresults.BooleanResult;
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
	public Type typeOf(HashMap<String, Statement> typeEnv) {
		return new BooleanType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Result eval(HashMap<String, Result> symbolMap) {
		Result leftHandResult = getExprLeftHand().eval(symbolMap);
		Result rightHandResult = getExprRightHand().eval(symbolMap);

		// case 0 Both type boolean
		if (leftHandResult.typeOf().isCompatibleToBool()) {
			return new BooleanResult(
					leftHandResult.getBooleanValue() != rightHandResult.getBooleanValue());
		}
		// case 1 Both type money
		if (leftHandResult.typeOf().isCompatibleToMoney()
				&& rightHandResult.typeOf().isCompatibleToMoney()) {
			return new BooleanResult(leftHandResult.getMoneyValue().compareTo(
					rightHandResult.getMoneyValue()) != 0);
		}
		// Case 2 MoneyType Integer
		if (leftHandResult.typeOf().isCompatibleToMoney()) {
			return new BooleanResult(leftHandResult.getMoneyValue().compareTo(
					new BigDecimal(rightHandResult.getIntegerValue())) != 0);
		}
		// Case 3 Integer MoneyType
		if (rightHandResult.typeOf().isCompatibleToMoney()) {
			return new BooleanResult(
					(new BigDecimal(leftHandResult.getIntegerValue())
							.compareTo(rightHandResult.getMoneyValue())) != 0);
		}
		// Case 4 Integer Integer
		return new BooleanResult(
				leftHandResult.getIntegerValue() != rightHandResult.getIntegerValue());
	}
}
