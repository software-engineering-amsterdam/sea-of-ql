package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Accepts;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.common.ExprVisitor;
import org.uva.sea.ql.common.VisitorException;

public class Eq extends BinaryBooleanOperator implements Accepts {
    public static final String STR = "==";

    public Eq(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public boolean accepts(ReturnTypes r) {
        return r.equals(ReturnTypes.BOTH);
    }

    @Override
    public void accept(ExprVisitor visitor) throws VisitorException {
        visitor.visit(this);
    }
}
