package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.value.MoneyValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/27/13
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Money extends Expr {

    private final MoneyValue value;

    public Money(double n) {
        this.value = new MoneyValue(n);
    }

    public MoneyValue getValue() {
        return value;
    }

    @Override
    public Value evaluate(Map<Ident, Value> variables) {
        return value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
