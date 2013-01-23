package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.*;

public interface ITypeChecker {
	
	void visit(Form element);
	void visit(CompQuestion element);
	void visit(IfBody element);
	void visit(Question element);

}
