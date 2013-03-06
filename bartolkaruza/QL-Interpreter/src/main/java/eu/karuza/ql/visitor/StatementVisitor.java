package eu.karuza.ql.visitor;

import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.statement.ComputedQuestion;
import eu.karuza.ql.ast.statement.IfConditionalStatement;
import eu.karuza.ql.ast.statement.IfElseConditionalStatement;

public interface StatementVisitor<T> extends NodeVisitor<T> {
	
	public T visit(Form node);

	public T visit(IfConditionalStatement node);
	
	public T visit(AnswerableQuestion node);
	
	public T visit(ComputedQuestion node);
	
	public T visit(IfElseConditionalStatement node);

}
