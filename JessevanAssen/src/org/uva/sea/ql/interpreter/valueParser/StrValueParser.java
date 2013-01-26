package org.uva.sea.ql.interpreter.valueParser;

import org.uva.sea.ql.ast.expr.value.Str;
import org.uva.sea.ql.ast.expr.value.Value;

public class StrValueParser implements ValueParser {
    private static final Str DEFAULT = new Str("");

    @Override
    public Value parseValue(String value) {
        return new Str(value);
    }

    @Override
    public Value getDefault() {
        return DEFAULT;
    }
}
