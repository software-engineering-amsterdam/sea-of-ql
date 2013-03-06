package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Form;

public interface Visitor<T> {
	T visit(Form ast);
	T visit(If ast);
	T visit(QuestionVar ast);
	T visit(QuestionComputed ast);
	T visit(Var ast);
	T visit(Block ast);
}
