package eu.karuza.ql.visitor;

import eu.karuza.ql.ast.AnswerableQuestion;
import eu.karuza.ql.ast.ComputedQuestion;
import eu.karuza.ql.ast.ConditionalStatement;
import eu.karuza.ql.ast.Form;

public interface StatementVisitor<T> extends NodeVisitor<T> {
	
	public T visit(Form node);

	public T visit(ConditionalStatement node);
	
	public T visit(AnswerableQuestion node);
	
	public T visit(ComputedQuestion node);

}
