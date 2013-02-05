package org.uva.sea.ql.common;

import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;

public interface ElementVisitor {
	void visit(Form form) throws VisitorException;

	void visit(Block block) throws VisitorException;

	void visit(Question question) throws VisitorException;

	void visit(IfStatement ifStatement) throws VisitorException;
	
}
