package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.AcceptsBoolOperands;
import org.uva.sea.ql.ast.AcceptsBothOperands;
import org.uva.sea.ql.ast.AcceptsMathOperands;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;

public interface ASTVisitor {
	void visit(Form form) throws VisitorException;

	void visit(Block block) throws VisitorException;

	void visit(Question question) throws VisitorException;

	void visit(IfStatement ifStatement) throws VisitorException;

	void visit(Ident ident) throws VisitorException;
	
	void visit(Registry registry) throws VisitorException;
	
	void visit(AcceptsBoolOperands r) throws VisitorException;
	
	void visit(AcceptsMathOperands r) throws VisitorException;
	
	void visit(AcceptsBothOperands r) throws VisitorException;
}
