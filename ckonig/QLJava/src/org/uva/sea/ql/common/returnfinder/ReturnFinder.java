package org.uva.sea.ql.common.returnfinder;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.interfaces.Expression;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.TypeVisitor;

public class ReturnFinder {

    private AbstractReturnFinderVisitor visitor;

    private ReturnFinder(List<Question> q, Expression e) throws QLException {
        this.visitor = new ReturnFinderExpressionVisitor(q);
        e.accept((ExpressionVisitor) this.visitor);
    }

    private ReturnFinder(List<Question> q, AbstractType t) {
        this.visitor = new ReturnFinderTypeVisitor(q);
        t.accept((TypeVisitor) this.visitor);
    }

    private final Class<?> getResult() {
        return this.visitor.getResult();
    }

    public static Class<?> getResult(List<Question> q, AbstractType t) {
        final ReturnFinder finder = new ReturnFinder(q, t);
        return finder.getResult();
    }

    public static Class<?> getResult(List<Question> q, Expression e)
            throws QLException {
        final ReturnFinder finder = new ReturnFinder(q, e);
        return finder.getResult();
    }
}
