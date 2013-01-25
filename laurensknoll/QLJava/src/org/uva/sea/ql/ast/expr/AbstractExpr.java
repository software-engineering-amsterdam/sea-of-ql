package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.Expression;
import org.uva.sea.ql.visitor.semantic.Environment;

public abstract class AbstractExpr implements ASTNode {

	public abstract <T> T accept(Expression<T> visitor);

	public abstract AbstractType typeOf(Environment environment);

}
