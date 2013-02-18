package org.uva.sea.ql.ast.visitors.statementchecker;

import org.uva.sea.ql.ast.statements.ConditionBlock;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;

public interface Visitor {
	
	void visit(ConditionBlock     statement);
	void visit(AnswerableQuestion statement);
	void visit(ComputedQuestion   statement);
	
}