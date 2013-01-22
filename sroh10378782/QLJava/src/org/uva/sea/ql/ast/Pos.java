package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.nodes.IUnaryNode;

public class Pos extends Expr  implements IUnaryNode   {
	private final Expr x;
	
	public Pos(Expr pos){
		this.x = pos;
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
	public String getValue() {
		return null;
	}

	@Override
	public boolean hasExpr() {
		return true;
	}
}
