package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.ql.ComputedQuestion;
import org.uva.sea.ql.ast.ql.ConditionalElseQuestion;
import org.uva.sea.ql.ast.ql.ConditionalQuestion;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.Question;

public interface StatementVisitor {
	
	public void visit(QLForm form);
	public void visit(Question question);	
	public void visit(ComputedQuestion question);
	public void visit(ConditionalQuestion question);
	public void visit(ConditionalElseQuestion question);
}
