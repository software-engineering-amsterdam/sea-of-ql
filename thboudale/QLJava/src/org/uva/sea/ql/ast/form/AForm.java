package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.IFormStmtVisitor;

public abstract class AForm implements ASTNode {
	
	public abstract <T> T accept(IFormStmtVisitor<T> visitor);
}