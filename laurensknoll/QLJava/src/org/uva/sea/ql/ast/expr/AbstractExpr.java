package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Expression;

public abstract class AbstractExpr implements ASTNode {

	public abstract void accept(Expression<?> visitor);

}
