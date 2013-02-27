package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

import java.util.Map;

public class Add extends Expr {
    private Expr lhs;
    private Expr rhs;

	public Add (Expr lhs, Expr rhs)
	{
        this.lhs = lhs;
        this.rhs = rhs;
	}

    @Override
    public Value evaluate(Map<Ident, Value> variables) {
        Value lhs = this.lhs.evaluate(variables);
        Value rhs = this.rhs.evaluate(variables);
        return lhs.add(rhs);
    }
}
