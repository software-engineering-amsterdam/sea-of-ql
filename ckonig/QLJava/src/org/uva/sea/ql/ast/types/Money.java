package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;
import org.uva.sea.ql.common.interfaces.TypeVisitor;

public class Money extends Type {
    private Expr expr;

    public Money() {
    }

    public Money(Expr e) {
        this.expr = e;
    }

    public final Expr getExpr() {
        return this.expr;
    }

    @Override
    public final void accept(TypeVisitor v) {
        v.visit(this);
    }

    @Override
    public final void accept(EvaluationVisitor visitor) throws VisitorException {
       visitor.visit(this);
    }

}
