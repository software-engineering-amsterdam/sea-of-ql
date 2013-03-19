package org.uva.sea.ql.ast.statement;

/**
 * Interface to enable double-dispatch visiting of statements using the visitor pattern
 */
public interface StatementVisitor {

	void visit(ComputedQuestion stat);
	void visit(Question stat);
	void visit(IfThen stat);
	void visit(IfThenElse stat);
	void visit(Form stat);
	void visit(Block stat);
	
}
