package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;

public class Sub extends BinaryMathOperator {
    public static final String STR = "-";

    public Sub(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public final String toString() {
        return STR;
    }
}
