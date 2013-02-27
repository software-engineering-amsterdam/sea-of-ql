package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

import java.util.Map;

public class And extends Expr {
    private final Expr lhs;
    private final Expr rhs;

    public And(Expr lhs, Expr rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Value evaluate(Map<Ident, Value> variables)
    {
        Value lhs = this.lhs.evaluate(variables);
        Value rhs = this.rhs.evaluate(variables);
        return lhs.and(rhs);
    }
}
