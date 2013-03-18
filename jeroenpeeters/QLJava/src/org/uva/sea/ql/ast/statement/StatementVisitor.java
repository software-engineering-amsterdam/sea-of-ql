package org.uva.sea.ql.ast.statement;

public interface StatementVisitor<T> {

	T visit(Form form);
	
	T visit(CompoundStatement statement);
	
	T visit(Question question);
	
	T visit(Label label);
	
	T visit(IfStatement statement);
	
	T visit(IfElseStatement statement);
	
}
