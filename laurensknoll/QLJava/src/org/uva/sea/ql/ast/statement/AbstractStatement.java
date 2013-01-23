package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Statement;

public abstract class AbstractStatement implements ASTNode {

	public abstract <T> T accept(Statement<T> visitor);

}
