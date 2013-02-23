package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.visitor.VisitorStatements;

public abstract class FormUnit implements ASTNode{
	
	public abstract <T> T accept(VisitorStatements<T> visitor);

}
