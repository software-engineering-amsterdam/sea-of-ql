package org.uva.sea.ql.ast.nodes.types;

import org.uva.sea.ql.ast.expressions.Expr;

public class Float extends Numeric implements ComputatedType {
	private final float value;
	private final Expr computationExpression;
	private final boolean isComputated;
	
	public Float(float n) {
		this.value = n;
		this.computationExpression = null;
		this.isComputated = false;
	}
	
	public Float(Expr expr) {
		this.computationExpression = expr;
		this.value = 0;
		this.isComputated = true;
	}

	public float getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return super.toString() + " Float ";
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
	public boolean isFloatType(){
		return true;
	}
}
