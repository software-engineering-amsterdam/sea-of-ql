package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.IASTNode;
import org.uva.sea.ql.visitor.IStatement;

public abstract class AbstractStatement implements IASTNode {

	public abstract <T> T accept(IStatement<T> visitor);

}
