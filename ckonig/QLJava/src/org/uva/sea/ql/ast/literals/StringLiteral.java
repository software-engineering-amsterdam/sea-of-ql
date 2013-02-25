package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

public class StringLiteral extends Expr {

    private final String value;

    public StringLiteral(String s) {
        this.value = s.replace("\"", "");
    }

    public final String getValue() {
        return this.value;
    }

    @Override
    public final String toString() {
        return this.value;
    }

    @Override
    public final boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o instanceof String) {
            return this.getValue().equals((String) o);
        }

        if (o instanceof StringLiteral) {
            return this.getValue().equals(((StringLiteral) o).getValue());
        }

        return false;
    }

    public final boolean isEmpty() {
        return this.value == null || "".equals(this.value.trim());
    }

    public final StringLiteral replaceCommaWithDot() {
        return new StringLiteral(this.value.replace(',', '.'));
    }

    @Override
    public final void accept(ExpressionVisitor visitor) throws QLException {
        visitor.visit(this);
    }
}
