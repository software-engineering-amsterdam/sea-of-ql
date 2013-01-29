package org.uva.sea.ql.ast.statements;


public interface StatementVisitor<T> {
	
	public T visit(Block block);

	public T visit(IfThenElse ifThenElse);

	public T visit(Question question);
	
	public T visit(ComputedQuestion computedQuestion);

}
