package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.bool.BinaryBoolOperator;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.math.BinaryMathOperator;

public interface ASTVisitor {
	void visit(Form form);

	void visit(Block block);

	void visit(Question question);

	void visit(IfStatement ifStatement);

	void visit(Ident ident);

	public void visit(BinaryBoolOperator op);

	public void visit(BinaryMathOperator op);
	
	public void visit(Registry registry);
}
