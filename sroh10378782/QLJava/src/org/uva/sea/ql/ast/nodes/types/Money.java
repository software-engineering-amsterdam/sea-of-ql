package org.uva.sea.ql.ast.nodes.types;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class Money extends Numeric implements ComputatedType {
	
	private final String value;
	private final Expr computationExpression;
	private final boolean isComputated;
	
	public Money(String n) {
		this.value = n;
		this.computationExpression = null;
		this.isComputated = false;
	}
	
	public Money(Expr expr) {
		this.computationExpression = expr;
		this.value = "";
		this.isComputated = true;
	}
	
	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.value;
	}
	@Override
	public Expr getExpr() {
		return this.computationExpression;
	}
	@Override
	public boolean isComputatedType(){
		return this.isComputated;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	@Override
	public boolean isMoneyType(){
		return true;
	}
}
