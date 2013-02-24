package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statements.Body;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;


public interface IStatementVisitor<T> {

	T visit(Question question);
	
	T visit(ComputedQuestion computedQuestion);

	T visit(IfStatement ifStatement);
	
	T visit(Body body);
	
	T visit(Form form);

}
