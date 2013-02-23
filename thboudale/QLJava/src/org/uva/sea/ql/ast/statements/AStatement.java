package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.semanticCheck.FormStmtVisitor;

public abstract class AStatement implements ASTNode {
	
	public abstract <T> T accept(FormStmtVisitor<T> visitor);
}