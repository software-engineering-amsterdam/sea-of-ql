package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.value.Value;

public class Neg extends Expr {

    private final Expr expr;

	public Neg (Expr expr)
	{
        this.expr = expr;
	}

    @Override
    public Value evaluate()
    {
        Value value = this.expr.evaluate();
        return value.neg();
    }

}
