package org.uva.sea.ql.ast.visitors.statementchecker;

import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.ast.statements.conditions.IfThenStatement;
import org.uva.sea.ql.ast.statements.conditions.IfThenElseStatement;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;

public interface Visitor {
	
	void visit(IfThenStatement     statement);
	void visit(IfThenElseStatement statement);
	void visit(AnswerableQuestion  statement);
	void visit(ComputedQuestion    statement);
	void visit(StatementBody       statements);
	
}