package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.Ifthenelse;
import org.uva.sea.ql.ast.statements.Question;

public interface IStatementVisitor {
	
	public void visit (Form form);
	public void visit (ComQuestion comquestions);
	public void visit (IfThen ifthen);
	public void visit (Ifthenelse ifthenelse);
	public void visit (Question question);
}
