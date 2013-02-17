package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;

public class Not extends UnaryBooleanOperator {
    public static final String STR = "!";

    public Not(Expr ex) {
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
