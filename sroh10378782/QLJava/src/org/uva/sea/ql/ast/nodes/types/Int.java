package org.uva.sea.ql.ast.nodes.types;

import org.uva.sea.ql.ast.expressions.Expr;


public class Int extends Numeric implements ComputatedType {

	private final Integer value;
	private final Expr computationExpression;
	private final boolean isComputated;
	
	
	public Int(Integer n) {
		this.value = n;
		this.computationExpression = null;
		this.isComputated = false;
	}
	
	public Int(Expr expr) {
		this.computationExpression = expr;
		this.value = 0;
		this.isComputated = true;
	}
	
	public Integer getValue() {
		return value;
	}
	@Override
	public String toString(){
		return super.toString() + " Int ";
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
	public boolean isIntType(){
		return true;
	}
}
