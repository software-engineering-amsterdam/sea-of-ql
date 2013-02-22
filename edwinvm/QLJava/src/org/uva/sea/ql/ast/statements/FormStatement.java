package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;

public abstract class FormStatement implements ASTNode {
	
	public abstract void accept(Visitor visitor);
	
}