package org.uva.sea.ql.ast.expr.value;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;
import org.uva.sea.ql.ast.expr.type.MoneyType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Money extends ValueExpr {

	private BigDecimal value;
	private Type type = new MoneyType();

	public Money(int lineNumber) {
		super(lineNumber);
		this.value = BigDecimal.valueOf(0.0f);
	}

	public Money(int lineNumber, String initialValue) {
		super(lineNumber);
		this.value = new BigDecimal(initialValue);
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return type;
	}

}
