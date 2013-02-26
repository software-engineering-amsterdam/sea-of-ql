package org.uva.sea.ql.parser.typechecker.error;

import org.uva.sea.ql.ast.ASTNode;

public abstract class SemanticError {
	private final String message;
	private final ASTNode node;
	
	public SemanticError(String message, ASTNode node) {
		this.message = message;
		this.node = node;
	}
	
	public String getMessage() {
		return message;
	}
	
	public ASTNode getNode() {
		return node;
	}
	
	public String toString() {
		return "at " + getNode().getLocation() + ": " + getMessage();
	}
	
}
