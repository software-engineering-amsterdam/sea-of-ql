package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Accepts;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;

public class Or extends BinaryBooleanOperator implements Accepts {
    public static final String STR = "||";

    public Or(Expr left, Expr right) {
        super(left, right);
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
