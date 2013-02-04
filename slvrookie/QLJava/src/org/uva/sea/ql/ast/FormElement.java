package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.IElementVisitor;


public abstract class FormElement implements ASTNode {
	
	public abstract void accept(IElementVisitor ElementVisitor);
	
}
