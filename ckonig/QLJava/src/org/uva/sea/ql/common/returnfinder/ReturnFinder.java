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

    public ReturnFinder(List<Question> q, Expression e) throws QLException {
        this.visitor = new ReturnFinderExpressionVisitor(q);
        e.accept((ExpressionVisitor) this.visitor);
    }

    public ReturnFinder(List<Question> q, AbstractType t) {
        this.visitor = new ReturnFinderTypeVisitor(q);
        t.accept((TypeVisitor) this.visitor);
    }

    public final Class<?> getResult() {
        return this.visitor.getResult();
    }
}
