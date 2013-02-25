package org.uva.sea.ql.common.returnfinder;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

public final class ReturnFinder {

    private ReturnFinderExpressionVisitor visitor;

    private ReturnFinder(List<Question> q, Expr e) throws QLException {
        this.visitor = new ReturnFinderExpressionVisitor(q);
        e.accept((ExpressionVisitor) this.visitor);
    }

    private final AbstractType getResult() {
        return this.visitor.getResult();
    }

    public static AbstractType getResult(List<Question> q, Expr e)
            throws QLException {
        final ReturnFinder finder = new ReturnFinder(q, e);
        return finder.getResult();
    }
}
