package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.VisitorException;

public class Or extends BinaryBooleanOperator {
    public static final String STR = "||";

    public Or(Expr left, Expr right) {
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
