package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.value.Value;

public class Mul extends Expr {

    private Expr lhs;
    private Expr rhs;

    public Mul (Expr lhs, Expr rhs)
    {
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
