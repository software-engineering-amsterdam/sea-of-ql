package ast;

import ast.visitors.Visitor;

public abstract class Stat implements ASTNode {

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
