package org.uva.sea.ql.core.dom;

import org.uva.sea.ql.core.dom.types.declarations.TypeDeclaration;

public abstract class Expression extends ASTNode {
	
	public abstract void accept(ExpressionVisitor visitor);	
	
	public abstract TypeDeclaration getType();
}
