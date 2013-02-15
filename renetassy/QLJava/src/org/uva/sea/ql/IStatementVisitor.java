package org.uva.sea.ql;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.stmnt.Body;
import org.uva.sea.ql.ast.stmnt.ComputedQuestion;
import org.uva.sea.ql.ast.stmnt.IfStatement;
import org.uva.sea.ql.ast.stmnt.Question;

public interface IStatementVisitor<T> {

	T visit(Question question);
	
	T visit(ComputedQuestion computedQuestion);

	T visit(IfStatement ifStatement);
	
	T visit(Body body);
	
	T visit(Form form);

}
