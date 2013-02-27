package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

import java.util.Map;

public class Or extends Expr {
    private final Expr lhs;
    private final Expr rhs;

	public Or(Expr lhs, Expr rhs)
	{
		this.rhs  = rhs;
        this.lhs = lhs;
	}

    @Override
    public Value evaluate(Map<Ident, Value> variables)
    {
        Value rhs = this.rhs.evaluate(variables);
        Value lhs = this.lhs.evaluate(variables);
        return lhs .or(rhs);
    }

}
