package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

    @Override
    public Value evaluate()
    {
        // TODO
        return null;
    }
}
