package org.uva.sea.ql.ast;

import org.uva.sea.ql.interfaces.IVisitor;


public abstract class Statement implements ASTNode {

	public abstract <T> T accept(IVisitor<T> visitor); 
}
