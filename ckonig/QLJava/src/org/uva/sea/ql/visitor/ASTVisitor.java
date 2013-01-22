package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;

public interface ASTVisitor {
	void visit(Form form) throws VisitorException;

	void visit(Block block) throws VisitorException;

	void visit(Question question) throws VisitorException;

	void visit(IfStatement ifStatement) throws VisitorException;
	
	void visit(Registry registry) throws VisitorException;
}
