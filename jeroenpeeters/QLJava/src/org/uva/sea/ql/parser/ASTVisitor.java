package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Literal;
import org.uva.sea.ql.ast.expression.UnaryExpr;

public interface ASTVisitor {
	
	void visit(Form form);
	
	void visit(CompoundStatement statement);
	
	void visit(Question question);
	
	void visit(IfStatement statement);
	
	void visit(BinaryExpr expression);
	
	void visit(UnaryExpr expression);
	
	void visit(Ident ident);
	
	void visit(Literal literal);
	
	
}
