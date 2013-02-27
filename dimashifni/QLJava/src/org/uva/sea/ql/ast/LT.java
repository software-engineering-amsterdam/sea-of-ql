package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

import java.util.Map;

public class LT extends Expr {
    private final Expr rhs;
    private final Expr lhs;

    public LT(Expr rhs, Expr lhs)
    {
        this.rhs = rhs;
        this.lhs = lhs;
    }

    @Override
    public Value evaluate(Map<Ident, Value> variables)
    {
        Value rhs = this.rhs.evaluate(variables);
        Value lhs = this.lhs.evaluate(variables);
        return rhs.lT(rhs);
    }

}
