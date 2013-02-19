package eu.karuza.ql.visitor;

import eu.karuza.ql.ast.AnswerableQuestion;
import eu.karuza.ql.ast.ComputedQuestion;
import eu.karuza.ql.ast.IfConditionalStatement;
import eu.karuza.ql.ast.IfElseConditionalStatement;
import eu.karuza.ql.ast.Form;

public interface StatementVisitor<T> extends NodeVisitor<T> {
	
	public T visit(Form node);

	public T visit(IfConditionalStatement node);
	
	public T visit(AnswerableQuestion node);
	
	public T visit(ComputedQuestion node);
	
	public T visit(IfElseConditionalStatement node);

}
