package org.uva.sea.ql.check.statements;

import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.ast.statements.ConditionBlock;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;

public class StatementChecker implements Visitor {
	
	public static void check(FormStatement statement) {
		StatementChecker statementChecker = new StatementChecker();
		statement.accept(statementChecker);
	}

	@Override
	public void visit(ConditionBlock statement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(AnswerableQuestion statement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ComputedQuestion statement) {
		// TODO Auto-generated method stub
		
	}
	
}