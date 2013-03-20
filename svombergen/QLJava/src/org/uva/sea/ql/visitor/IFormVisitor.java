package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.*;

public interface IFormVisitor {
	public void visit(Form f);
	public void visit(ComputableQuestion q);
	public void visit(AnswerableQuestion q);
	public void visit(IfStatement ifStat);
}
