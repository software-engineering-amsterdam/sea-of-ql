package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.*;

public interface ITypeChecker {
	
	void visit(Block element);
	void visit(CompQuestion element);
	void visit(Form element);
	void visit(IfThen element);
	void visit(IfThenElse element);
	void visit(Question element);

}
