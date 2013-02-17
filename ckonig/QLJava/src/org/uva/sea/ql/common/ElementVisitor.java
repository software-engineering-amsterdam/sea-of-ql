package org.uva.sea.ql.common;

import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;

public interface ElementVisitor {
	void visit(Form form) throws QLException;

	void visit(Block block) throws QLException;

	void visit(Question question) throws QLException;

	void visit(IfStatement ifStatement) throws QLException;
	
}
