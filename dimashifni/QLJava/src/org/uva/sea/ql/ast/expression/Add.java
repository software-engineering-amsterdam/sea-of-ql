package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.type.NumericType;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

public class Add extends Expr {
    private Expr lhs;
    private Expr rhs;

	public Add (Expr lhs, Expr rhs)
	{
        this.lhs = lhs;
        this.rhs = rhs;
	}

    public Expr getLhs() {
        return lhs;
    }

    public Expr getRhs() {
        return rhs;
    }

    @Override
    public Type getType() {
        return new NumericType();
    }

    @Override
    public Value evaluate(Map<Ident, Value> variables) {
        Value lhs = this.lhs.evaluate(variables);
        Value rhs = this.rhs.evaluate(variables);
        return lhs.add(rhs);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
