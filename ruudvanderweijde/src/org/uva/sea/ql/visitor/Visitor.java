package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.binary.Binary;
import org.uva.sea.ql.ast.expr.unary.Unary;
import org.uva.sea.ql.ast.stmt.Statement;

public interface Visitor {
	void visit(ASTNode node);
	// visit expressions
	void visit(Expr expr);
	void visit(Binary binary);
	void visit(Unary unary);
	
	// visit form
	void visit(Form form);
	
	// visit statements
	void visit(Statement statement);
}
