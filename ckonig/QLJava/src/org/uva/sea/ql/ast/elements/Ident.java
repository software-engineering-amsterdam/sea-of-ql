package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.bool.BoolOperand;
import org.uva.sea.ql.ast.math.MathOperand;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;

public class Ident extends Expr implements MathOperand, BoolOperand, ASTElement {

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
