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
	void visit(Form form);

	void visit(Block block);

	void visit(Question question);

	void visit(IfStatement ifStatement);

	void visit(Ident ident);
	
	void visit(Registry registry);
	
	void visit(AcceptsBoolOperands r);
	
	void visit(AcceptsMathOperands r);
	
	void visit(AcceptsBothOperands r);
}
