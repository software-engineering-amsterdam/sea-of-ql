package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.ql.ComputedQuestion;
import org.uva.sea.ql.ast.ql.ConditionalElseQuestion;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.ast.ql.SimpleConditionalQuestion;

public interface QLItemSemanticVisitor {
	
	public void visit(QLForm form);
	public void visit(Question question);	
	public void visit(ComputedQuestion question);
	public void visit(SimpleConditionalQuestion question);
	public void visit(ConditionalElseQuestion question);
	
}
