package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

public class Sub extends Expr {

    private Expr lhs;
    private Expr rhs;

    public Sub (Expr lhs, Expr rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Value evaluate(Map<Ident, Value> variables) {
        Value lhs = this.lhs.evaluate(variables);
        Value rhs = this.rhs.evaluate(variables);
        return lhs.sub(rhs);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
