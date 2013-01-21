package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.StatementVisitor;

public abstract class AbstractStatement implements ASTNode {

	public abstract void accept(StatementVisitor<?> visitor);

}
