package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;
import java.util.HashMap;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.literals.BooleanResult;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class GT extends BinExpr {

	public GT(Expr result, Expr rhs) {
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

		// Both op type money
		if ((new MoneyType()).isCompatibleTo(leftHandResult.typeOf())
				&& (new MoneyType()).isCompatibleTo(rightHandResult.typeOf())) {
			return new BooleanResult(leftHandResult.getMoneyValue().compareTo(
					rightHandResult.getMoneyValue()) == 1);
		}
		// Case 2 MoneyType Integer
		if ((new MoneyType()).isCompatibleTo(leftHandResult.typeOf())) {
			return new BooleanResult(leftHandResult.getMoneyValue().compareTo(
					new BigDecimal(rightHandResult.getIntegerValue())) == 1);
		}
		// Case 3 Integer MoneyType
		if ((new MoneyType()).isCompatibleTo(rightHandResult.typeOf())) {
			return new BooleanResult((new BigDecimal(
					leftHandResult.getIntegerValue()).compareTo(rightHandResult
					.getMoneyValue())) == 1);
		}
		// Case 4 Integer Integer
		return new BooleanResult(
				leftHandResult.getIntegerValue() > rightHandResult
						.getIntegerValue());

	}
}
