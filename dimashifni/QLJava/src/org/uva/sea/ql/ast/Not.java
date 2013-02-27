package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

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

}
