package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.stat.AnswerableStat;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedStat;
import org.uva.sea.ql.ast.stat.IfThenElseStat;
import org.uva.sea.ql.ast.stat.IfThenStat;

public interface StatementVisitor<T> {
	
	T visit(ComputedStat stat);

	T visit(AnswerableStat stat);

	T visit(IfThenStat stat);

	T visit(IfThenElseStat stat);

	T visit(Block stat);
}
