package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.expressions.Expr;

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
        if (o instanceof String) {
            return this.getValue().equals((String) o);
        }
        if (o instanceof StringLiteral) {
            return this.getValue().equals(((StringLiteral) o).getValue());
        }
        return false;
    }
}
