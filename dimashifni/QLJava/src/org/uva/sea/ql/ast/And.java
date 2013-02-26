package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.value.Value;

public class And extends Expr {

    private final Expr lhs;
    private final Expr rhs;

    public And(Expr lhs, Expr rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Value evaluate()
    {
        // TODO
        return null;
    }
}
