package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public abstract class AbstractExpr implements ASTNode {

	public abstract void accept(ExpressionVisitor visitor);

}
