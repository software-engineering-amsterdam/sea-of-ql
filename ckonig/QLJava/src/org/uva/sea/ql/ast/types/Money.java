package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.TypeVisitor;
import org.uva.sea.ql.common.VisitorException;

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
    public void accept(TypeVisitor v) {
        v.visit(this);
    }

    @Override
    public void accept(EvaluationVisitor visitor) throws VisitorException {
       visitor.visit(this);
    }

}
