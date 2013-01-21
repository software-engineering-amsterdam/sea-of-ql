package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;

public interface Statement<T> {

	public T visit(Block block);

	public T visit(ComputedQuestion computedQuestion);

	public T visit(If ifStatement);

	public T visit(Question question);

}
