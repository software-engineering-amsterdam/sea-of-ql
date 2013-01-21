package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;

public interface StatementVisitor {

	public VisitorResult visit(Block block);

	public VisitorResult visit(ComputedQuestion computedQuestion);

	public VisitorResult visit(IfStatement ifStatement);

	public VisitorResult visit(Question question);

}
