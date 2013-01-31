package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.stmnt.Body;
import org.uva.sea.ql.ast.stmnt.ComputedQuestion;
import org.uva.sea.ql.ast.stmnt.Form;
import org.uva.sea.ql.ast.stmnt.IfStatement;
import org.uva.sea.ql.ast.stmnt.Question;

public interface IStatementChecker {
	
	public boolean visit(Question question);
	
	public boolean visit(ComputedQuestion computedQuestion);

	public boolean visit(IfStatement ifStatement);
	
	public boolean visit(Body body);
	
	public boolean visit(Form form);
	
}
