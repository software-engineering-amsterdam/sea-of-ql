package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.stat.AnswerableStat;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedStat;
import org.uva.sea.ql.ast.stat.IfThenElseStat;
import org.uva.sea.ql.ast.stat.IfThenStat;

public interface StatementVisitor {

	void visit(ComputedStat stat);

	void visit(AnswerableStat stat);

	void visit(IfThenStat stat);

	void visit(IfThenElseStat stat);

	void visit(Block stat);
}
