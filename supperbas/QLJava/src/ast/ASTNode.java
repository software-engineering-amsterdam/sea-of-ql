package ast;

import ast.visitor.Visitor;

public interface ASTNode {
	public abstract <T> T accept(Visitor<T> visitor);
}
