package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Accepts;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;

public class And extends BinaryBooleanOperator implements Accepts {
    public static final String STR = "&&";

    public And(Expr left, Expr right) {
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
