package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.value.Value;

public class Or extends Expr {
    private final Expr lhs;
    private final Expr rhs;

	public Or(Expr lhs, Expr rhs)
	{
		this.rhs  = rhs;
        this.lhs = lhs;
	}

    @Override
    public Value evaluate()
    {
        Value rhs = this.rhs.evaluate();
        Value lhs = this.lhs.evaluate();
        return lhs .or(rhs);
    }

}
