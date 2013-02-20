package org.uva.sea.ql.ast.visitors.statementchecker;

import org.uva.sea.ql.ast.statements.conditions.IfThen;
import org.uva.sea.ql.ast.statements.conditions.IfThenElse;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;

public interface Visitor {
	
	void visit(IfThen             statement);
	void visit(IfThenElse         statement);
	void visit(AnswerableQuestion statement);
	void visit(ComputedQuestion   statement);
	
}