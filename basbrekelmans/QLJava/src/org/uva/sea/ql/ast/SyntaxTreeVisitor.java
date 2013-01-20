package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.*;

public interface SyntaxTreeVisitor {
	//base type
	void visit(Node element);
	
	//expressions	
	void visit(Expression element);
	void visit(Binary element);
	void visit(Arithmetic element);
	void visit(Comparison element);
	void visit(Logical element);
	void visit(Simple element);
	void visit(Unary element);
	
}
