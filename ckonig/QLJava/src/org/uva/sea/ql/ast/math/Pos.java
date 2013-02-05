package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Accepts;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;

public class Pos extends UnaryMathOperator implements Accepts {
    public static final String STR = "+";

    public Pos(Expr ex) {
        super(ex);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public ReturnTypes accepts() {
        return ReturnTypes.MATH;
    }
}
