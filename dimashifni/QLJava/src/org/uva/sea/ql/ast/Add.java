package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.value.Value;

public class Add extends Expr {
    private Expr lhs;
    private Expr rhs;

	public Add (Expr lhs, Expr rhs)
	{
        this.lhs = lhs;
        this.rhs = rhs;
	}

    @Override
    public Value evaluate() {
        Value lhs = this.lhs.evaluate();
        Value rhs = this.rhs.evaluate();
        return lhs.add(rhs);
    }
}
