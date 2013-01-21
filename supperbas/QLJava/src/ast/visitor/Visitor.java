package ast.visitor;

import ast.*;

public interface Visitor {
	void visit(Statement statement);
	void visit(Expression expr);
	
}
