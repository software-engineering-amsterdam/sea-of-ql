package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

import java.util.Map;

public class Pos extends Expr {

    private final Expr expr;

	public Pos(Expr expr)
	{
        this.expr = expr;
	}

    @Override
    public Value evaluate(Map<Ident, Value> variables)
    {
        Value value = expr.evaluate(variables);
        return value.pos();
    }

}
