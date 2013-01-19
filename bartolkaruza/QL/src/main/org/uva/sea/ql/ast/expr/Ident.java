package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Ident extends Expr {
	
	private final String name;
	private final int lineNumber;
	
	public Ident(String name, int lineNumber) {
		this.name = name;
		this.lineNumber = lineNumber;
	}
	
	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public int getLineNumber() {
		return lineNumber;
	}

}
