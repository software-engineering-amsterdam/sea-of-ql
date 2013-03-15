package org.uva.sea.ql.ast.statement;

/**
 * Interface to enable double-dispatch visiting of statements using the visitor pattern
 * @param <T> The return type of the visit method
 */
public interface StatementVisitor<T> {

	T visit(ComputedQuestion stat);
	T visit(Question stat);
	T visit(IfBlock stat);
	T visit(Form stat);
	T visit(Statements stat);
	
}
