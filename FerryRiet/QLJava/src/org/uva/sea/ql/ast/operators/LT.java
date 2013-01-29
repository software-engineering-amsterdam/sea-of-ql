package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;
import java.util.HashMap;

import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.TypeDescription;

public class LT extends BinExpr {

	public LT(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public TypeDescription typeOf(HashMap<String, Statement> typeEnv) {
		return new BooleanType();
	}

	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public ExpressionResult eval(HashMap<String, ExpressionResult> symbolMap) {
		// TODO and check type
		ExpressionResult leftHandResult ;
		ExpressionResult rightHandResult ;

		leftHandResult = getExprLeftHand().eval(symbolMap);
		rightHandResult = getExprRightHand().eval(symbolMap);

		// Both op type money
		if ((new MoneyType()).isCompatibleTo(leftHandResult.typeOf())
				&& (new MoneyType()).isCompatibleTo(rightHandResult.typeOf())) {
			return new BooleanResult(leftHandResult.getMoneyValue().compareTo(rightHandResult.getMoneyValue()) == -1);
		}
		// Case 2 MoneyType  Integer
		if ((new MoneyType()).isCompatibleTo(leftHandResult.typeOf())) {
			return new BooleanResult(leftHandResult.getMoneyValue().compareTo(new BigDecimal(rightHandResult.getValue())) == -1);
		}
		// Case 3 Integer MoneyType
		if ((new MoneyType()).isCompatibleTo(rightHandResult.typeOf())) {
			return new BooleanResult((new BigDecimal(leftHandResult.getValue()).compareTo(rightHandResult.getMoneyValue())) == -1);
		}
		// Case 4 Integer Integer
		return new BooleanResult(leftHandResult.getValue() < rightHandResult.getValue());
	}
}
