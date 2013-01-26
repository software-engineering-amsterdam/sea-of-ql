package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.TypeChecker;

public abstract class FormElement implements ASTNode {
	
	public abstract void accept(TypeChecker visitor);
	
}
