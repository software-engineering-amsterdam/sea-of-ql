package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;

public class Pos extends UnaryMathOperator {
    public static final String STR = "+";

    public Pos(Expr ex) {
        super(ex);
    }

    @Override
    public final String toString() {
        return STR;
    }

}
