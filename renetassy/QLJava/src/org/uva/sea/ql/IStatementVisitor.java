package org.uva.sea.ql;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.stmnt.Body;
import org.uva.sea.ql.ast.stmnt.ComputedQuestion;
import org.uva.sea.ql.ast.stmnt.IfStatement;
import org.uva.sea.ql.ast.stmnt.Question;

public interface IStatementVisitor {
	
	public boolean visit(Question question);
	
	public boolean visit(ComputedQuestion computedQuestion);

	public boolean visit(IfStatement ifStatement);
	
	public boolean visit(Body body);
	
	public boolean visit(Form form);
	
}
