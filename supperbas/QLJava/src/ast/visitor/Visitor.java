package ast.visitor;

import ast.Expression;
import ast.type.Type;

public interface Visitor {
	void visit(Type type);
	void visit(Expression expr);
	
}
