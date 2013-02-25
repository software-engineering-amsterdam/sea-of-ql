package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.IFormStmtVisitor;

public abstract class AStatement implements ASTNode {
	
	public abstract <T> T accept(IFormStmtVisitor<T> visitor);
}