package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.ITypeChecker;


public abstract class FormElement implements ASTNode {
	
	public abstract void accept(ITypeChecker TypeChecker);
	
}
