package org.uva.sea.ql.ast.literal;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;

public class StringLiteral extends Expr implements Returns {
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
    public ReturnTypes getReturnType(List<Question> questions) {
        return ReturnTypes.OTHER;
    }
}
