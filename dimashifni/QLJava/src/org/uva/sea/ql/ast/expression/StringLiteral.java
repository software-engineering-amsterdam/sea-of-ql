package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.*;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringLiteral extends Expr {
    private final StringValue value;

    public StringLiteral(String value) {
        this.value = new StringValue(value);
    }

    public StringValue getValue()
    {
        return this.value;
    }

    @Override
    public Value evaluate(Map<Ident, Value> variables) {
        return value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Type getType() {
        return this.value.getType();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
