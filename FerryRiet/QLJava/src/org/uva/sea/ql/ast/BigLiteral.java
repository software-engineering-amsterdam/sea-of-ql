package org.uva.sea.ql.ast;

import java.math.BigDecimal;
import java.util.HashMap;

import org.uva.sea.ql.ast.operators.ExpressionResult;
import org.uva.sea.ql.ast.types.TypeDescription;
import org.uva.sea.ql.ast.types.MoneyType;

public class BigLiteral extends Expr {
	private final BigDecimal value;

	public BigLiteral(int n) {
		this.value = new BigDecimal(n);
	}

	public BigLiteral(String n) {
		this.value = new BigDecimal(n);
	}

	public BigDecimal getValue() {
		return value;
	}

	@Override
	public TypeDescription typeOf(HashMap<String, Statement> symbolMap) {
		return new MoneyType();
	}

	@Override
	public ExpressionResult eval(HashMap<String, Statement> symbolMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
