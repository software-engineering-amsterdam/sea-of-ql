package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Accepts;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;

public class Div extends BinaryMathOperator implements Accepts {
    public static final String STR = "/";

    public Div(Expr left, Expr right) {
        super(left, right);
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
