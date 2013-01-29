package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.IASTNode;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.semantic.Environment;

public abstract class AbstractExpr implements IASTNode {

	public abstract <T> T accept(IExpression<T> visitor);

	public abstract AbstractType typeOf(Environment environment);

}
