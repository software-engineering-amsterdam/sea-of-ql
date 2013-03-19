package org.uva.sea.ql.ast.visitors;

import org.uva.sea.ql.ast.statement.*;

public interface StatementVisitor<T> {
	
	T visit(Body stat);
	T visit(ComputedQuestion stat);
	T visit(ElseIfStat stat);
	T visit(ElseStat stat);
	T visit(Form stat);
	//T visit(FormElem stat);
	T visit(IfStat stat);
	T visit(NonComputedQuestion stat);
	//T visit(Question stat);
	//T visit(QuestionBlock stat);
	
}
