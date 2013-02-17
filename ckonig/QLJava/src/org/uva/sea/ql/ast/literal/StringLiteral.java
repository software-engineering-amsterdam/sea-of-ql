package org.uva.sea.ql.ast.literal;

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
}
