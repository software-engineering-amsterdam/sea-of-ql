package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;

public interface StatementVisitor extends NodeVisitor {
	
	public void visit(Form node);

	public void visit(ConditionalStatement node);
	
	public void visit(AnswerableQuestion node);
	
	public void visit(ComputedQuestion node);

}
