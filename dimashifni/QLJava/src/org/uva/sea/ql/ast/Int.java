package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;

import java.util.Map;

// TODO Bool, Str, Money
public class Int extends Expr {

	private final IntegerValue value;

	public Int(int n) {
		this.value = new IntegerValue(n);
	}

	public IntegerValue getValue() {
		return value;
	}

    @Override
    public Value evaluate(Map<Ident, Value> variables)
    {
        return value;
    }
}
