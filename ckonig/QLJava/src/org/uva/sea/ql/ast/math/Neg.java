package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;

public class Neg extends UnaryMathOperator {
    public static final String STR = "-";

    public Neg(Expr ex) {
        super(ex);
    }

    @Override
    public final String toString() {
        return STR;
    }

}
