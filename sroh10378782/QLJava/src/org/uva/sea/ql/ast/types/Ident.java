package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IUnaryNode;

public class Ident extends Expr implements IUnaryNode {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return name;
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
