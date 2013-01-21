package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;

public interface StatementVisitor<T> {

	public T visit(Block block);

	public T visit(ComputedQuestion computedQuestion);

	public T visit(IfStatement ifStatement);

	public T visit(Question question);

}
