package org.uva.sea.ql.ast;


public interface StatementVisitor<T> {

	T visit(Form form);

	T visit(CompoundStatement compoundStatement);

	T visit(Computed computed);

	T visit(IfStatement ifStatement);

	T visit(IfElseStatement ifElseStatement);

	T visit(Question question);

}
