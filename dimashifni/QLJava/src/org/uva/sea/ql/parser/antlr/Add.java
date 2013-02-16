package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.Expr;

public class Add extends Expr {

    private Expr lhs;
    private Expr rhs;

	public Add (Expr lhs, Expr rhs)
	{
        this.lhs = lhs;
        this.rhs = rhs;
	}

    @Override
    public int evaluate() {
        return this.lhs.evaluate() + this.rhs.evaluate();
    }
}
