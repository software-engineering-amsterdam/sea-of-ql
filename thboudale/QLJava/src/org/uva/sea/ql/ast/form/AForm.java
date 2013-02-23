package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.semanticCheck.FormStmtVisitor;

public abstract class AForm implements ASTNode {
	
	public abstract <T> T accept(FormStmtVisitor<T> visitor);
}
