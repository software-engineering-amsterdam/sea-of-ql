package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.Context;

public interface ASTNode {
	void accept(Visitor visitor, Context context);
	
}
