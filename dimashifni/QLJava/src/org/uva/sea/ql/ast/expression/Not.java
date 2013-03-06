package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.type.BoolType;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

public class Not extends Expr {

    private final Expr expr;

	public Not (Expr expr)
	{
	    this.expr = expr;
	}

    @Override
    public Value evaluate(Map<Ident, Value> variables)
    {
        Value value = this.expr.evaluate(variables);
        return value.not();
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public Type getType() {
        return new BoolType();
    }

}
