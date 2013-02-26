package org.uva.sea.ql.ast.statement;


public interface IVisitorStatement<T>{

	T visit(Form form);
	T visit(Block block);
	T visit(IfThen branch);
	T visit(IfThenElse branch);
	T visit(QuestionAnswerable question);
	T visit(QuestionComputed question);

}
