package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.value.Value;

public class Not extends Expr {

    private final Expr expr;

	public Not (Expr expr)
	{
	    this.expr = expr;
	}

    @Override
    public Value evaluate()
    {
        Value value = this.expr.evaluate();
        return value.not();
    }

}
