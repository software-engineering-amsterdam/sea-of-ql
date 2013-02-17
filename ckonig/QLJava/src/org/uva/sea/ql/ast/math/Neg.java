package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;

public class Neg extends UnaryMathOperator {
    public static final String STR = "-";

    public Neg(Expr ex) {
        super(ex);
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
