package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.value.Value;

public class Pos extends Expr {

    private final Expr x;

	public Pos(Expr x)
	{
        this.x = x;
	}

    @Override
    public Value evaluate()
    {
        // TODO
        return null;
    }

}
