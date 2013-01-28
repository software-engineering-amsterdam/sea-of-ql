package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IUnaryNode;

public class Bool extends Expr implements IUnaryNode {
	private final String value;
	public Bool(String n) {
		this.value = n;
	}
	public String getValue() {
		return value;
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
	public Expr getExpr() {
		return null;
	}
	@Override
	public boolean hasExpr() {
		return false;
	}
}
