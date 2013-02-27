package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

import java.util.Map;

public class Neg extends Expr {

    private final Expr expr;

	public Neg (Expr expr)
	{
        this.expr = expr;
	}

    @Override
    public Value evaluate(Map<Ident, Value> variables)
    {
        Value value = this.expr.evaluate(variables);
        return value.neg();
    }

}
