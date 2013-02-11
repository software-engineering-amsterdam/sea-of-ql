package org.uva.sea.ql.ast.types;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;

public class Money extends Type implements Returns {
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
    public ReturnTypes getReturnType(List<Question> questions) {
        return ReturnTypes.MATH;
    }

}
