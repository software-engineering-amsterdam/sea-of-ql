package org.uva.sea.ql.ast.literals;

import java.math.BigDecimal;

import java.util.HashMap;

import org.uva.sea.ql.ast.operatorresults.MoneyResult;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;

public class MoneyLiteral extends Expr {
	private final BigDecimal value;

	public MoneyLiteral(int n) {
		this.value = new BigDecimal(n);
	}

	public MoneyLiteral(String n) {
		this.value = new BigDecimal(n);
	}

	public BigDecimal getValue() {
		return value;
	}

	@Override
	public Type typeOf(HashMap<String, Statement> symbolMap) {
		return new MoneyType();
	}

	@Override
	public Result eval(HashMap<String, Result> symbolMap) {
		return new MoneyResult(value);
	}

}
