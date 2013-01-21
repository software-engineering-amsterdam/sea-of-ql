package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;
import org.uva.sea.ql.ast.ReturnsMathOperands;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;

public class Ident extends Expr implements ReturnsMathOperands, ReturnsBoolOperands, ASTElement {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

}
