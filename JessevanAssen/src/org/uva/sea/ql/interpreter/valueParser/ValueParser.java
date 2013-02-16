package org.uva.sea.ql.interpreter.valueParser;

import org.uva.sea.ql.ast.expression.value.Value;

public interface ValueParser {
    public Value parseValue(String value);
    public Value getDefault();
}
