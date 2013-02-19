package org.uva.sea.ql.ast.literals;

import java.math.BigDecimal;
import java.util.Map;

import org.uva.sea.ql.ast.operatorresults.MoneyResult;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

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
	public Type typeOf(Map<String, Statement> symbolMap) {
		return new MoneyType();
	}

	@Override
	public Result eval(Map<String, Result> symbolMap) {
		return new MoneyResult(value);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
