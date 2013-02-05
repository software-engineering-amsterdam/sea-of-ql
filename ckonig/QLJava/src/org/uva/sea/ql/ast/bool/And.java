package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsBoolOperands;

public class And extends BinaryBooleanOperator implements AcceptsBoolOperands {
    public static final String STR = "&&";

    public And(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public final String toString() {
        return STR;
    }
}
