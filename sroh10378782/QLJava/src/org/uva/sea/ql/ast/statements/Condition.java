package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IUnaryNode;

public class Condition extends Expr implements IUnaryNode {
	private final Expr condition;
	public Condition(Expr condition){
		this.condition = condition;
	}
	public String getValue(){
		return null;
	}
	
	@Override
	public boolean isBinaryNode(){
		return false;
	}
	@Override
	public boolean isUnaryNode(){
		return true;
	}
	@Override
	public boolean isMultiNode() {
		return false;
	}
	@Override
	public Expr getExpr() {
		return this.condition;
	}
	@Override
	public boolean hasExpr() {
		return true;
	}
}
