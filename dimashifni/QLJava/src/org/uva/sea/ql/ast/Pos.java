package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.value.Value;

public class Pos extends Expr {

    private final Expr expr;

	public Pos(Expr expr)
	{
        this.expr = expr;
	}

    @Override
    public Value evaluate()
    {
        Value value = expr.evaluate();
        return value.pos();
    }

}
