package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Accepts;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;

public class Not extends UnaryBooleanOperator implements Accepts {
	public static final String STR = "!";

	public Not(Expr ex) {
		super(ex);
	}

	@Override
	public final String toString() {
		return STR;
	}

    @Override
    public ReturnTypes accepts() {
       return ReturnTypes.BOOLEAN;
    }
}
