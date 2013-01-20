package ast;

import ast.visitor.Visitor;

public abstract class Expression implements ASTNode {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
