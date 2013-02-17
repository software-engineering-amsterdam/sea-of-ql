package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;

public class LEq extends BinaryBooleanOperator {
    public static final String STR = "<=";

    public LEq(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public void accept(EvaluationVisitor visitor) throws VisitorException {
        visitor.visit(this);
    }
}
