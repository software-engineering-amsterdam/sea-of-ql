package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.ql.ComputedQuestion;
import org.uva.sea.ql.ast.ql.ConditionalElseQuestion;
import org.uva.sea.ql.ast.ql.ConditionalQuestion;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.semanticchecker.ReturnType;

public interface StatementVisitor {
	
	public ReturnType visit(QLForm form);
	public ReturnType visit(Question question);	
	public ReturnType visit(ComputedQuestion question);
	public ReturnType visit(ConditionalQuestion question);
	public ReturnType visit(ConditionalElseQuestion question);
}
