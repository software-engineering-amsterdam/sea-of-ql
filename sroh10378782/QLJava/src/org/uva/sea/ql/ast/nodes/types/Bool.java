package org.uva.sea.ql.ast.nodes.types;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class Bool extends Type implements ComputatedType {
	private final Boolean value;
	private final Expr computationExpression;
	private final boolean isComputated;
	
	public Bool(Boolean n) {
		this.value = n;
		this.computationExpression = null;
		this.isComputated = false;
	}
	
	public Bool(Expr expr) {
		this.computationExpression = expr;
		this.value = null;
		this.isComputated = true;
	}
	
	public Boolean getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return "Bool";
	}
	
	@Override
	public boolean isCompatibleWithBool(){
		return true;
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
	public boolean isBoolType(){
		return true;
	}
}