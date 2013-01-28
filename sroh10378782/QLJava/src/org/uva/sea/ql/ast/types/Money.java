package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IUnaryNode;

public class Money extends Expr implements IUnaryNode {
	
	private final String value;
	private final Expr x;
	private final boolean hasExpr;
	public Money(String n) {
		this.value = n;
		this.hasExpr = false;
		this.x = null;
	}
	public Money(Expr x) {
		this.x = x;
		this.hasExpr = true;
		this.value = "money";
	}
	public String getValue() {
		return this.value;
	}
	public Expr getExpr(){
		return this.x;
	}
	@Override
	public boolean isBinaryNode() {
		return false;
	}
	@Override
	public boolean isUnaryNode() {
		return true;
	}
	@Override
	public boolean isMultiNode() {
		return false;
	}
	@Override
	public boolean hasExpr() {
		return hasExpr;
	}
}
