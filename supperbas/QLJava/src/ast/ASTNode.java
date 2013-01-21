package ast;

import ast.visitor.Visitor;

public interface ASTNode {
	void accept(Visitor visitor);
}
