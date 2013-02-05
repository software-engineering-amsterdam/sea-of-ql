package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsMathOperands;

public class Pos extends UnaryMathOperator implements AcceptsMathOperands {
    public static final String STR = "+";

    public Pos(Expr ex) {
        super(ex);
    }

    @Override
    public final String toString() {
        return STR;
    }
}
