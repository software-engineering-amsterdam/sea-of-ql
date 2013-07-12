package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.*;

public interface IFormVisitor<T> {
	public T visit(Form f);
	public T visit(ComputableQuestion q);
	public T visit(AnswerableQuestion q);
	public T visit(IfStatement ifStat);
}
