package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionAnswerable;
import org.uva.sea.ql.ast.statement.QuestionComputed;


public interface IVisitorStatement<T>{

	T visit(Form form);
	T visit(Block block);
	T visit(IfThen branch);
	T visit(IfThenElse branch);
	T visit(QuestionAnswerable question);
	T visit(QuestionComputed question);

}
