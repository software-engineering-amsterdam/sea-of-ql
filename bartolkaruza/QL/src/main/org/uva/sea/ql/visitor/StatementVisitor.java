package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;

public interface StatementVisitor<T> extends NodeVisitor<T> {
	
	public T visit(Form node);

	public T visit(ConditionalStatement node);
	
	public T visit(AnswerableQuestion node);
	
	public T visit(ComputedQuestion node);

}
