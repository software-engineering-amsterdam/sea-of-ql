package org.uva.sea.ql.ast.formelements;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitors.IElementVisitor;

public abstract class FormElement implements ASTNode {

	public abstract void accept(IElementVisitor ElementVisitor);

}
