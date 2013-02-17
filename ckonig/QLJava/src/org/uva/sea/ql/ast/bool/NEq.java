package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;

public class NEq extends BinaryBooleanOperator implements Evaluatable {
    private static final String STR = "!=";

    public NEq(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public void accept(EvaluationVisitor visitor) throws QLException {
        visitor.visit(this);
    }

}
